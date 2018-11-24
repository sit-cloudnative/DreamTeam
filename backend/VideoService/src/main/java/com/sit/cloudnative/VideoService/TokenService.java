package com.sit.cloudnative.VideoService;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
    
    @Value("${token.maxAgeSeconds}")
    private long maxAgeSeconds;
    
    @Value("${token.secret}") 
    private String secret;
    
    private Algorithm algorithm;
    
    private JWTVerifier verifier;
    
    public TokenService() {
    }
    
    @PostConstruct
    private void init(){
        algorithm = Algorithm.HMAC256(secret);
        verifier = JWT.require(algorithm).build();
    }
    
    public DecodedJWT checkToken(String token){
        DecodedJWT djwt = verifier.verify(token);
        return djwt;
    }
    
    public String getUser(String token){
        DecodedJWT djwt = checkToken(token);
        Claim claim = djwt.getClaim("username");
        return claim.asString();
    }
}

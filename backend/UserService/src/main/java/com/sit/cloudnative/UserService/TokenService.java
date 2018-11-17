package com.sit.cloudnative.UserService;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
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
    
    public String createToken(User user){
        LocalDateTime now = LocalDateTime.now();
        try{
            return JWT.create()
                    .withIssuer("UserService")
                    .withIssuedAt(Date.from(now
                            .atZone(ZoneId.systemDefault()).toInstant()))
                    .withExpiresAt(Date.from(now
                            .plusSeconds(maxAgeSeconds)
                            .atZone(ZoneId.systemDefault()).toInstant()))
                    .withClaim("username", user.getUsername())
                    .withClaim("firstname", user.getFirstname())
                    .withClaim("lastname", user.getLastname())
                    .withClaim("year", user.getYear())
                    .sign(algorithm);
        }catch(JWTCreationException e){
            throw new JWTCreationException("Cannot properly create token", e);
        }
    }
    
    public DecodedJWT checkToken(String token) throws JWTVerificationException{
        DecodedJWT djwt = verifier.verify(token);
        return djwt;
    }
    
    public String getUser(String token){
        DecodedJWT djwt = checkToken(token);
        Claim claim = djwt.getClaim("user");
        return claim.asString();
    }
}

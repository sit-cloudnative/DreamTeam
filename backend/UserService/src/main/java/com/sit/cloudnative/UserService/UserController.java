package com.sit.cloudnative.UserService;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.InvalidClaimException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.sit.cloudnative.UserService.exception.BadRequestException;
import com.sit.cloudnative.UserService.exception.NotFoundException;
import com.sit.cloudnative.UserService.exception.UnauthorizedException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/login")
    public ResponseEntity<User> authenticate(@Valid @RequestBody HashMap<String, String> inputUser,
                                             HttpServletRequest request) {
        checkUsernameAndPassword(inputUser);
        try {
            User user = userService.findByUsernameAndPassword(inputUser.get("username"), inputUser.get("password"));
            String token = tokenService.createToken(user);
            logger.info(System.currentTimeMillis() + " | " + request.getRemoteAddr() + " | " + "login to " + inputUser.get("username"));
            user.setToken(token);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } catch (HttpClientErrorException | NullPointerException e) {
            logger.warn(System.currentTimeMillis() + " | " + request.getRemoteAddr() + " | " + "userame or password is invalid");
            throw new NotFoundException("Not Found user. incorrect username or password.");
        }
    }

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user,
                                           HttpServletRequest request) {
        if (user == null) {
            logger.warn(System.currentTimeMillis() + " | " + request.getRemoteAddr() + " | " + "request body does not have username or password");
            throw new BadRequestException("RequestBody not have user");
        }
        try {
            User newUser = userService.createUser(user);
            logger.info(System.currentTimeMillis() + " | " + request.getRemoteAddr() + " | " + "created user " + user.getUsername());
            return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
        } catch (HttpClientErrorException e) {
            logger.warn(System.currentTimeMillis() + " | " + request.getRemoteAddr() + " | " + "duplicate username in database (" + user.getUsername() + ")");
            throw new BadRequestException(e.getMessage());
        }
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUserList(@RequestHeader("Authorization") String auth,
                                                  HttpServletRequest request) {
        validateToken(auth, request);
        return new ResponseEntity<List<User>>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<User> getUser(@PathVariable String username, 
                                        @RequestHeader("Authorization") String auth,
                                        HttpServletRequest request ) {
        validateToken(auth, request);
        try {
            User user = userService.findByUsername(username);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } catch (HttpClientErrorException e) {
            logger.warn(System.currentTimeMillis() + " | " + tokenService.getUser(auth) + " | " + "not found username (" + username + ")");
            throw new NotFoundException(e.getMessage());
        }
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Long> deleteUser(@PathVariable long id, 
                                           @RequestHeader("Authorization") String auth,
                                           HttpServletRequest request)  {
        validateToken(auth, request);
        try {
            long deleteId = userService.deleteById(id);
            logger.info(System.currentTimeMillis() + " | " + tokenService.getUser(auth) + " | " + "delete user (" + id + ")");
            return new ResponseEntity<Long>(deleteId, HttpStatus.OK);
        } catch (HttpClientErrorException e) {
            logger.warn(System.currentTimeMillis() + " | " + tokenService.getUser(auth) + " | " + "not found user id (" + id + ")");
            throw new NotFoundException(e.getMessage());
        }
    }
    
    private void checkUsernameAndPassword(HashMap<String, String> inputUser){
        if(!inputUser.isEmpty()){
            if (!inputUser.containsKey("username")) {
                logger.warn(System.currentTimeMillis() + " | " + "unknown user" + " | " + "request body does not contain username");
                throw new BadRequestException("RequestBody incorrect.");
            }
            if (!inputUser.containsKey("password")){
                logger.warn(System.currentTimeMillis() + " | " + "unknown user" + " | " + "request body does not contain password");
                throw new BadRequestException("RequestBody incorrect.");
            }
        }else{
            logger.warn("User try to login with null RequestBody");
            throw new BadRequestException("RequestBody incorrect.");
        }
    }

    private void validateToken (String auth, HttpServletRequest request) {
        if(auth.trim().isEmpty()){
            logger.warn(System.currentTimeMillis() + " | " + request.getRemoteAddr() + " | " + "Authorization token not found in header");
            throw new BadRequestException("Not have value in Authorization");
        }
        try {
            tokenService.checkToken(auth);
        } catch (AlgorithmMismatchException e) { // not match
            logger.warn(System.currentTimeMillis() + " | " + request.getRemoteAddr() + " | " + "not match token algorithm (" + auth + ")");
            throw new UnauthorizedException(e.getMessage());
        } catch (SignatureVerificationException e) { // secret key bad
            logger.warn(System.currentTimeMillis() + " | " + request.getRemoteAddr() + " | " + "secret key is not valid (" + auth + ")");
            throw new UnauthorizedException(e.getMessage());
        } catch (TokenExpiredException e) { // expired
            logger.warn(System.currentTimeMillis() + " | " + request.getRemoteAddr() + " | " + "token is expired (" + auth + ")");
            throw new UnauthorizedException(e.getMessage());
        } catch (InvalidClaimException e) { // invalid claim
            logger.warn(System.currentTimeMillis() + " | " + request.getRemoteAddr() + " | " + "invalid claim value (" + auth + ")");
            throw new UnauthorizedException(e.getMessage());
        } catch (JWTDecodeException e) {
            logger.warn(System.currentTimeMillis() + " | " + request.getRemoteAddr() + " | " + "token does not contain 3 parts (" + auth + ")");
            throw new UnauthorizedException(e.getMessage());
        } catch (Exception e) {
            logger.warn(System.currentTimeMillis() + " | " + request.getRemoteAddr() + " | " + "unknown error (" + auth + ")");
        }
    }
}

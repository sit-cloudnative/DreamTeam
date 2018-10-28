package com.sit.cloudnative.UserService.user;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<User> authenticate(@Valid @RequestBody UserAuthentication userAuthentication) {
        String username = userAuthentication.getUsername();
        String password = userAuthentication.getPassword();
        User user_return = userService.findUserByUsernameAndPassword(username, password);
        return new ResponseEntity<User>(user_return, HttpStatus.OK);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ResponseEntity<String> logout() {
        String message = "Logout success...";
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }

}
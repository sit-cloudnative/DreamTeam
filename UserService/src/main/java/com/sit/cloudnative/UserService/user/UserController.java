package com.sit.cloudnative.UserService.user;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
        return new ResponseEntity<>(user_return, HttpStatus.OK);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ResponseEntity<String> logout() {
        String message = "Logout success...";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{studentId}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserByStudentId(@PathVariable long studentId) {
        return new ResponseEntity<>(userService.findUserByStudentId(studentId),  HttpStatus.OK);
    }
}
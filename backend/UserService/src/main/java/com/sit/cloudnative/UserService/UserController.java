package com.sit.cloudnative.UserService;

import java.util.HashMap;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<User> authenticate(@RequestBody HashMap<String,String> inputUser) {
        User user = userService.findByUsernameAndPassword(inputUser.get("username"), inputUser.get("password"));
        String token = tokenService.createToken(user);
        user.setToken(token);
        return new ResponseEntity<User>(user , HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        return new ResponseEntity<User>(userService.createUser(user), HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUserList() {
        return new ResponseEntity<List<User>>(userService.findAll(), HttpStatus.OK);
    }
    
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable long id){
        return new ResponseEntity<User>(userService.findById(id), HttpStatus.OK);
    }
    
}

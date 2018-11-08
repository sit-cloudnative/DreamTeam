package com.sit.cloudnative.UserService.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService{

    @Autowired
    private UserRepository userRepository;

    public User findUserByUsernameAndPassword(String username, String password){
        User user = userRepository.findUserByUsernameAndPassword(username, password).get();
        return user;
    }
    
    public User findUserByStudentId(long studentId){
        User user = userRepository.findById(studentId).get();
        return user;
    }
}
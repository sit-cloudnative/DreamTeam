package com.sit.cloudnative.UserService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    public User createUser(User user) {
        String password = user.getPassword();
        String hashPassword = password.hashCode() + "";
        user.setPassword(hashPassword);
        return userRepository.save(user);
    }
    
    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findByUsernameAndPassword(String username, String password) {
        password = password.hashCode() + "";
        User user = userRepository.findByUsernameAndPassword(username, password);
        return user;
    }
    
    public User findById(long id){
        return userRepository.findById(id).get();
    }

}

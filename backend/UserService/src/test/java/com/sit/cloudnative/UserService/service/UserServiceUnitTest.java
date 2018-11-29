package com.sit.cloudnative.UserService.service;

import com.sit.cloudnative.UserService.User;
import com.sit.cloudnative.UserService.UserRepository;
import com.sit.cloudnative.UserService.UserService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
@SpringBootConfiguration
@SpringBootTest(classes=UserService.class)
public class UserServiceUnitTest {

    @Autowired
    private UserService userService;
    @Mock
    private UserRepository userRepository;
    private List<User> users;

    @Before
    public void setUp() throws Exception{
        this.userService = new UserService(userRepository);
        users = new ArrayList<>();
        users.add(new User("1", "password", "firstname", "lastname", "department", "faculty", 3, "student"));
        users.add(new User("2", "password", "firstname", "lastname", "department", "faculty", 3, "student"));
    }

    @Test
    public void createUserSuccessful() throws Exception{
        doAnswer(returnsFirstArg()).when(userRepository).save(any(User.class));
        User user = new User("username", "password", "firstname", "lastname", "department", "faculty", 3, "student");

        User userResponse = userService.createUser(user);

        assertThat(userResponse.getFirstname()).isEqualTo("firstname");
        assertThat(userResponse.getLastname()).isEqualTo("lastname");
        assertThat(userResponse.getPassword()).isNotEqualTo("password");
        verify(userRepository).save(any(User.class));
    }

    @Test
    public void listUsers() {
        when(userRepository.findAll()).thenReturn(users);

        int usersResponse = userService.findAll().size();

        assertThat(usersResponse).isGreaterThanOrEqualTo(1);
        verify(userRepository).findAll();
    }

    @Test
    public void loginUser59130500075() {
        when(userRepository.findByUsernameAndPassword("59130500075", "57000503195".hashCode()+""))
            .thenReturn(new User("59130500075",
                                 "57000503195", 
                                 "firstname", 
                                 "lastname", 
                                 "department", 
                                 "faculty", 
                                 3, 
                                 "student"));

        User userResponse = userService.findByUsernameAndPassword("59130500075", "57000503195");

        assertThat(userResponse.getUsername()).isEqualTo("59130500075");
        verify(userRepository).findByUsernameAndPassword("59130500075", "57000503195".hashCode()+"");
    }

    @Test
    public void deleteUser10() {
        doNothing().when(userRepository).deleteById(anyLong());

        long idResponse = userService.deleteById(10);

        assertThat(idResponse).isEqualTo(10);
        verify(userRepository).deleteById(anyLong());
    }

    @Test
    public void findByUsername59130500075() {
        when(userRepository.findByUsername("59130500075"))
            .thenReturn(new User("59130500075",
                                 "password", 
                                 "firstname", 
                                 "lastname", 
                                 "IT", 
                                 "SIT", 
                                 3, 
                                 "student"));

        User userResponse = userService.findByUsername("59130500075");

        assertThat(userResponse.getUsername()).isEqualTo("59130500075");
        verify(userRepository).findByUsername(anyString());
    }
}
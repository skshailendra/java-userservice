package com.example.userservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.userservice.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    // This class will contain the business logic for user management
    // For now, it's empty but can be filled with methods to handle user operations
    // such as creating, updating, deleting, and retrieving users.
    private final List<User> users = new ArrayList<>();

    public UserService(){
        users.add(new User( (long) 123,"Shailendra","abc@gmail.com"));
        users.add(new User( (long) 1234,"Singh","abc2@gmail.com"));
        users.add(new User( (long) 12345,"Bunny","abc3@gmail.com"));
        users.add(new User( (long) 123456,"Code Bunny","abc4@gmail.com"));
    }

    // Get User By Id Uer Optional here to avoid null pointer exceptions
    public Optional<User> getUserById(Long id){
        System.out.println("Inside Service ::  id:" + id);
        return users.stream().filter(user -> user.getId().equals(id)).findFirst();
    }
    
    // Get All usrs
    public List<User> getAllUsers(){
        return users;
    }
}

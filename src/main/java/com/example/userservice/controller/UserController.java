package com.example.userservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.userservice.model.User;
import com.example.userservice.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/users")
public class UserController {
    // This class will handle HTTP requests related to user management
    // It will use the UserService to perform operations on users
    // For now, it's empty but can be filled with methods to handle user-related
    // requests
    // such as creating, updating, deleting, and retrieving users.

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
    System.out.println("Inside Controller");
    System.out.println("User id params:" + userId);
    ResponseEntity<User> responseUser = userService.getUserById(userId)
    .map(ResponseEntity::ok)
    .orElseGet(() -> ResponseEntity.status(200).body(new User((long)0,
    null, null)));
    System.out.println("User found: " + responseUser);
    return responseUser;
    }

//    @GetMapping("/users")
//    public ResponseEntity<User> getUserByQueryParam(@RequestParam Long userId, @RequestParam Long name) {
//        System.out.println("New GetMapping User id query param: " + userId);
//        System.out.println("New GetMapping User id query param: " + name);
//        ResponseEntity<User> responseUser = userService.getUserById(userId)
//                .map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.status(404).body(new User("User not found", null, null)));
//        System.out.println("User found: " + responseUser);
//        return responseUser;
//    }

    // Handle the required query params
    // @RequestParam is used to extract query parameters from the URL
    // @RequestParam(value = "userId", required = false) Long userId
    // @RequestParam(value = "userName", required = false) String userName
//    @GetMapping("/usersMap")
//    public ResponseEntity<?> getUserByMultipleQueryParams(@RequestParam Long userId,
//            @RequestParam String userName) {
//        System.out.println("User id query param: " + userId);
//        System.out.println("User name query param: " + userName);
//        return ResponseEntity.status(404).body("User not found");
//         if (userId != null) {
//         ResponseEntity<User> responseUser = userService.getUserById(userId)
//         .map(ResponseEntity::ok)
//         .orElseGet(() -> ResponseEntity.status(404).body(new User("User not found",
//         null, null)));
//         System.out.println("User found by ID: " + responseUser);
//         return responseUser;
//         } else if (userName != null) {
//         // ResponseEntity<User> responseUser = userService.getUserByName(userName)
//         // .map(ResponseEntity::ok)
//         // .orElseGet(() -> ResponseEntity.status(404).body(new User("User not
//         found",
//         // null, null)));
//         System.out.println("User found by Name: " + "responseUser");
//         return ResponseEntity.ok("{\"name\": \"User found by Name\"}");
//         } else {
//         return ResponseEntity.badRequest().body("Either userId or userName must be
//         provided.");
//         }
//    }
}

package com.example.mymail2.controller;

import com.example.mymail2.model.User;
import com.example.mymail2.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @PostMapping("/register")
//    public ResponseEntity<String> registerUser(@RequestBody UserRegistrationDTO userDto) {
//        User user = userService.registerUser(userDto);
//        return ResponseEntity.ok("User registered successfully with ID: " + user.getId());
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<String> loginUser(@RequestBody UserLoginDTO userDto) {
//        String token = userService.loginUser(userDto);
//        return ResponseEntity.ok(token);
//    }
//
//    @PostMapping("/logout")
//    public ResponseEntity<String> logoutUser(@RequestHeader("Authorization") String authToken) {
//        userService.logoutUser(authToken);
//        return ResponseEntity.ok("User logged out successfully.");
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody UserUpdateDTO userDto) {
//        userService.updateUser(id, userDto);
//        return ResponseEntity.ok("User updated successfully.");
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
//        userService.deleteUser(id);
//        return ResponseEntity.ok("User deleted successfully.");
//    }
}

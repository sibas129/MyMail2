package com.example.mymail2.service;

import com.example.mymail2.exceptions.InvalidCredentialsException;
import com.example.mymail2.exceptions.UserAlreadyExistsException;
import com.example.mymail2.model.User;
import com.example.mymail2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(String username, String email, String password) throws UserAlreadyExistsException {
        if(userRepository.findByUsername(username) != null) {
            throw new UserAlreadyExistsException("Username already taken: " + username);
        }
        if(userRepository.findByEmail(email) != null) {
            throw new UserAlreadyExistsException("Email already registered: " + email);
        }
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        return userRepository.save(user);
    }

    public User authenticateUser(String username, String password) throws InvalidCredentialsException {
        User user = userRepository.findByUsername(username);
        if(user == null || !passwordEncoder.matches(password, user.getPassword())) {
            throw new InvalidCredentialsException("Invalid username or password");
        }
        return user;
    }

    public void changePassword(User user, String oldPassword, String newPassword)
            throws InvalidCredentialsException {
        if(!passwordEncoder.matches(oldPassword, user.getPassword())) {
            throw new InvalidCredentialsException("Incorrect old password");
        }
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }

}

package com.femcoders.toy_store_backend.services;

import com.femcoders.toy_store_backend.models.User;
import com.femcoders.toy_store_backend.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    public final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User addUser(User newUser){
        return userRepository.save(newUser);
    }

    public User updateUser(User user, User updatedUser){
        user.setUsername(updatedUser.getUsername());
        user.setEmail(updatedUser.getEmail());
        user.setPassword(updatedUser.getPassword());
        return userRepository.save(user);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }
}
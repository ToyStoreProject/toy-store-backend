package com.femcoders.toy_store_backend.controllers;

import com.femcoders.toy_store_backend.models.User;
import com.femcoders.toy_store_backend.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @PostMapping
    public void addUser(@RequestBody User newUser) {
        userService.addUser(newUser);
    }

//    @PostMapping("/new-phrase")
//
//    public ResponseEntity<Phrase> addPhrase(@RequestBody Phrase newPhrase) {
//
//        Phrase createdPhrase = phraseService.addPhrase(newPhrase);
//
//        return new ResponseEntity<Phrase>(createdPhrase, HttpStatus.CREATED);
//
//
//
//    }
}

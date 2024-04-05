package com.userservice.controllers;

import com.userservice.entities.User;
import com.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id)
    {
        return ResponseEntity.ok().body(userService.getSingleUser(id));
    }
    @PostMapping("")
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
    }
    @GetMapping("")
    public ResponseEntity<List<User>> getAllUsers()
    {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id,@RequestBody User user)
    {
        return ResponseEntity.ok(userService.updateUser(id,user));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id)
    {
        userService.deleteUser(id);
        return ResponseEntity.ok("User Deleted Successfully");
    }
}

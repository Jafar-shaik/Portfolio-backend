package com.jafar.portfolio.controller;

import com.jafar.portfolio.entity.User;
import com.jafar.portfolio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user){
        User addedUser = userService.addUser(user);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{_id}")
    public ResponseEntity<?> deleteUser(@PathVariable String _id){
        userService.deleteById(_id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/username/{username}")
    public ResponseEntity<?> deleteUserByUsername(@PathVariable String username){
        userService.deleteUser(username);
        return ResponseEntity.noContent().build();
    }
}

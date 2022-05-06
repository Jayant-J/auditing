package com.rakuten.auditing.controller;

import com.rakuten.auditing.demo.entity.User;
import com.rakuten.auditing.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("/getAll")
    public List<User> getALl() {
        return userService.getAll();
    }

    @GetMapping("/get/{id}")
    public User addUser(@PathVariable int id) {
        return userService.getById(id);
    }

    @PostMapping("/add")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @PutMapping("/edit/{id}")
    public void addUser(@PathVariable int id, @RequestParam String newName) {
        userService.editUser(id, newName);
    }

}

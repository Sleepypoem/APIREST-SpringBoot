package Sleepypoem.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Sleepypoem.demo.models.UserModel;
import Sleepypoem.demo.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ArrayList<UserModel> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public UserModel saveUser(@RequestBody UserModel user) {
        return this.userService.saveUser(user);
    }

    @GetMapping(path = "/{id}")
    public Optional<UserModel> getById(@PathVariable("id") Long id) {
        return this.userService.findById(id);
    }

    @GetMapping("/query")
    public ArrayList<UserModel> getByEmail(@RequestParam("email") String email) {
        return this.userService.findByEmail(email);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        if (this.userService.deleteUser(id)) {
            return "User " + id + " deleted successfully.";
        } else {
            return "Error deleting user.";
        }
    }
}

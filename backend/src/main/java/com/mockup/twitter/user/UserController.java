package com.mockup.twitter.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin

public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<UserPublicInfo> getAllUsers() {
        return userService.getAllUser();
    }

    @GetMapping()
    public UserPublicInfo getUserById(@RequestParam String id){
        return userService.getUserById(id);
    }

    @PostMapping("/new")
    public User createUser(@RequestBody UserRegisterDTO userRegisterDTO) {
        return userService.addUser(userRegisterDTO);
    }

}

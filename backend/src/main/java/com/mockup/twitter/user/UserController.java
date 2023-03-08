package com.mockup.twitter.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin

public class UserController {

    @GetMapping()
    public List<User> getAllUsers() {
        return List.of(
                new User(50L, "ingodinho", "ingo", "siemens", "ingo@email.de"),
                new User(51L, "ingodinho123", "ingo123", "siemens123", "ingo123@email.de")
        );
    }

}

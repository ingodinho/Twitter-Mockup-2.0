package com.mockup.twitter.user;

import com.mockup.twitter.utils.HashingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final HashingService hashingService;

    @Autowired
    public UserService(UserRepository userRepository, HashingService hashingService) {
        this.userRepository = userRepository;
        this.hashingService = hashingService;
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User addUser(UserRegisterDTO userRegisterDTO) {

        Optional<User> foundUser = userRepository.findByEmail(userRegisterDTO.getEmail());
        if(foundUser.isPresent()) {
            throw new IllegalStateException("User-Email already taken");
        }

        User newUser = new User(
                userRegisterDTO.getUsername(),
                userRegisterDTO.getFirstName(),
                userRegisterDTO.getLastName(),
                userRegisterDTO.getEmail()
        );
        newUser.setCreatedAt(LocalDateTime.now());

        String passwordSalt = hashingService.createRandomHash();
        String passwordHash = hashingService.getHashString(userRegisterDTO.getPassword() + passwordSalt);

        newUser.setPasswordSalt(passwordSalt);
        newUser.setPasswordHash(passwordHash);

        return userRepository.save(newUser);
    }
}

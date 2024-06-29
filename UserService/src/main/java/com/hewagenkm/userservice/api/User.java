package com.hewagenkm.userservice.api;

import com.hewagenkm.userservice.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class User {
    private final Logger logger = LoggerFactory.getLogger(User.class);

    @PostMapping
    public void createUser(UserDTO dto) {
        logger.info("Creating user");
    }

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable String id) {
        logger.info("Getting user with id: {}", id);
        return new UserDTO();
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable String id, UserDTO dto) {
        logger.info("Updating user with id: {}", id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        logger.info("Deleting user with id: {}", id);
    }

    @GetMapping
    public List<UserDTO> getUsers() {
        logger.info("Getting all users");
        return List.of(new UserDTO());
    }
}

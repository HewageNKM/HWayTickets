package com.hewagenkm.userservice.api;

import com.hewagenkm.userservice.dto.UserDTO;
import com.hewagenkm.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class User {
    private final UserService userService;
    private final Logger logger = LoggerFactory.getLogger(User.class);

    @PostMapping
    public void createUser(UserDTO dto) {
        logger.info("Creating user");
        userService.addUser(dto);
    }

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable Integer id) {
        logger.info("Getting user with id: {}", id);
        return userService.getUser(id);
    }

    @GetMapping("/email/{id}")
    public UserDTO getUserByEmail(@PathVariable String id) {
        logger.info("Getting user with email: {}", id);
        return userService.getUserByEmail(id);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable Integer id, UserDTO dto) {
        logger.info("Updating user with id: {}", id);
        userService.updateUser(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        logger.info("Deleting user with id: {}", id);
        userService.deleteUser(id);
    }

    @GetMapping
    public List<UserDTO> getUsers() {
        logger.info("Getting all users");
        return userService.getUsers(1, 10, "", "");
    }
}

package com.hewagenkm.userservice.service;

import com.hewagenkm.userservice.dto.UserDTO;
import com.hewagenkm.userservice.entity.User;
import com.hewagenkm.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void addUser(UserDTO dto) {
        userRepository.save(
                User.builder()
                        .userName(dto.getUserName())
                        .email(dto.getEmail())
                        .password(bCryptPasswordEncoder.encode(dto.getPassword()))
                        .build()
        );
        logger.info("User added");
    }

    @Override
    public List<UserDTO> getUsers(int page, int size, String filter, String sort) {
        logger.info("Getting all users");
        return userRepository.findAll().stream().map(user -> UserDTO.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .email(user.getEmail())
                .build()).toList();
    }

    @Override
    public void updateUser(Integer id, UserDTO dto) {
        userRepository.findById(id).ifPresent(user -> {
            user.setUserName(dto.getUserName());
            user.setEmail(dto.getEmail());
            user.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
            userRepository.save(user);
        });
        logger.info("User updated");
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
        logger.info("User deleted");
    }

    @Override
    public UserDTO getUser(Integer id) {
        logger.info("Getting user with id: {}", id);
        return userRepository.findById(id).map(user -> UserDTO.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .email(user.getEmail())
                .build()).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        logger.info("Getting user with email: {}", email);
        return userRepository.findByEmail(email).map(user -> UserDTO.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .email(user.getEmail())
                .build()).orElseThrow(() -> new RuntimeException("User not found"));
    }
}

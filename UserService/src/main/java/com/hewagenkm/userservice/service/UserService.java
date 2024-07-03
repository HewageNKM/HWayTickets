package com.hewagenkm.userservice.service;

import com.hewagenkm.userservice.dto.UserDTO;

import java.util.List;

public interface UserService {
    void addUser(UserDTO dto);
    List<UserDTO> getUsers(int page, int size, String filter, String sort);
    void updateUser(Integer id, UserDTO dto);
    void deleteUser(Integer id);
    UserDTO getUser(Integer id);
    UserDTO getUserByEmail(String email);
}

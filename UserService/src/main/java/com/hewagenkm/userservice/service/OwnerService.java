package com.hewagenkm.userservice.service;

import com.hewagenkm.userservice.dto.Integer;

import java.util.List;

public interface OwnerService {
    void addOwner(Integer dto);
    List<Integer> getOwners(int page, int size, String filter, String sort);
    void updateOwner(java.lang.Integer id, Integer dto);
    void deleteOwner(java.lang.Integer idd);
    Integer getOwner(java.lang.Integer id);
    Integer getOwnerByIDNumber(String IDNumber);
}

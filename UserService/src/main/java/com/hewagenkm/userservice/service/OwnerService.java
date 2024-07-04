package com.hewagenkm.userservice.service;

import com.hewagenkm.userservice.dto.OwnerDTO;

import java.util.List;

public interface OwnerService {
    void addOwner(OwnerDTO dto);
    List<OwnerDTO> getOwners(int page, int size, String filter, String sort);
    void updateOwner(java.lang.Integer id, OwnerDTO dto);
    void deleteOwner(java.lang.Integer idd);
    OwnerDTO getOwner(java.lang.Integer id);
}

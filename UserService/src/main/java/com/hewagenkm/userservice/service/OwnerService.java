package com.hewagenkm.userservice.service;

import com.hewagenkm.userservice.dto.OwnerDTO;

import java.util.List;

public interface OwnerService {
    void addOwner(OwnerDTO dto);
    List<OwnerDTO> getOwners(int page, int size, String filter, String sort);
    void updateOwner(Integer id, OwnerDTO dto);
    void deleteOwner(Integer idd);
    OwnerDTO getOwner(Integer id);
    OwnerDTO getOwnerByIDNumber(String IDNumber);
}

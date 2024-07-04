package com.hewagenkm.userservice.service;

import com.hewagenkm.userservice.dto.Owner;

import java.util.List;

public interface OwnerService {
    void addOwner(Owner dto);
    List<Owner> getOwners(int page, int size, String filter, String sort);
    void updateOwner(java.lang.Integer id, Owner dto);
    void deleteOwner(java.lang.Integer idd);
    Owner getOwner(java.lang.Integer id);
}

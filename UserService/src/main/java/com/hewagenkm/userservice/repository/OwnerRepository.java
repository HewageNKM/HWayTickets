package com.hewagenkm.userservice.repository;

import com.hewagenkm.userservice.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Integer> {
    Optional<Owner> findByIDNumber(String IDNumber);
}

package com.hewagenkm.userservice.service;

import com.hewagenkm.userservice.dto.OwnerDTO;
import com.hewagenkm.userservice.repository.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final Logger logger = LoggerFactory.getLogger(OwnerServiceImpl.class);

    @Override
    public void addOwner(OwnerDTO dto) {
        ownerRepository.save(
                com.hewagenkm.userservice.entity.Owner.builder()
                        .nic(dto.getNic())
                        .fullName(dto.getFullName())
                        .email(dto.getEmail())
                        .phone(dto.getPhone())
                        .address(dto.getAddress())
                        .build()
        );
        logger.info("Owner added");
    }

    @Override
    public List<OwnerDTO> getOwners(int page, int size, String filter, String sort) {
        logger.info("Getting all owners");
        return ownerRepository.findAll().stream().map(owner -> OwnerDTO.builder()
                .id(owner.getId())
                .nic(owner.getNic())
                .fullName(owner.getFullName())
                .email(owner.getEmail())
                .phone(owner.getPhone())
                .address(owner.getAddress())
                .build()).toList();
    }

    @Override
    public void updateOwner(java.lang.Integer id, OwnerDTO dto) {
        com.hewagenkm.userservice.entity.Owner owner = ownerRepository.findById(id).orElseThrow(() -> new RuntimeException("Owner not found"));
        owner.setNic(dto.getNic());
        owner.setFullName(dto.getFullName());
        owner.setEmail(dto.getEmail());
        owner.setPhone(dto.getPhone());
        owner.setAddress(dto.getAddress());

        ownerRepository.save(owner);
        logger.info("Owner updated");
    }

    @Override
    public void deleteOwner(java.lang.Integer id) {
        ownerRepository.deleteById(id);
        logger.info("Owner deleted");
    }

    @Override
    public OwnerDTO getOwner(java.lang.Integer id) {
        com.hewagenkm.userservice.entity.Owner owner = ownerRepository.findById(id).orElseThrow(() -> new RuntimeException("Owner not found"));
        logger.info("Getting owner with id: {}", id);
        return getOwnerDTO(owner);
    }


    private OwnerDTO getOwnerDTO(com.hewagenkm.userservice.entity.Owner owner) {
        return OwnerDTO.builder()
                .id(owner.getId())
                .nic(owner.getNic())
                .fullName(owner.getFullName())
                .email(owner.getEmail())
                .phone(owner.getPhone())
                .address(owner.getAddress())
                .build();
    }
}

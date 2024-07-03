package com.hewagenkm.userservice.api;

import com.hewagenkm.userservice.dto.OwnerDTO;
import com.hewagenkm.userservice.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/owners")
@RequiredArgsConstructor
public class Owner {
    private final OwnerService ownerService;
    private final Logger logger = LoggerFactory.getLogger(Owner.class);

    @PostMapping
    public void addOwner(@Validated @RequestBody OwnerDTO body) {
        logger.info("Adding owner");
    }

    @GetMapping("/{id}")
    public void getOwners(@PathVariable Integer id) {
        logger.info("Getting all owners");
    }

    @PutMapping("/{id}")
    public void updateOwner(@PathVariable Integer id, @Validated @RequestBody OwnerDTO body) {
        logger.info("Updating owner with id: {}", "xxxxxx");
    }

    @DeleteMapping("/{id}")
    public void deleteOwner(@PathVariable Integer id) {
        logger.info("Deleting owner with id: {}", "xxxxxx");
    }

    @GetMapping
    public void getOwner(@PathVariable Integer id) {
        logger.info("Getting owner with id: {}", "xxxxxx");
    }
}

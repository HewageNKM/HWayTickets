package com.hewagenkm.userservice.api;

import com.hewagenkm.userservice.dto.OwnerDTO;
import com.hewagenkm.userservice.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/owners")
@RequiredArgsConstructor
public class Owner {
    private final OwnerService ownerService;
    private final Logger logger = LoggerFactory.getLogger(Owner.class);

    @PostMapping
    public void addOwner(@Validated @RequestBody OwnerDTO body) {
        logger.info("Adding owner");
        ownerService.addOwner(body);
    }

    @GetMapping
    public List<OwnerDTO> getOwners() {
        logger.info("Getting all owners");
        return ownerService.getOwners(1, 10, "", "");
    }

    @PutMapping("/{id}")
    public void updateOwner(@PathVariable java.lang.Integer id, @Validated @RequestBody OwnerDTO body) {
        logger.info("Updating owner with id: {}", "xxxxxx");
        ownerService.updateOwner(id, body);
    }

    @DeleteMapping("/{id}")
    public void deleteOwner(@PathVariable java.lang.Integer id) {
        logger.info("Deleting owner with id: {}", "xxxxxx");
        ownerService.deleteOwner(id);
    }

    @GetMapping("/{id}")
    public OwnerDTO getOwner(@PathVariable java.lang.Integer id) {
        logger.info("Getting owner with id: {}", "xxxxxx");
        return ownerService.getOwner(id);
    }
}

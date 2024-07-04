package com.hewagenkm.ticketservice.service;

import com.hewagenkm.ticketservice.dto.OwnerDTO;
import com.hewagenkm.ticketservice.dto.TicketDTO;
import com.hewagenkm.ticketservice.dto.VehicleDTO;
import com.hewagenkm.ticketservice.entity.Owner;
import com.hewagenkm.ticketservice.entity.Ticket;
import com.hewagenkm.ticketservice.entity.Vehicle;
import com.hewagenkm.ticketservice.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class TicketServiceImpl implements TicketService {
    private final Logger logger = LoggerFactory.getLogger(TicketServiceImpl.class);
    private final TicketRepository ticketRepository;
    private final RestTemplate restTemplate;

    @Override
    public void createTicket(TicketDTO ticketDTO) {
        VehicleDTO vehicleDTO = restTemplate.getForObject("http://localhost:8080/api/v1/vehicles/license/" + ticketDTO.getLicencePlate(), VehicleDTO.class);
        if (vehicleDTO == null) {
            throw new RuntimeException("Vehicle not found");
        }
        OwnerDTO ownerDTO = restTemplate.getForObject("http://localhost:8080/api/v1/owners/" + vehicleDTO.getOwnerId(), OwnerDTO.class);
        if (ownerDTO == null) {
            throw new RuntimeException("Owner not found");
        }

        Vehicle vehicle = Vehicle.builder()
                .licensePlate(vehicleDTO.getLicensePlate())
                .classType(vehicleDTO.getClassType())
                .owner(Owner.builder()
                        .fullName(ownerDTO.getFullName())
                        .address(ownerDTO.getAddress())
                        .email(ownerDTO.getEmail())
                        .phone(ownerDTO.getPhone())
                        .nic(ownerDTO.getNic())
                        .build())
                .build();

        Ticket ticket = Ticket
                .builder()
                .entranceTerminal(ticketDTO.getEntrance())
                .exitTerminal(ticketDTO.getExit())
                .averageSpeed(ticketDTO.getAverageSpeed())
                .dateTime(LocalDateTime.now())
                .vehicle(vehicle).build();

        ticketRepository.save(ticket);

    }
}

package com.hewagenkm.ticketservice.service;

import com.hewagenkm.ticketservice.dto.TicketDTO;
import com.hewagenkm.ticketservice.dto.VehicleDTO;
import com.hewagenkm.ticketservice.entity.Ticket;
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
        VehicleDTO vehicleDTO = restTemplate.getForObject("http://vehicle-service/api/v1/vehicles/" + ticketDTO.getVehicleId(), VehicleDTO.class);
        if (vehicleDTO == null) {
            throw new RuntimeException("Vehicle not found");
        }
        Ticket ticket = Ticket.builder()
                .entranceTerminal(ticketDTO.getEntranceTerminal())
                .exitTerminal(ticketDTO.getExitTerminal())
                .status(ticketDTO.getStatus())
                .distance(ticketDTO.getDistance())
                .averageSpeed(ticketDTO.getAverageSpeed())
                .dateTime(LocalDateTime.now())
                .vehicleId(vehicleDTO.getId())
                .build();

        ticketRepository.save(ticket);
        logger.info("Ticket created");
    }

    @Override
    public void updateTicket(TicketDTO ticketDTO, Integer id) {
        VehicleDTO vehicleDTO = restTemplate.getForObject("http://vehicle-service/api/v1/vehicles/" + ticketDTO.getVehicleId(), VehicleDTO.class);
        if (vehicleDTO == null) {
            throw new RuntimeException("Vehicle not found");
        }
        Ticket ticket = ticketRepository.findById(id).orElseThrow(() -> new RuntimeException("Ticket not found"));
        ticket.setExitTerminal(ticketDTO.getExitTerminal());
        ticket.setEntranceTerminal(ticketDTO.getEntranceTerminal());
        ticket.setStatus(ticketDTO.getStatus());
        ticket.setDistance(ticketDTO.getDistance());
        ticket.setAverageSpeed(ticketDTO.getAverageSpeed());
        ticket.setVehicleId(vehicleDTO.getId());
        ticketRepository.save(ticket);
        logger.info("Updated ticket: {}", id);
    }

    @Override
    public TicketDTO getTicket(Integer id) {
        Ticket ticketNotFound = ticketRepository.findById(id).orElseThrow(() -> new RuntimeException("Ticket not found"));
        return TicketDTO.builder()
                .id(ticketNotFound.getId())
                .entranceTerminal(ticketNotFound.getEntranceTerminal())
                .exitTerminal(ticketNotFound.getExitTerminal())
                .status(ticketNotFound.getStatus())
                .distance(ticketNotFound.getDistance())
                .averageSpeed(ticketNotFound.getAverageSpeed())
                .dateTime(ticketNotFound.getDateTime())
                .vehicleId(ticketNotFound.getVehicleId())
                .build();
    }

    @Override
    public void updateTicketStatus(Integer id, TicketDTO ticketDTO) {
        Ticket ticket = ticketRepository.findById(id).orElseThrow(() -> new RuntimeException("Ticket not found"));
        ticket.setStatus(ticketDTO.getStatus());
        ticketRepository.save(ticket);
        logger.info("Updated ticket status to: {}", ticketDTO.getStatus());
    }
}

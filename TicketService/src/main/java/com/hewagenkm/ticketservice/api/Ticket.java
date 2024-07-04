package com.hewagenkm.ticketservice.api;

import com.hewagenkm.ticketservice.dto.TicketDTO;
import com.hewagenkm.ticketservice.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tickets")
public class Ticket {
    private final TicketService ticketService;
    private final Logger logger = LoggerFactory.getLogger(Ticket.class);

    @PostMapping
    public void createTicket(@Validated @RequestBody TicketDTO ticketDTO) {
        logger.info("Ticket created");
        ticketService.createTicket(ticketDTO);
    }

    @GetMapping("/{id}")
    public TicketDTO getTicket(@PathVariable String id) {
        return null;
    }

    @PutMapping("/{id}")
    public void updateTicket(@PathVariable String id) {

    }
}

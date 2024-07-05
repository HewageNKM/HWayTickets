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
        logger.info("Ticket creating");
        ticketService.createTicket(ticketDTO);
    }

    @GetMapping("/{id}")
    public TicketDTO getTicket(@PathVariable Integer id) {
        logger.info("Ticket retrieving");
        return ticketService.getTicket(id);
    }

    @PutMapping("/{id}")
    public void updateTicket(@PathVariable Integer id,@RequestBody TicketDTO ticketDTO){
        logger.info("Ticket updating");
        ticketService.updateTicket(ticketDTO, id);
    }

    @PutMapping("/status/{id}")
    public void updateTicketStatus(@PathVariable Integer id,@RequestBody TicketDTO ticketDTO) {
        logger.info("Ticket status updating");
        ticketService.updateTicketStatus(id, ticketDTO);
    }
}

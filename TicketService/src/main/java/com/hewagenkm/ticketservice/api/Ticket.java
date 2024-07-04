package com.hewagenkm.ticketservice.api;

import com.hewagenkm.ticketservice.dto.TicketDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tickets")
public class Ticket {

    @PostMapping
    public void createTicket() {
    }

    @GetMapping("/{id}")
    public TicketDTO getTicket(@PathVariable String id) {
        return null;
    }

    @PutMapping("/{id}")
    public void updateTicket(@PathVariable String id) {

    }
}

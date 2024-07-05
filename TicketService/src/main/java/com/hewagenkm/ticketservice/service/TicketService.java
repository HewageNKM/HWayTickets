package com.hewagenkm.ticketservice.service;

import com.hewagenkm.ticketservice.dto.TicketDTO;

public interface TicketService {
    void createTicket(TicketDTO ticketDTO);
    void updateTicket(TicketDTO ticketDTO, Integer id);
    TicketDTO getTicket(Integer id);
    void updateTicketStatus(Integer id, TicketDTO ticketDTO);
}

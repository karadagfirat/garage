package com.api.garage.service.ipml;

import com.api.garage.entity.Ticket;
import com.api.garage.entity.Vehicle;
import com.api.garage.repo.TicketRepo;
import com.api.garage.service.TicketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TicketServiceImpl implements TicketService {

    private final TicketRepo ticketRepo;

    @Override
    public void saveTicket(Vehicle vehicle) {
        Ticket ticket = Ticket.builder()
                .vehicleId(vehicle.getId())
                .plate(vehicle.getPlate())
                .build();
        ticketRepo.save(ticket);
    }
}

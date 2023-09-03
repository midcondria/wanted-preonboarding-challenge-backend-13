package com.wanted.preonboarding.theater.service.handler;

import lombok.Getter;

@Getter
public class TicketSeller {
    private final TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public void getTicket(Audience audience) {
        if (audience.hasInvitation()) {
            ticketOffice.getFreeTicket(audience);
        }
        ticketOffice.buyTicket(audience);
    }
}

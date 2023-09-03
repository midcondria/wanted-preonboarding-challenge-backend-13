package com.wanted.preonboarding.theater.service.handler;

import java.util.Arrays;
import java.util.List;

public class TicketOffice {
    private long amount;
    private final List<Ticket> tickets;

    public TicketOffice(Long amount, Ticket ... tickets) {
        this.amount = amount;
        this.tickets = Arrays.asList(tickets);
    }

    public void getFreeTicket(Audience audience){
        Ticket freeTicket = tickets.get(0);
        audience.getBag().setTicket(freeTicket);
    }

    public void buyTicket(Audience audience){
        Ticket boughtTicket = tickets.get(0);
        plusAmount(boughtTicket.getFee());
        audience.getBag().minusAmount(boughtTicket.getFee());
        audience.getBag().setTicket(boughtTicket);
    }

    public void plusAmount(long amount) {
        this.amount += amount;
    }

    public void minusAmount(long amount) {
        this.amount -= amount;
    }
}

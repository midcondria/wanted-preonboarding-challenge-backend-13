package com.wanted.preonboarding.theater.service.handler;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Bag {
    private Long amount;
    private final Invitation invitation;
    private Ticket ticket;

    @Builder
    public Bag(Invitation invitation, long amount){
        this.invitation = invitation;
        this.amount = amount;
    }

    public Bag(long amount){
        this(null, amount);
    }

    public boolean hasInvitation() {
        return invitation != null;
    }

    public boolean hasTicket() {
        return ticket != null;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void plusAmount(long amount) {
        this.amount += amount;
    }

    public void minusAmount(long amount) {
        this.amount -= amount;
    }
}

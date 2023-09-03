package com.wanted.preonboarding.theater.service.request;

import com.wanted.preonboarding.theater.service.handler.Audience;
import com.wanted.preonboarding.theater.service.handler.TicketSeller;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestServiceMessage {

    private Audience audience;
    private TicketSeller ticketSeller;

    @Builder
    public RequestServiceMessage(Audience audience, TicketSeller ticketSeller) {
        this.audience = audience;
        this.ticketSeller = ticketSeller;
    }
}

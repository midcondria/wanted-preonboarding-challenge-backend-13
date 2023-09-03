package com.wanted.preonboarding.theater.controller.request;

import com.wanted.preonboarding.theater.service.handler.Audience;
import com.wanted.preonboarding.theater.service.handler.TicketSeller;
import com.wanted.preonboarding.theater.service.request.RequestServiceMessage;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestMessage {

    private Audience audience;
    private TicketSeller ticketSeller;

    @Builder
    public RequestMessage(Audience audience, TicketSeller ticketSeller) {
        this.audience = audience;
        this.ticketSeller = ticketSeller;
    }

    public RequestServiceMessage toServiceRequest() {
        return RequestServiceMessage.builder()
            .audience(audience)
            .ticketSeller(ticketSeller)
            .build();
    }
}

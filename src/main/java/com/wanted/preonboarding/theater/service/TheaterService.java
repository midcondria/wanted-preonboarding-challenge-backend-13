package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.service.handler.*;
import com.wanted.preonboarding.theater.service.request.RequestServiceMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TheaterService {
    private final Theater theater;

    public String enter(RequestServiceMessage request){
        Audience audience = request.getAudience();
        TicketSeller ticketSeller = request.getTicketSeller();

        theater.enter(audience, ticketSeller);
        return "Have a good time.";
    }
}

package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.service.handler.*;
import com.wanted.preonboarding.theater.service.request.RequestServiceMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TheaterServiceTest {

    @Autowired
    private TheaterService theaterService;

    @DisplayName("request 정보가 전달되면 관람객은 티켓구매에 성공하고 관람객과 매표소 소지금 변동이 생긴다.")
    @Test
    void enter() {
        // given
        Audience audience = new Audience(new Bag(1000L));
        TicketOffice ticketOffice = new TicketOffice(20000L, new Ticket(100L));
        TicketSeller ticketSeller = new TicketSeller(ticketOffice);

        RequestServiceMessage request = RequestServiceMessage.builder()
            .audience(audience)
            .ticketSeller(ticketSeller)
            .build();
        // when
        theaterService.enter(request);

        // then
        assertThat(audience.getBag().hasTicket()).isTrue();
        assertThat(audience.getBag().getAmount()).isEqualTo(900L);
        assertThat(ticketOffice.getAmount()).isEqualTo(20100L);
    }

}
package com.wanted.preonboarding.theater.controller;

import com.wanted.preonboarding.theater.controller.request.RequestMessage;
import com.wanted.preonboarding.theater.service.handler.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TheaterControllerTest {

    @Autowired
    private TheaterController theaterController;

    @DisplayName("request 정보가 전달되면 컨트롤러에서 성공 메시지를 반환한다.")
    @Test
    void enter() {
        // given
        Audience audience = new Audience(new Bag(1000L));
        TicketSeller ticketSeller = new TicketSeller(new TicketOffice(20000L, new Ticket(100L)));

        RequestMessage request = RequestMessage.builder()
            .audience(audience)
            .ticketSeller(ticketSeller)
            .build();

        // when
        String enter = theaterController.enter(request);

        // then
        assertThat(enter).isEqualTo("Have a good time.");

    }

}
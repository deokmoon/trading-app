package com.trading.client.ui;

import com.trading.client.application.UpbitService;
import com.trading.client.dto.response.CandlesMinutesRes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WebController.class)
class WebControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UpbitService upbitService;

    @Test
    void getCandlesMinutesTest() throws Exception {
        // given
        given(upbitService.getCandlesMinutes(any(), any()))
                .willReturn(CandlesMinutesRes.builder()
                        .list(Collections.EMPTY_LIST)
                        .build());

        // when & then
        ResultActions resultActions = mockMvc.perform(get("/candles/minutes/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(
                                "{ \"market\" : \"KRW-BTC\", \"to\" : \"2023-11-02T14:00:00\", \"count\": \"5\"}"
                        ))
                .andExpect(status().isOk());

        resultActions.andExpect(status().isOk());
        resultActions.andExpect(jsonPath("$.list.length()").value("0"));

    }

}

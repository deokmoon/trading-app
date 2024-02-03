package com.trading.controller.ui;

import com.trading.controller.UpbitController;
import com.trading.domain.upbit.service.impl.UpbitService;
import com.trading.controller.response.CandlesMinutesRes;
import com.trading.common.base.BaseMockMvcTest;
import com.trading.domain.user.service.UserService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UpbitController.class)
@Disabled
class UpbitControllerTest extends BaseMockMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UpbitService upbitService;

    @MockBean
    private UserService userService;

    @Nested
    class candlesMinutesTest {

        @Test
        void 정상케이스() throws Exception {
            // given
            given(upbitService.getCandlesMinutes(any(), any()))
                    .willReturn(CandlesMinutesRes.builder()
                            .list(Collections.EMPTY_LIST)
                            .build());

            MultiValueMap<String, String> reqMap = new LinkedMultiValueMap<>();
            reqMap.add("market", "KRW-BTC");
            reqMap.add("to", "2023-11-02T14:00:00");
            reqMap.add("count", "5");

            // when & then
            ResultActions resultActions = mockMvc.perform(
                    get("/candles/minutes/1")
                            .with(user("user"))
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON)
                            .characterEncoding("UTF-8")
                            .params(reqMap)
            );

            resultActions.andExpect(status().isOk());
            resultActions.andExpect(jsonPath("$.list.length()").value("0"));

        }

    }

    @ParameterizedTest
    @CsvSource({
            ",", // null
            "''", // empty
            "' '" // blank
    })
    void market_을_누락하여_요청하면_BadRequest(String market) throws Exception {
        // given
        given(upbitService.getCandlesMinutes(any(), any()))
                .willReturn(CandlesMinutesRes.builder()
                        .list(Collections.EMPTY_LIST)
                        .build());

        MultiValueMap<String, String> reqMap = new LinkedMultiValueMap<>();
        reqMap.add("market", market);
        reqMap.add("to", "2023-11-02T14:00:00");
        reqMap.add("count", "5");

        // when & then
        ResultActions resultActions = mockMvc.perform(
                get("/candles/minutes/1")
                        .with(user("user"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .params(reqMap)
        );

        resultActions.andExpect(status().isBadRequest());
    }

}

package com.trading.client.ui;

import com.trading.client.application.UpbitService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WebController.class)
class WebControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UpbitService upbitService;

    @Test
    @Disabled
    void testUpdateContent() throws Exception {
        //given
//        given(contentService.updateContent(any(), any()))
//                .willReturn(ContentDetailDTO.builder()
//                        .name("user1")
//                        .title("title2")
//                        .content("content2")
//                        .build());
        //when & then
        mockMvc.perform(get("/candles/minutes/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(
                                "{ \"name\" : \"user1\", \"title\" : \"test2\", \"content\": \"content2\"}"
                        ))
                .andExpect(status().isOk());


    }

}

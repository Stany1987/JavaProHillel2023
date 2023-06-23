package org.ua.javaPro.berezhnoy.bank.currencyConverterAPI;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class CurrencyControllerTest {
    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    protected WireMockServer wireMockServer;

    @Autowired
    protected MockMvc mockMvc;


    @Test
    void shouldChangeCurrency() throws Exception {
        wireMockServer.stubFor(
                WireMock.get(urlPathEqualTo("/currencyapi"))
                        .withQueryParam("apikey", equalTo("1111"))
                        .withQueryParam("base_currency", equalTo("UAH"))
                        .withQueryParam("currencies", equalTo("USD"))
                        .willReturn(aResponse()
                                .withHeader("Content-Type", "application/json")
                                .withBody("""
                                        {
                                           "data": {
                                               "USD": {
                                                   "code": "USD",
                                                   "value": 0.25
                                               }
                                           }
                                        }

                                        """))
        );

        var query = MockMvcRequestBuilders.get("/currencies/convert")
                .param("from", "UAH")
                .param("to", "USD")
                .param("amount", "100");

        var response = mockMvc.perform(query)
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        var result = objectMapper.readValue(response, Map.class);
        assertThat(result.get("value"), CoreMatchers.equalTo(25.0));

    }
}
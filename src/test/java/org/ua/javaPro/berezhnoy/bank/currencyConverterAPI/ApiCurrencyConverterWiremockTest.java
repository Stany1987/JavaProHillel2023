package org.ua.javaPro.berezhnoy.bank.currencyConverterAPI;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Assertions;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.ua.javaPro.berezhnoy.bank.config.WiremockConfig;

import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = WiremockConfig.class)
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ApiCurrencyConverterWiremockTest {

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    protected WireMockServer wireMockServer;

    @Autowired
    protected MockMvc mockMvc;



    @Test
    void shouldChangeCurrency() throws Exception {
        wireMockServer.stubFor(
                WireMock.get(urlEqualTo("/currencyapi"))
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

//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/currencies/convert")
//                        .param("from", "UAH")
//                        .param("to", "USD")
//                        .param("amount", "100"))
//                .andReturn();

//        int status = result.getResponse().getStatus();
//        String body = result.getResponse().getContentAsString();
//
//        System.out.println("Status: " + status);
//        System.out.println("Body: " + body);



        var query = MockMvcRequestBuilders.get("/currencies/convert")
                .param("from","UAH")
                .param("to","USD")
                .param("amount","100");

        var response = mockMvc.perform(query)
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        var result=objectMapper.readValue(response, Map.class);
       assertThat(result.get("value"), CoreMatchers.equalTo(25.0));

    }

}
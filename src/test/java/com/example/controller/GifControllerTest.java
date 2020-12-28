package com.example.controller;

import com.example.client.CurrencyClient;
import com.example.client.GifClient;
import com.example.record.giphy.Data;
import com.example.record.giphy.Gif;
import com.example.record.giphy.Images;
import com.example.record.giphy.Original;
import com.example.record.openexchangerates.Rate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class GifControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CurrencyClient currencyClient;

    @MockBean
    private GifClient gifClient;

    @MockBean
    private RestTemplate restTemplate;

    @BeforeEach
    public void setUp() {
        Rate rateForToday = new Rate();
        rateForToday.setRates(Collections.singletonMap("RUB", Math.PI));
        Mockito.when(currencyClient.latest(Mockito.anyString(), Mockito.anyString()))
                .thenReturn(rateForToday);

        Rate rateForYesterday = new Rate();
        rateForYesterday.setRates(Collections.singletonMap("RUB", 2 * Math.PI));
        Mockito.when(currencyClient.historical(Mockito.anyString(), Mockito.anyString(), Mockito.anyString()))
                .thenReturn(rateForYesterday);

        Original original = new Original();
        original.setUrl("https://test.com/");
        Images images = new Images();
        images.setOriginal(original);
        Data data = new Data();
        data.setImages(images);
        Gif gif = new Gif();
        gif.setData(Collections.singletonList(data));
        Mockito.when(gifClient.searchGif(Mockito.anyString(), Mockito.anyString(), Mockito.anyInt()))
                .thenReturn(gif);

        Mockito.when(restTemplate.getForObject(Mockito.anyString(), Mockito.any()))
                .thenReturn(new byte[]{});
    }

    @Test
    public void whenValidCurrency_thenGifShouldBeFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/gif/RUB")
                .contentType(MediaType.IMAGE_GIF_VALUE))
                .andExpect(status().isOk())
                .andExpect(mvcResult -> {
                    assertThat(mvcResult.getResponse().getContentType()).isEqualTo(MediaType.IMAGE_GIF_VALUE);
                    assertThat(mvcResult.getResponse()).isNotNull();
                });
    }

    @Test
    public void whenNotValidCurrency_thenExceptionShouldBeThrown() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/gif/123")
                .contentType(MediaType.IMAGE_GIF_VALUE))
                .andExpect(status().isBadRequest())
                .andExpect(mvcResult -> assertThat(mvcResult.getResponse().getContentAsString()).contains("Provided currency code not found!"));
    }

}

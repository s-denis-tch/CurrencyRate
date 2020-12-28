package com.example.service;

import com.example.client.GifClient;
import com.example.record.giphy.Data;
import com.example.record.giphy.Gif;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.Random;

@Service
@Validated
public class GifService {

    private static final Random RANDOM = new Random();

    private final GifClient gifClient;
    private final CurrencyService currencyService;
    private final RestTemplate restTemplate;

    @Value("${gif.api.key}")
    @NotEmpty
    private String gifApiKey;

    @Value("${gif.api.higherSearchWord}")
    @NotEmpty
    private String higherSearchWord;

    @Value("${gif.api.lowerSearchWord}")
    @NotEmpty
    private String lowerSearchWord;

    @Value("${gif.api.limitForSearch}")
    @Positive
    private int limitForSearch;

    public GifService(GifClient gifClient,
                      CurrencyService currencyService) {
        this.gifClient = gifClient;
        this.currencyService = currencyService;
        this.restTemplate = new RestTemplateBuilder().build();
    }

    public byte[] getGif(String currencyCode) {
        String q = currencyService.isHigher(currencyCode) ? higherSearchWord : lowerSearchWord;
        Gif gif = gifClient.searchGif(q, gifApiKey, limitForSearch);
        List<Data> dataList = gif.getData();
        if (!dataList.isEmpty()) {
            return restTemplate.getForObject(dataList.get(RANDOM.nextInt(dataList.size())).getImages().getOriginal().getUrl(), byte[].class);
        } else {
            throw new IllegalArgumentException(String.format("Cannot found gif by '%s' keyword!", q));
        }
    }

}

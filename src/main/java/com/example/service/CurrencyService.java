package com.example.service;

import com.example.client.CurrencyClient;
import com.example.record.openexchangerates.Rate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@Validated
public class CurrencyService {

    private final CurrencyClient currencyClient;

    @Value("${currency.api.appId}")
    @NotEmpty
    private String currencyAppId;

    @Value("${currency.base}")
    @NotEmpty
    private String baseCurrency;

    public CurrencyService(CurrencyClient currencyClient) {
        this.currencyClient = currencyClient;
    }

    public boolean isHigher(String currencyCode) {
        Rate rateForToday = currencyClient.latest(currencyAppId, baseCurrency);
        Rate rateForYesterday = currencyClient.historical(LocalDate.now().minusDays(1).format(DateTimeFormatter.ISO_DATE), currencyAppId, baseCurrency);
        if (rateForToday.getRates().containsKey(currencyCode) && rateForYesterday.getRates().containsKey(currencyCode)) {
            return rateForToday.getRates().get(currencyCode) > rateForYesterday.getRates().get(currencyCode);
        } else {
            throw new IllegalArgumentException("Provided currency code not found!");
        }
    }

}

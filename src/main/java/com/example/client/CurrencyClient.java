package com.example.client;

import com.example.record.openexchangerates.Rate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "currencyClient", url = "${currency.api.baseUrl}")
public interface CurrencyClient {

    @GetMapping("/latest.json")
    Rate latest(@RequestParam("app_id") String appId, @RequestParam("base") String base);

    @GetMapping("/historical/{isoDate}.json")
    Rate historical(@PathVariable("isoDate") String isoDate, @RequestParam("app_id") String appId, @RequestParam("base") String base);

}

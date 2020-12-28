package com.example.client;

import com.example.record.giphy.Gif;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "gifClient", url = "${gif.api.baseUrl}")
public interface GifClient {

    @GetMapping("/v1/gifs/search")
    Gif searchGif(@RequestParam("q") String q, @RequestParam("api_key") String apiKey, @RequestParam("limit") int limit);

}

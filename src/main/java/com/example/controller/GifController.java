package com.example.controller;

import com.example.service.GifService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gif")
public class GifController {

    private final GifService gifService;

    public GifController(GifService gifService) {
        this.gifService = gifService;
    }

    @GetMapping(value = "/{currencyCode}", produces = MediaType.IMAGE_GIF_VALUE)
    public ResponseEntity<byte[]> gif(@PathVariable("currencyCode") String currencyCode) {
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_GIF)
                .body(gifService.getGif(currencyCode));
    }

}

package com.example.record.giphy;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FixedWidth {

    @JsonProperty("height")
    private String height;

    @JsonProperty("width")
    private String width;

    @JsonProperty("size")
    private String size;

    @JsonProperty("url")
    private String url;

    @JsonProperty("mp4_size")
    private String mp4Size;

    @JsonProperty("mp4")
    private String mp4;

    @JsonProperty("webp_size")
    private String webpSize;

    @JsonProperty("webp")
    private String webp;

    @JsonProperty("height")
    public String getHeight() {
        return height;
    }

    @JsonProperty("height")
    public void setHeight(String height) {
        this.height = height;
    }

    @JsonProperty("width")
    public String getWidth() {
        return width;
    }

    @JsonProperty("width")
    public void setWidth(String width) {
        this.width = width;
    }

    @JsonProperty("size")
    public String getSize() {
        return size;
    }

    @JsonProperty("size")
    public void setSize(String size) {
        this.size = size;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("mp4_size")
    public String getMp4Size() {
        return mp4Size;
    }

    @JsonProperty("mp4_size")
    public void setMp4Size(String mp4Size) {
        this.mp4Size = mp4Size;
    }

    @JsonProperty("mp4")
    public String getMp4() {
        return mp4;
    }

    @JsonProperty("mp4")
    public void setMp4(String mp4) {
        this.mp4 = mp4;
    }

    @JsonProperty("webp_size")
    public String getWebpSize() {
        return webpSize;
    }

    @JsonProperty("webp_size")
    public void setWebpSize(String webpSize) {
        this.webpSize = webpSize;
    }

    @JsonProperty("webp")
    public String getWebp() {
        return webp;
    }

    @JsonProperty("webp")
    public void setWebp(String webp) {
        this.webp = webp;
    }

}


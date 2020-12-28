package com.example.record.giphy;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Looping {

    @JsonProperty("mp4_size")
    private String mp4Size;

    @JsonProperty("mp4")
    private String mp4;

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

}

package com.example.record.giphy;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Meta {

    @JsonProperty("status")
    private Integer status;

    @JsonProperty("msg")
    private String msg;

    @JsonProperty("response_id")
    private String responseId;

    @JsonProperty("status")
    public Integer getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(Integer status) {
        this.status = status;
    }

    @JsonProperty("msg")
    public String getMsg() {
        return msg;
    }

    @JsonProperty("msg")
    public void setMsg(String msg) {
        this.msg = msg;
    }

    @JsonProperty("response_id")
    public String getResponseId() {
        return responseId;
    }

    @JsonProperty("response_id")
    public void setResponseId(String responseId) {
        this.responseId = responseId;
    }

}

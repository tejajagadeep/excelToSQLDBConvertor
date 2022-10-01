package com.cts.userinfo.userdetails.model;

import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class MessageResponse {

    private long successCount;
    private String message;

    public MessageResponse(String message){
        this.message = message;
    }

    public MessageResponse(long successCount){
        this.successCount = successCount;
    }

}

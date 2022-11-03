package com.example.lab2p1.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
public class ResponseMessage {
    private String message;
    public ResponseMessage(String message){
        this.message = message;
    }
}

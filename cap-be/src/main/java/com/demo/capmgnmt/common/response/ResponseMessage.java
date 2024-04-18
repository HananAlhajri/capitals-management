package com.demo.capmgnmt.common.response;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Hanan Al-Hajri 2024/04/04
 */

@Data
@AllArgsConstructor
public class ResponseMessage {
    private String messageCode;
    private String messageAr;
    private String messageEn;
    private String invalidValue;

    public ResponseMessage(String messageCode, String messageAr, String messageEn) {
        this.messageCode = messageCode;
        this.messageAr = messageAr;
        this.messageEn = messageEn;
    }
}
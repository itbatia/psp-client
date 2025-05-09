package com.itbatia.pspclient.models;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @author Batsian_SV
 */
@Getter
@Builder
public class Response {

    private String transactionId;
    private boolean success;
    private HttpStatus httpStatus;
}

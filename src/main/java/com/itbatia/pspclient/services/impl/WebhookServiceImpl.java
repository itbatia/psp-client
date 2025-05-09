package com.itbatia.pspclient.services.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.itbatia.pspclient.models.Response;
import com.itbatia.pspclient.services.WebhookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author Batsian_SV
 */
@Slf4j
@Service
public class WebhookServiceImpl implements WebhookService {

    @Value("${config.webhook.success-rate}")
    private Integer successRate;

    @Override
    public Mono<Response> save(JsonNode jsonNode) {
        boolean success = Math.round(Math.random() * 100) < successRate;
        log.info("IN save - Transaction ID = {}. Success: {}", jsonNode.get("transaction_id").asText(), success);
        return Mono.just(buildResponse(jsonNode, success));
    }

    private Response buildResponse(JsonNode jsonNode, boolean success) {
        return Response.builder()
                .transactionId(jsonNode.get("transaction_id").asText())
                .httpStatus(success ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR)
                .success(success)
                .build();
    }
}

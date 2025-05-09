package com.itbatia.pspclient.rest;

import com.fasterxml.jackson.databind.JsonNode;
import com.itbatia.pspclient.models.Response;
import com.itbatia.pspclient.services.WebhookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 * @author Batsian_SV
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/webhooks")
public class WebhookController {

    private final WebhookService webhookService;

    @PostMapping("/topup")
    public Mono<ResponseEntity<Response>> createTopup(@RequestBody JsonNode webhook) {
        return webhookService.save(webhook).map(this::buildResponse);
    }

    @PostMapping("/payout")
    public Mono<ResponseEntity<Response>> createPayout(@RequestBody JsonNode webhook) {
        return webhookService.save(webhook).map(this::buildResponse);
    }

    private ResponseEntity<Response> buildResponse(Response response) {
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }
}

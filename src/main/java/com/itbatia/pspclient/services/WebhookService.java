package com.itbatia.pspclient.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.itbatia.pspclient.models.Response;
import reactor.core.publisher.Mono;

/**
 * @author Batsian_SV
 */
public interface WebhookService {

    Mono<Response> save(JsonNode jsonNode);
}

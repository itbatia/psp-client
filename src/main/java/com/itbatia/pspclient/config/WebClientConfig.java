package com.itbatia.pspclient.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;

/**
 * @author Batsian_SV
 */
@Configuration
public class WebClientConfig {

    @Value("${config.rest.connection-timeout}")
    private Integer connectionTimeout;
    @Value("${config.rest.base-url}")
    private String baseUrl;

    @Bean
    public WebClient webClient() {

        HttpClient httpClient = HttpClient.create()
                .responseTimeout(Duration.ofMillis(connectionTimeout));

        return WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();
    }
}

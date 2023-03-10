package com.rickandmory.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;


@Component
public class ApplicationWebClientConfig {

    @Bean("restApiClient")
    public WebClient restApiClient (@Value("${spring.rick-morty.api.url}") String url) {
        HttpClient httpClient = HttpClient.create();
        return WebClient.builder().baseUrl(url).defaultHeaders( httpHeaders -> httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)).clientConnector(new ReactorClientHttpConnector(httpClient)).build();
    }

}

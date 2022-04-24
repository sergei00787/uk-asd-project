package com.mchl.uk.asd_proj.services.ag_services;

import org.springframework.http.HttpStatus;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class AgLoginService implements IAgLoginService {
    private String baseUrl = "${spring.agapi.url}";

    public AgLoginService(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    private Mono<String> getMonoToken(String login, String password) {
        LinkedMultiValueMap<String, String> map = new LinkedMultiValueMap();
        map.add("UserName", login);
        map.add("Password", password);

        Mono<String> monoToken = WebClient.builder()
                .baseUrl(baseUrl+"/Login")
                .build()
                .post()
                .body(BodyInserters.fromMultipartData(map))
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, clientResponse -> Mono.error(new RuntimeException("Client Error"+ clientResponse.logPrefix())))
                .onStatus(HttpStatus::is5xxServerError, clientResponse -> Mono.error(new RuntimeException("Server Error"+ clientResponse.logPrefix())))
                .bodyToMono(String.class);
        return monoToken;
    }

    @Override
    public String getToken(String login, String password){
        return getMonoToken(login, password).block();
    }


}

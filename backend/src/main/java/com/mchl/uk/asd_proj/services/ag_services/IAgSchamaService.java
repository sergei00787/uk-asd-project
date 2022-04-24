package com.mchl.uk.asd_proj.services.ag_services;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.mchl.uk.asd_proj.emtities.ag_entities.AgSchema;
import reactor.core.publisher.Mono;

public interface IAgSchamaService {
    Mono<String> getMonoEnumSchemas(String token);
    AgSchema[] getEnumSchemaFromMono(Mono<String> mono) throws JsonProcessingException;
    AgSchema[] getEnumSchema(String login, String password);
}

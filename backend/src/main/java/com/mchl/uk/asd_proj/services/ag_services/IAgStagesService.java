package com.mchl.uk.asd_proj.services.ag_services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mchl.uk.asd_proj.emtities.ag_entities.AgTrip;
import com.mchl.uk.asd_proj.emtities.ag_entities.AgTripStage;
import reactor.core.publisher.Mono;

import java.util.HashMap;

public interface IAgStagesService {
    HashMap<String, AgTripStage> getMapAgTripStageFromMono(Mono<String> monoAgStage) throws JsonProcessingException;

    AgTripStage[] getTripStagesInAgTrip(AgTrip agTrip);

    Mono<String> getMonoAgStage(String token,
                                       String schema_id,
                                       String[] id_devices,
                                       String startDate,
                                       String endDate,
                                       String stageName,
                                       String[] tripParams,
                                       int tripSplitterIndex);

    AgTripStage getAgTripStageFromMap(HashMap<String, AgTripStage> map, String deviceId);

    AgTripStage getTripStage(String login,
                             String password,
                             String schema_id,
                             String id_device,
                             String startDate,
                             String endDate,
                             String stageName,
                             String[] tripParams,
                             int tripSplitterIndex) throws JsonProcessingException;
}

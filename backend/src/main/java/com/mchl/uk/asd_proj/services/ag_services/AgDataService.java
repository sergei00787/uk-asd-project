package com.mchl.uk.asd_proj.services.ag_services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.mchl.uk.asd_proj.emtities.ag_entities.AgFindDevice;
import com.mchl.uk.asd_proj.emtities.ag_entities.AgTrip;
import com.mchl.uk.asd_proj.emtities.ag_entities.AgTrips;
import com.mchl.uk.asd_proj.utility.AgDateUtility;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

public class AgDataService implements IAgDataService {
    public String baseAgUrl;

    public AgDataService(String baseUrl) {
        this.baseAgUrl = baseUrl;
    }

    @Override
    public AgFindDevice[] findDevicesByRegNumber(String token, String schemaId, String regNumber) throws JsonProcessingException {
        String agDeviceItem = WebClient.builder().baseUrl(this.baseAgUrl + "/FindDevices")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .codecs(configurer -> configurer
                        .defaultCodecs()
                        .maxInMemorySize(64 * 1024 * 1024))
                .build()
                .get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("session", token)
                        .queryParam("schemaID", schemaId)
                        .queryParam("vehicleRegNumbers", regNumber)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(agDeviceItem, AgFindDevice[].class);
    }


    @Override
    public long getDurationMoveByTrips(AgTrips agtrips) {
        long sumDurationMove = 0L;
        for (AgTrip agTrip : agtrips.getTrips()) {
            sumDurationMove = sumDurationMove + getDurationMove(agTrip);
        }
        return sumDurationMove;
    }

    @Override
    public long getDurationMove(AgTrip agtrip) {
        return AgDateUtility.getSecondFromStringDuration((String) agtrip.getTotal().get("MoveDuration"));
    }

}

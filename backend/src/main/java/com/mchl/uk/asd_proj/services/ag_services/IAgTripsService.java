package com.mchl.uk.asd_proj.services.ag_services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mchl.uk.asd_proj.emtities.ag_entities.AgTrips;

import java.util.List;

public interface IAgTripsService {
    List<AgTrips> getTrips(String login, String password,
                           String schema_id,
                           String id_device,
                           String startDate,
                           String endDate,
                           int tripSplitterIndex) throws JsonProcessingException;
}

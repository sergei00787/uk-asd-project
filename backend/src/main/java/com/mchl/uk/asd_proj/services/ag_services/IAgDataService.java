package com.mchl.uk.asd_proj.services.ag_services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mchl.uk.asd_proj.emtities.ag_entities.AgFindDevice;
import com.mchl.uk.asd_proj.emtities.ag_entities.AgTrip;
import com.mchl.uk.asd_proj.emtities.ag_entities.AgTrips;

public interface IAgDataService {

    AgFindDevice[] findDevicesByRegNumber(String token, String schemaId, String  regNumber) throws JsonProcessingException;

    long getDurationMoveByTrips(AgTrips agtrips);
    long getDurationMove(AgTrip agtrip);

}

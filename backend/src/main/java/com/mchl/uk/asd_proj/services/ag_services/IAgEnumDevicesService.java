package com.mchl.uk.asd_proj.services.ag_services;


import com.mchl.uk.asd_proj.emtities.ag_entities.AgEnumDevices;
import com.mchl.uk.asd_proj.emtities.ag_entities.AgSchema;

public interface IAgEnumDevicesService {
    AgEnumDevices getAgEnumDevices(String token, AgSchema schema);
}

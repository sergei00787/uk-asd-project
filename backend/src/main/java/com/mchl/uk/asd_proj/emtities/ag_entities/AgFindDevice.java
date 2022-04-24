package com.mchl.uk.asd_proj.emtities.ag_entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgFindDevice {

    @JsonProperty("FindBy")
    private AgFindDeviceKind findBy;
    @JsonProperty("Item")
    private AgDeviceItem item;
    @JsonProperty("Path")
    private AgGroupItem[] path;
}

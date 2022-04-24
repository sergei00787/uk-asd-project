package com.mchl.uk.asd_proj.emtities.ag_entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AgVirtualTree {
    @JsonProperty("ID")
    public String id;
    @JsonProperty("Name")
    public String name;
}

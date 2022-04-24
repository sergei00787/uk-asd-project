package com.mchl.uk.asd_proj.emtities.ag_entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AgGroupItem {
    @JsonProperty("ID")
    private String id;

    @JsonProperty("ParentID")
    private String parentId;

    @JsonProperty("Name")
    private String name;
}

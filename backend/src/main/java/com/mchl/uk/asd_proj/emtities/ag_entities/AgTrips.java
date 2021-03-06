package com.mchl.uk.asd_proj.emtities.ag_entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AgTrips {
    @JsonProperty("ID")
    private String id;         // ID ТС
    @JsonProperty("Name")
    private String name;         // название ТС
    @JsonProperty("Serial")
    private int serial;           // серийный номер прибора
    @JsonProperty("VRN")
    private String vrn;           // номер ТС (свойство VehicleRegNumber)
    @JsonProperty("SD")
    private Date sd;          // дата/время начала первого рейса (в UTC)
    @JsonProperty("ED")
    private Date ed;          // дата/время конца последнего рейса (в UTC)
    @JsonProperty("Trips")
    private AgTrip[] trips;        // рейсы
    @JsonProperty("Total")
    private HashMap<String, Object> total;    // финальные значения по всем рейсам
}

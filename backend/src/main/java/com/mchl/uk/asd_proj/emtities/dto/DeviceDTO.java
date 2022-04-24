package com.mchl.uk.asd_proj.emtities.dto;

import com.mchl.uk.asd_proj.emtities.Group;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
public class DeviceDTO {
    private final UUID id;
    private int serial;
    private String name;

    private Group group;

    private boolean allowed;
    private String image;
    private String imageColored;
    private boolean isAreaEnabled;

    public DeviceDTO(UUID id) {
        this.id = id;
    }
}

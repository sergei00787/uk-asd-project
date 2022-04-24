package com.mchl.uk.asd_proj.backend.repositories;

import java.util.Optional;
import java.util.UUID;

import com.mchl.uk.asd_proj.emtities.Device;
import org.springframework.stereotype.Repository;


public interface DeviceRepository {

    Optional<Device> findById(UUID id);

    default Device findByIdOrFail(UUID id) {
        return findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Item with id: <" + id + "> not found!"));
    }

    void deleteAll();

}

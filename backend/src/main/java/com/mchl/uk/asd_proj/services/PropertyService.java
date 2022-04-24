package com.mchl.uk.asd_proj.services;

import com.mchl.uk.asd_proj.backend.repositories.DeviceRepository;
import com.mchl.uk.asd_proj.backend.repositories.PropertyRepository;
import com.mchl.uk.asd_proj.emtities.Device;
import com.mchl.uk.asd_proj.emtities.PropType;
import com.mchl.uk.asd_proj.emtities.Property;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class PropertyService {
    private final PropertyRepository propertyRepository;
    private final DeviceRepository deviceRepository;

    @Transactional
    public UUID createProperty() {
        Property property = new Property();

        propertyRepository.save(property);
        log.info("Created a new property <id: {}>", property.getId());
        return property.getId();
    }

    @Transactional
    public UUID createProperty(UUID id, UUID deviceItemId, boolean inherited, PropType propType, String name, String value) {
        if (deviceRepository.findById(deviceItemId).isPresent()) {
            Device device = deviceRepository.findById(deviceItemId).get();
            Property property = new Property(id, device, inherited, propType, name, value);
            propertyRepository.save(property);
            log.info("Created a new property <id: {}>", property.getId());
            return property.getId();
        } else {
            throw new RuntimeException("Error in create property function, device with id = " + deviceItemId + "not found");
        }
    }

}

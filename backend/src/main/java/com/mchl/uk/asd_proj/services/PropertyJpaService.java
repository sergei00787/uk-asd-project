package com.mchl.uk.asd_proj.services;


import com.mchl.uk.asd_proj.backend.repositories.PropertyJpaRepository;
import com.mchl.uk.asd_proj.emtities.Property;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PropertyJpaService {

    private final PropertyJpaRepository propertyJpaRepository;

    public List<Property> getAllProperties(){
        return (List<Property>) propertyJpaRepository.findAll();
    }

}

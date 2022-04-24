package com.mchl.uk.asd_proj.backend.repositories;


import com.mchl.uk.asd_proj.emtities.Property;

public interface PropertyRepository {

    Property save(Property property);

    void deleteAll();
}

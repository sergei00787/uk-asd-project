package com.mchl.uk.asd_proj.backend.repositories;

import com.mchl.uk.asd_proj.backend.repositories.PropertyRepository;
import com.mchl.uk.asd_proj.emtities.Property;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PropertyJpaRepository extends CrudRepository<Property, UUID>, PropertyRepository {
    @Override
    @Query("select p from Property p JOIN FETCH p.device")
    Iterable<Property> findAll();

    @Override
    Property save(Property property);
}

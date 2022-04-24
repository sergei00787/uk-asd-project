package com.mchl.uk.asd_proj.backend.repositories;


import com.mchl.uk.asd_proj.backend.repositories.DeviceRepository;
import com.mchl.uk.asd_proj.emtities.Device;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DeviceJpaRepository extends CrudRepository<Device, UUID>, DeviceRepository {

    @Override
    @Query("select d from Device d JOIN FETCH d.group")
    Iterable<Device> findAll();

    @Override
    Optional<Device> findById(UUID uuid);

    default Device findByIdOrFail(UUID id) {
        return findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Item with id: <" + id + "> not found!"));
    }

    @Override
    Device save(Device device);

    @Override
    void deleteById(UUID uuid);

    @Override
    void deleteAll(Iterable<? extends Device> entities);

    default void deleteAll(){
        deleteAll(findAll());
    };
}

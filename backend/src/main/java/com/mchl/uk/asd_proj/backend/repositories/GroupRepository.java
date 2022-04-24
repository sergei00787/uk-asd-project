package com.mchl.uk.asd_proj.backend.repositories;


import com.mchl.uk.asd_proj.emtities.Group;

import java.util.Optional;
import java.util.UUID;

public interface GroupRepository {

    Group save(Group group);

    Optional<Group> findById(UUID id);

    void deleteAll();
}

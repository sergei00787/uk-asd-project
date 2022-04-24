package com.mchl.uk.asd_proj.backend.repositories;

import com.mchl.uk.asd_proj.backend.repositories.GroupRepository;
import com.mchl.uk.asd_proj.emtities.Group;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface GroupJpaRepository extends CrudRepository<Group, UUID>, GroupRepository {
}



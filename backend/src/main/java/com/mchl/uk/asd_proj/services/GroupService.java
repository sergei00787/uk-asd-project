package com.mchl.uk.asd_proj.services;
import com.mchl.uk.asd_proj.backend.repositories.GroupRepository;
import com.mchl.uk.asd_proj.emtities.Group;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;

    @Transactional
    public UUID createGroupItem() {
        Group group = new Group();

        groupRepository.save(group);
        log.info("Created a new groupItem <id: {}>", group.getId());
        return group.getId();
    }

    @Transactional
    public UUID createGroupItem(UUID id, UUID parentId, String name) {
        Group group = new Group(id, parentId, name);

        groupRepository.save(group);
        log.info("Created a new groupItem <id: {}>", group.getId());
        return group.getId();
    }

}

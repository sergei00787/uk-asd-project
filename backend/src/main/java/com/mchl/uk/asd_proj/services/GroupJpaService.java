package com.mchl.uk.asd_proj.services;

import com.mchl.uk.asd_proj.backend.repositories.GroupJpaRepository;
import com.mchl.uk.asd_proj.emtities.Group;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class GroupJpaService {
    private final GroupJpaRepository groupJpaRepository;

    @Transactional
    public List<Group> getAllGroups(){
        return  (List<Group>) groupJpaRepository.findAll();
    }
}

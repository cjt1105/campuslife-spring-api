package com.cjtate.campuslifeapi.repositories;

import org.springframework.data.neo4j.repository.GraphRepository;

import com.cjtate.campuslifeapi.domain.Group;

public interface GroupRepository extends GraphRepository<Group> {

}

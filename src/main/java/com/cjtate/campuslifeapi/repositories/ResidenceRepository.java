package com.cjtate.campuslifeapi.repositories;

import org.springframework.data.neo4j.repository.GraphRepository;

import com.cjtate.campuslifeapi.domain.Residence;

public interface ResidenceRepository extends GraphRepository<Residence> {

}

package com.cjtate.campuslifeapi.domain;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import lombok.Data;

@NodeEntity
@Data public class Residence {

	@GraphId
	private Long id;
	private String name;
	private Long lat;
	private Long lon;
	
	@Relationship(type="IS_RESIDENT", direction = Relationship.INCOMING)
	private List <User> residents = new ArrayList<>();
	
	@Relationship(type="POSTED_IN", direction = Relationship.INCOMING)
	private List <Post> posts = new ArrayList<>();
}

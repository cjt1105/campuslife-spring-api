package com.cjtate.campuslifeapi.domain;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import lombok.Data;

@NodeEntity
@Data public class User {
	
	@GraphId
	private Long id;
	
	private String email;
	private String firstName;
	private String lastName;
	
	@Relationship(type = "LIVES_IN", direction = Relationship.OUTGOING)
	private Residence residence;
	
	@Relationship(type="ATTENDS_LECTURE", direction=Relationship.OUTGOING)
	private List <Lecture> lectures = new ArrayList<>();
	
	@Relationship(type="ON_CALENDAR", direction=Relationship.INCOMING)
	private List <Assignment> assignments = new ArrayList<>();
	
	@Relationship(type="POSTED_BY", direction=Relationship.INCOMING)
	private List <Post> posts = new ArrayList<>();
	
	@Relationship(type = "IS_MEMBER", direction = Relationship.OUTGOING)
	private List <Group> groups = new ArrayList<>();

}




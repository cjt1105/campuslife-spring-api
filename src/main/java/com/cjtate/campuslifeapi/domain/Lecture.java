package com.cjtate.campuslifeapi.domain;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import lombok.Data;

@NodeEntity
@Data public class Lecture {

	@GraphId
	private Long id;
	
	private Long section;
	private String professor;
	private String name;
	
	@Relationship(type="IS_STUDENT", direction=Relationship.UNDIRECTED)
	private List <User> students = new ArrayList<>();
	
	@Relationship(type="IS_TA", direction=Relationship.OUTGOING)
	private List <User> assistants = new ArrayList<>();
	
	@Relationship(type = "POSTED_IN", direction = Relationship.INCOMING)
	private List <Post> posts = new ArrayList<>();
	
	@Relationship(type = "ON_CALENDAR", direction = Relationship.INCOMING)
	private List <Assignment> assignments = new ArrayList<>();

}

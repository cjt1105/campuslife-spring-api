package com.cjtate.campuslifeapi.domain;

import java.util.List;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import lombok.Data;

@NodeEntity
@Data public class Assignment {
	
	@GraphId private Long id;
	private String name;
	private String description;
	private String dueDate;
	
	@Relationship(type = "IS_COMMENT", direction= Relationship.INCOMING)
	private List<Comment> comments;
	
}

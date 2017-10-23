package com.cjtate.campuslifeapi.domain;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import lombok.Data;

@NodeEntity
@Data public class Post {
	
	@GraphId
	private Long id;
	
	private String body;
	
	private User postedBy;
	
	@Relationship(type="IS_COMMENT", direction=Relationship.INCOMING)
	private List <Comment> comments = new ArrayList<>();
	
	@Relationship(type="LIKES_POST", direction=Relationship.INCOMING)
	private List <User> likes = new ArrayList<>();
}

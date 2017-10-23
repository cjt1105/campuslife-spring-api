package com.cjtate.campuslifeapi.domain;

import java.util.List;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import lombok.Data;

@NodeEntity
@Data public class Comment {

	@GraphId private Long id;
	private String body;
	
	@Relationship(type="POSTED_BY", direction=Relationship.OUTGOING)
	private User postedBy;
	
	@Relationship(type = "SUBCOMMENT", direction = Relationship.OUTGOING)
	private List<Comment> subcomments;
}

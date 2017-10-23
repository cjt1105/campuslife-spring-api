package com.cjtate.campuslifeapi.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import lombok.Getter;
import lombok.Setter;

@NodeEntity
public class Post {
	
	@GraphId
	private Long id;
	
	@Getter @Setter private String body;
	
	@Getter @Setter private User postedBy;
	
	@Relationship(type="IS_COMMENT", direction=Relationship.INCOMING)
	private List <Comment> comments = new ArrayList<>();
	
	@Relationship(type="LIKES_POST", direction=Relationship.INCOMING)
	private List <User> likes = new ArrayList<>();
	
	public Post() {
		
	}
	
	public Post(String body) {
		this.body = body;
	}
	
	public void addComment(Comment comment) {
		this.comments.add(comment);
	}
	
	public Collection<Comment> getComments() {
		return comments;
	}
	
	public void addLike(User user) {
		this.likes.add(user);
	}
	
	public Collection<User> getLikes() {
		return likes;
	}
	

}

package com.cjtate.campuslifeapi.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.uuid.Generators;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.Index;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@NodeEntity
@Data public class Lecture {

	@GraphId
	private Long id;
	
	private Long section;
	private String professor;
	private String name;
	
//	@Getter
//	@Index(unique=true, primary = true) private UUID uuid = Generators.timeBasedGenerator().generate();
	
	@Relationship(type="IS_STUDENT", direction=Relationship.UNDIRECTED)
	private List <User> students = new ArrayList<>();
	
	@Relationship(type="IS_TA", direction=Relationship.OUTGOING)
	private List <User> assistants = new ArrayList<>();
	
	@Relationship(type = "POSTED_IN", direction = Relationship.INCOMING)
	private List <Post> posts = new ArrayList<>();
	
	@Relationship(type = "ON_CALENDAR", direction = Relationship.INCOMING)
	private List <Assignment> assignments = new ArrayList<>();
	
	public void addPost(Post post) {
		this.posts.add(post);
	}
	
	public Collection<Post> getPosts() {
		return posts;
	}
	
	public Collection<User> getAssistants(){
		return assistants;
	}
	public Collection<User> getUsers() {
		return students;
	}
	
	public void addAssistant(User student) {
		this.assistants.add(student);
	}
	
	public Collection<User> getStudents(){
		return students;
	}
	
	public void addStudent(User student) {
		this.students.add(student);
	}
	
	public Lecture() {}
	
	public Lecture(Long section, String professor, String name) {
		this.section = section;
		this.professor = professor;
		this.name = name;
	}
}

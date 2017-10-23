package com.cjtate.campuslifeapi.repositories;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cjtate.campuslifeapi.domain.Lecture;
import com.cjtate.campuslifeapi.domain.User;
import com.cjtate.campuslifeapi.domain.Assignment;;

@Repository
public interface LectureRepository extends GraphRepository<Lecture> {

	@Query("MATCH (assignment:Assignment) WHERE ID(assignment) = {assignmentId} MATCH (lecture:Lecture)-[:ATTENDS_LECTURE]-(students) WHERE ID(lecture) = {lectureId} CREATE (assignment)-[:ON_CALENDAR]->(lecture) CREATE (assignment)-[:ON_CALENDAR]->(students)")
	Assignment addAssignmentToLecture(@Param("lectureId") Long lectureId,@Param("assignmentId") Long assignmentId);
	
	@Query("MATCH (lecture:Lecture)-[:ATTENDS_LECTURE]-(students) WHERE ID(lecture) = {lectureId} RETURN students ")
	Iterable<User> getStudents(@Param("lectureId") Long lectureId);
	
	@Query("MATCH  (lecture:Lecture)-[r]-(n) WHERE ID(lecture) = {lectureId} RETURN r")
	Lecture getLecture(@Param("lectureId") Long lectureId);

}

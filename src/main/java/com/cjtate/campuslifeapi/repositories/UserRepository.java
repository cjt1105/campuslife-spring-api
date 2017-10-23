package com.cjtate.campuslifeapi.repositories;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cjtate.campuslifeapi.domain.Lecture;
import com.cjtate.campuslifeapi.domain.User;
import com.cjtate.campuslifeapi.domain.Assignment;

@Repository
public interface UserRepository extends GraphRepository<User> {
	
	@Query("MATCH (user:User) WHERE ID(user) = {userId} MATCH (lecture:Lecture) WHERE ID(lecture) = {lectureId} CREATE (user)-[:ATTENDS_LECTURE]->(lecture)")
	Lecture addLecture(@Param("userId") Long userId,@Param("lectureId") Long lectureId);
	
	@Query("MATCH (user:User) WHERE ID(user) = {userId} MATCH (residence:Residence) WHERE ID(residence) = {residenceId} CREATE (user)-[:LIVES_IN]->(residence)")
	Lecture addResidence(@Param("userId") Long userId,@Param("residenceId") Long residenceId);
	
	@Query("MATCH (user:User) WHERE ID(user) = {userId} MATCH (group:Group) WHERE ID(group) = {groupId} CREATE (user)-[:IS_MEMBER]->(group)")
	Lecture joinGroup(@Param("userId") Long userId,@Param("groupId") Long groupId);
	
	@Query("MATCH (user:User)-[:ATTENDS_LECTURE]-(lectures) WHERE ID(user) = {userId} RETURN lectures ")
	Iterable<Lecture> getLectures(@Param("userId") Long userId);
	
	@Query("MATCH (user:User)-[:ON_CALENDAR]-(assignments) WHERE ID(user) = {userId} RETURN assignments ")
	Iterable<Assignment> getAssignments(@Param("userId") Long userId);
}

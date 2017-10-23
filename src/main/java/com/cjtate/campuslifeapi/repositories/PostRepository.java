package com.cjtate.campuslifeapi.repositories;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cjtate.campuslifeapi.domain.Lecture;
import com.cjtate.campuslifeapi.domain.Post;

@Repository
public interface PostRepository extends GraphRepository<Post> {
	
	@Query("MATCH (post:Post) WHERE ID(post) = {postId} MATCH (lecture:Lecture) WHERE ID(lecture) = {lectureId} MATCH (user:User) WHERE ID(user) = {userId} CREATE (post)-[:POSTED_IN]->(lecture), (post)-[:POSTED_BY]->(user)")
	Post addPostToLecture(@Param("postId") Long postId,@Param("lectureId") Long lectureId, @Param("userId") Long userId);
	
	@Query("MATCH (post:Post) WHERE ID(post) = {postId} MATCH (residence:Residence) WHERE ID(residence) = {residenceId} MATCH (user:User) WHERE ID(user) = {userId} CREATE (post)-[:POSTED_IN]->(residence), (post)-[:POSTED_BY]->(user)")
	Post addPostToResidence(@Param("postId") Long postId,@Param("residenceId") Long residenceId, @Param("userId") Long userId);
	
	@Query("MATCH (post:Post) WHERE ID(post) = {postId} MATCH (group:Group) WHERE ID(group) = {groupId} MATCH (user:User) WHERE ID(user) = {userId} CREATE (post)-[:POSTED_IN]->(group), (post)-[:POSTED_BY]->(user)")
	Post addPostToGroup(@Param("postId") Long postId,@Param("groupId") Long groupId, @Param("userId") Long userId);
	
	@Query("MATCH (post:Post) WHERE ID(post) = {postId} MATCH (comment:Comment) WHERE ID(comment) = {commentId} MATCH (user:User) WHERE ID(user) = {userId} CREATE (comment)-[:IS_COMMENT]->(post), (comment)-[:POSTED_BY]->(user)")
	Post addComment(@Param("postId") Long postId,@Param("commentId") Long commentId, @Param("userId") Long userId);
}

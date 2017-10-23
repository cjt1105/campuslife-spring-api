package com.cjtate.campuslifeapi.repositories;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;

import com.cjtate.campuslifeapi.domain.Comment;

public interface CommentRepository extends GraphRepository<Comment> {
	
	@Query("MATCH (comment:Comment) WHERE ID(comment) = {commentId} MATCH (subcomment:Comment) WHERE ID(subcomment) = {subcommentId} MATCH (user:User) WHERE ID(user) = {userId} CREATE (subcomment)-[:SUBCOMMENT]->(comment), (subcomment)-[:POSTED_BY]->(user)")
	Comment addSubcomment(@Param("commentId") Long commentId,@Param("subcommentId") Long subcommentId, @Param("userId") Long userId);

}

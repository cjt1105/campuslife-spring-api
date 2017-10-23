package com.cjtate.campuslifeapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cjtate.campuslifeapi.domain.Comment;
import com.cjtate.campuslifeapi.repositories.CommentRepository;

@RestController
public class CommentController {
	
	@Autowired
	CommentRepository  commentRepository;
	
	@RequestMapping(value = "/api/comments/{commentId}/addSubcomment/{subcommentId}/user={userId}", method = RequestMethod.POST)
	public Comment addSubcomment(@PathVariable("commentId") Long commentId, @PathVariable("subcommentId") Long subcommentId, @PathVariable("userId") Long userId) {
		return commentRepository.addSubcomment(commentId, subcommentId, userId);
	}

}

package com.cjtate.campuslifeapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cjtate.campuslifeapi.domain.Post;
import com.cjtate.campuslifeapi.repositories.PostRepository;

@RestController
public class PostController {
	
	@Autowired
	PostRepository postRepository;
	
	@RequestMapping(value = "/api/posts/{postId}/postToLecture/{lectureId}/user={userId}", method = RequestMethod.POST)
	public void postToLecture(@PathVariable(value="postId") Long postId,@PathVariable(value="lectureId") Long lectureId, @PathVariable(value="userId") Long userId) {
		postRepository.addPostToLecture(postId, lectureId, userId);
	}
	
	@RequestMapping(value = "/api/posts/{postId}/postToResidence/{residenceId}/user={userId}", method = RequestMethod.POST)
	public void postToResidence(@PathVariable(value="postId") Long postId,@PathVariable(value="residenceId") Long residenceId, @PathVariable(value="userId") Long userId) {
		postRepository.addPostToResidence(postId, residenceId, userId);
	}
	
	@RequestMapping(value = "/api/posts/{postId}/postToGroup/{groupId}/user={userId}", method = RequestMethod.POST)
	public void postToGroup(@PathVariable(value="postId") Long postId,@PathVariable(value="groupId") Long groupId, @PathVariable(value="userId") Long userId) {
		postRepository.addPostToGroup(postId, groupId, userId);
	}
	
	@RequestMapping(value = "/api/posts/{postId}/addComment/{commentId}/user={userId}", method = RequestMethod.POST)
	public void addComment(@PathVariable(value="postId") Long postId,@PathVariable(value="commentId") Long commentId, @PathVariable(value="userId") Long userId) {
		postRepository.addComment(postId, commentId, userId);
	}
}	

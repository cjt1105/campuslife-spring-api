package com.cjtate.campuslifeapi.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cjtate.campuslifeapi.domain.*;
import com.cjtate.campuslifeapi.repositories.UserRepository;
import com.cjtate.campuslifeapi.repositories.LectureRepository;

@RestController("/users")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	LectureRepository lectureRepository;
	
	@RequestMapping(value = "/api/users/{userId}/addLecture/{lectureId}", method = RequestMethod.POST)
	public void addLecture(@PathVariable(value="userId") Long userId,@PathVariable(value="lectureId") Long lectureId ) {
		userRepository.addLecture(userId, lectureId);
	}
	
	@RequestMapping(value = "/api/users/{userId}/addResidence/{residenceId}", method = RequestMethod.POST)
	public void addResidence(@PathVariable(value="userId") Long userId,@PathVariable(value="residenceId") Long residenceId ) {
		userRepository.addResidence(userId, residenceId);
	}
	
	@RequestMapping(value = "/api/users/{userId}/joinGroup/{groupId}", method = RequestMethod.POST)
	public void joinGroup(@PathVariable(value="userId") Long userId,@PathVariable(value="groupId") Long groupId ) {
		userRepository.joinGroup(userId, groupId);
	}
	
	@RequestMapping(value = "/api/users/{userId}/lectures", method = RequestMethod.GET)
	public Iterable <Lecture> getLectures(@PathVariable(value="userId") Long userId) {
		return userRepository.getLectures(userId);
	}
	
	@RequestMapping(value = "/api/users/{userId}/assignments", method = RequestMethod.GET)
	public Iterable <Assignment> getAssignments(@PathVariable(value="userId") Long userId) {
		return userRepository.getAssignments(userId);
	}
}

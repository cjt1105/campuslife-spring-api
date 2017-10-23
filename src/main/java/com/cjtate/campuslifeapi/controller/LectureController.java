package com.cjtate.campuslifeapi.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.cjtate.campuslifeapi.domain.*;
import com.cjtate.campuslifeapi.repositories.UserRepository;
import com.cjtate.campuslifeapi.repositories.AssignmentRepository;
import com.cjtate.campuslifeapi.repositories.LectureRepository;


@RestController
public class LectureController {
	
	@Autowired
	LectureRepository lectureRepository;
	
	@Autowired
	AssignmentRepository assignmentRepository;
	
	@RequestMapping(value = "/api/lectures/{lectureId}/addAssignment", method = RequestMethod.POST)
	public Assignment addAssignment(@RequestBody Assignment assignment, @PathVariable("lectureId") Long lectureId) {
		Assignment createdAssignment = assignmentRepository.save(assignment, 1);
		Long assignmentId = createdAssignment.getId();
		return lectureRepository.addAssignmentToLecture(lectureId, assignmentId);
	}
		
	@RequestMapping(value = "/api/lectures/{lectureId}/students", method = RequestMethod.GET)
	public Iterable<User> getStudents(@PathVariable(value="lectureId") Long lectureId) {
		return lectureRepository.getStudents(lectureId);
	}


}

package com.cjtate.campuslifeapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cjtate.campuslifeapi.domain.Assignment;
import com.cjtate.campuslifeapi.repositories.AssignmentRepository;

@RestController("/assignments")
public class AssignmentController {
	
	@Autowired
	AssignmentRepository assignmentRepository;
	
	@RequestMapping(value = "/assignments", method = RequestMethod.POST)
	public Assignment addAssignment(@RequestBody Assignment assignment) {
		return assignmentRepository.save(assignment, 1);
	}

}

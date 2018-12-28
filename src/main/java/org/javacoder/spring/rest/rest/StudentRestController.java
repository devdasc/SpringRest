package org.javacoder.spring.rest.rest;

import java.util.ArrayList;
import java.util.List;

import org.javacoder.spring.rest.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	//define and endpoint for "/students"--> return a list of students
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		List<Student> theStudents = new ArrayList<>();
		theStudents.add(new Student(1,"Mario","Rossi"));
		theStudents.add(new Student(2,"Poornima","patel"));
		theStudents.add(new Student(3,"Mary","Smith"));
		return theStudents;
	}

}

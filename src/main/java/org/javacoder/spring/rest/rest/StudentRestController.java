package org.javacoder.spring.rest.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.javacoder.spring.rest.entity.Student;
import org.javacoder.spring.rest.exception.StudentErrorResponse;
import org.javacoder.spring.rest.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	//private List<Student> theStudents;
	private Map<Integer,Student> theStudents = new HashMap();

	//define a @PostConstruct to load the student data for only once
	@PostConstruct
	public void loadData() {
		/* when using List */
//		theStudents = new ArrayList<>();
//		theStudents.add(new Student(1,"Mario","Rossi"));
//		theStudents.add(new Student(2,"Poornima","patel"));
//		theStudents.add(new Student(3,"Mary","Smith"));
		
		/* when using Map */
		theStudents.put(1, new Student(1,"Mario","Rossi"));
		theStudents.put(2, new Student(2,"Poornima","patel"));
		theStudents.put(3, new Student(3,"Mary","Smith"));
	}
	
	//define and endpoint for "/students"--> return a list of students
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		//return theStudents;/*when using List*/
		
		return new ArrayList<Student>(theStudents.values());/*when using Map*/
	}
	//define endpoint for "/students/{studentId}"---> return student at index
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		
		//return theStudents.get(studentId); /* when using List*/
		
		if((studentId>theStudents.size())||(studentId<0)) {
			throw new StudentNotFoundException("Student with "+ studentId+" is not found");
		}
		Student student = theStudents.get(studentId);
		return student;
		
	}
	// exception handler
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exe){
		
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exe.getMessage());
		error.setTimeStump(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	// generic exception handler to catch ANY EXCEPTION
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exe){
		
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exe.getMessage());
		error.setTimeStump(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	
	
}

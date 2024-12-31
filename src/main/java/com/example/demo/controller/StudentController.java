package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/Student")
public class StudentController {
	private StudentService studentService;
	
	public StudentController(StudentService studentService) {
		super();
		this.studentService=studentService;
	}
	
	//Build create Student REST API
	@PostMapping()
	public ResponseEntity <Student>saveStudent(@RequestBody Student student){
		
		return new ResponseEntity<Student>(studentService.saveStudent(student),HttpStatus.CREATED);
	}
	
	@GetMapping()
	public List<Student> getAllStudents(){
		return studentService.getAllStudents();
		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Student>getStudentById(@PathVariable Integer id){
		return new ResponseEntity<Student>(studentService.getStudentById(id),HttpStatus.OK);
		
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Student>updateStudent(@RequestBody Student student, @PathVariable Integer id){
		return new ResponseEntity<Student>(studentService.updateStudent(student, id),HttpStatus.OK) ;
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String>deleteStudent(@PathVariable Integer id){
		studentService.deleteStudent(id);
		return new ResponseEntity<String>("Student has been deleted successifully", HttpStatus.OK);
		
	}
	
}

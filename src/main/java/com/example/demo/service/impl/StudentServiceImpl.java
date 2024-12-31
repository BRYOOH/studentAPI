package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	private StudentRepository studentRepository;
	
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository=studentRepository;
	}

	@Override
	public Student saveStudent(Student student) {
		// maps student to database
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(Integer id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(id).orElseThrow(()
				->new ResourceNotFoundException("Student","Id",id));
	}

	@Override
	public Student updateStudent(Student student, Integer id) {
		// TODO Auto-generated method stub
		
		Student newStudent = studentRepository.findById(id).orElseThrow(()
				->new ResourceNotFoundException("Student","Id",id));
		
		newStudent.setStudentName(student.getStudentName());
		newStudent.setAdminNo(student.getAdminNo());
		studentRepository.save(newStudent);
		
		return newStudent;
	}

	@Override
	public void deleteStudent(Integer id) {
		// TODO Auto-generated method stub
		studentRepository.findById(id).orElseThrow(()
				->new ResourceNotFoundException("Student","Id",id));
		
		studentRepository.deleteById(id);
		
	}

}

package xv.springboot.training.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xv.springboot.training.entities.Student;
import xv.springboot.training.repositories.StudentRepository;


@RestController
public class StudentControllers {

	@Autowired
	private StudentRepository studentRepository;
	
	@RequestMapping("/students")
	public Iterable<Student> getStudents(){
		return studentRepository.findAll();
	}
}

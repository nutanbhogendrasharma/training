package xv.springboot.training.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import xv.springboot.training.entities.Student;

@RepositoryRestResource
public interface StudentRepository extends CrudRepository<Student, Long>{
	
	//find student by name
	List<Student>findByName(@Param("name") String name);
	
	//find student by age
	List<Student>findByAge(int age);
		
	//find student by qualification
	List<Student> findByQualification(String qualification);
	
	//find student by name & qualification
	List<Student> findByNameAndQualification(String name, String qualification);
		
	//find student by name & age
	List<Student> findByNameAndAge(String name, int age);
	
	@Query("select s from Student s where s.name = ?1")
	List<Student>findByName1(String name);
	
}

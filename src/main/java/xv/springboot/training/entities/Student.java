package xv.springboot.training.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String name, sex, qualification;
	private int age;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "organization")
	@JsonIgnore
	private Organization organization;
	
	public Student(){
		
	}
	
	public Student(String name, String sex, String qualification, int age, Organization organization){
		super();
		this.name = name;
		this.sex = sex;
		this.qualification = qualification;
		this.age = age;
		this.organization = organization;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	
	
	
}

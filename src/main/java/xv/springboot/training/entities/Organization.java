package xv.springboot.training.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class Organization {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long organizationid;
	private String organizationname, organizationdesc;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="organization")
	//@JsonIgnore
	private List<Student> students;
	
	public Organization(){
		
	}
	
	public Organization(String organizationname, String organizationdesc){
		super();
		this.organizationname = organizationname;
		this.organizationdesc = organizationdesc;
	}

	public long getOrganizationid() {
		return organizationid;
	}

	public void setOrganizationid(long organizationid) {
		this.organizationid = organizationid;
	}

	public String getOrganizationname() {
		return organizationname;
	}

	public void setOrganizationname(String organizationname) {
		this.organizationname = organizationname;
	}

	public String getOrganizationdesc() {
		return organizationdesc;
	}

	public void setOrganizationdesc(String organizationdesc) {
		this.organizationdesc = organizationdesc;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
	
}

package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="students")
public class ListStudent {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;

	@Column(name="COLLEGE")
	private String college;

	@Column(name="STUDENTNAME")
	private String studentName;	


	public ListStudent() {							
		super();
	}


	public ListStudent(String college, String studentName) {
		super();
		this.college = college;
		this.studentName = studentName;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCollege() {
		return college;
	}


	public void setCollege(String college) {
		this.college = college;
	}


	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public String returnstudentNameDetails() {
		return college +":" + studentName; 
	}


	@Override
	public String toString() {
		return "ListStudent [id=" + id + ", college=" + college + ", studentName=" + studentName + "]";
	}
}




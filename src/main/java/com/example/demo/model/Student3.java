package com.example.demo.model;

import jakarta.persistence.Entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="form1c")
/*@SecondaryTables({
	@SecondaryTable(name="Form1b"),
	@SecondaryTable(name="Form1c")
})*/

public class Student3 {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="studentName" ,nullable=false)
	private String StudentName;
	
	@Column(name="adminNo",nullable=false)
	private String AdminNo;
	
	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String studentName) {
		this.StudentName = studentName;
	}

	public String getAdminNo() {
		return AdminNo;
	}

	public void setAdminNo(String adminNo) {
		this.AdminNo = adminNo;
	}
}

package com.springbootapplication.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMP_SYSTEM4")
public class Employee{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String First_Name;
	private String Second_Name;
	private String Email_id;
	private String Ph_No;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_Name() {
		return First_Name;
	}
	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}
	public String getSecond_Name() {
		return Second_Name;
	}
	public void setSecond_Name(String second_Name) {
		Second_Name = second_Name;
	}
	public String getEmail_id() {
		return Email_id;
	}
	public void setEmail_id(String email_id) {
		Email_id = email_id;
	}
	public String getPh_No() {
		return Ph_No;
	}
	public void setPh_No(String ph_No) {
		Ph_No = ph_No;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", First_Name=" + First_Name + ", Second_Name=" + Second_Name + ", Email_id="
				+ Email_id + ", Ph_No=" + Ph_No + "]";
	}
}

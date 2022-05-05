package com.te.employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee_Info {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int employee_id;
	@Column(nullable = false)
	private String employee_name;
	@Column(nullable = false)
	private String employee_type;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String password;
	public Employee_Info() {
		super();
	}
	public Employee_Info(int employee_id, String employee_name, String employee_type, String email, String password) {
		super();
		this.employee_id = employee_id;
		this.employee_name = employee_name;
		this.employee_type = employee_type;
		this.email = email;
		this.password = password;
	}
	@Override
	public String toString() {
		return "Employee_Info [employee_id=" + employee_id + ", employee_name=" + employee_name + ", employee_type="
				+ employee_type + ", email=" + email + ", password=" + password + "]";
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public String getEmployee_type() {
		return employee_type;
	}
	public void setEmployee_type(String employee_type) {
		this.employee_type = employee_type;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}

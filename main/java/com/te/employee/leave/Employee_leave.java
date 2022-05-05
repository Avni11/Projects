package com.te.employee.leave;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.te.employee.Employee_Info;

@Entity
public class Employee_leave {
	@Id
	private int id;
	@Column(nullable = false)
	private String leave_date;
	@Column(nullable = false)
	private String leave_status = "pending";
	@ManyToOne(cascade = CascadeType.ALL)
	private Employee_Info einfo;
	public Employee_leave() {
		super();
	}
	public Employee_leave(int id, String leave_date, String leave_status, Employee_Info einfo) {
		super();
		this.id = id;
		this.leave_date = leave_date;
		this.leave_status = leave_status;
		this.einfo = einfo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLeave_date() {
		return leave_date;
	}

	public void setLeave_date(String leave_date) {
		this.leave_date = leave_date;
	}

	public String getLeave_status() {
		return leave_status;
	}

	public void setLeave_status(String leave_status) {
		this.leave_status = leave_status;
	}

	public Employee_Info getEinfo() {
		return einfo;
	}

	public void setEinfo(Employee_Info einfo) {
		this.einfo = einfo;
	}

	@Override
	public String toString() {
		return "Employee_leave [id=" + id + ", leave_date=" + leave_date + ", leave_status=" + leave_status + ", einfo="
				+ einfo + "]";
	}

}

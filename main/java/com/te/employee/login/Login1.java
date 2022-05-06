package com.te.employee.login;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.te.employee.Employee_Info;
import com.te.employee.Register;
import com.te.employee.leave.Employee_leave;

public class Login1 {
	int id;
	String password;
	int choice1;
	@Override
	public String toString() {
		return "Login [username=" + id + ", password=" + password + "]";
	}

	public void login(Scanner sc, Login1 l, EntityManager manager, Employee_leave el) {
		System.out.println("enter id");
		l.id = sc.nextInt();
		System.out.println("enter password");
		l.password = sc.next();
		Query query = manager.createQuery(" from Employee_Info where id=:i and password=:j");// fetch particular id data
		query.setParameter("i", l.id);
		query.setParameter("j", l.password);
		Register re1 = new Register();
		List<Employee_Info> result = query.getResultList();
		System.out.println(result);
		if (!result.isEmpty()) {
			System.out.println("Login Success!!!");
			int n = 1;
			Employee_Info lst = manager.find(Employee_Info.class, l.id);// geting all value for id
			if (lst.getEmployee_type().equals("manager")) {
				Manager man = new Manager();
				man.managerfunc(manager);
			} 
			else {
				Employee emp = new Employee();
				emp.empfunc(manager,el,l.id);
			}
		}
		else {
			System.out.println("Invalid credintials");
             System.out.println("wish to Regeister y/n?");
             if(sc.next()=="y") {
            	re1.Register(id);
             }
	}
	}
}
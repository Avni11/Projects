package com.te.employee;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Register {
	public void Register(int id) {
		Scanner sc = new Scanner(System.in);
		Employee_Info emp = new Employee_Info();
		emp.setEmployee_id(id);
		System.out.println("enter employeename");
		emp.setEmployee_name(sc.next());
		System.out.println("enter employee type ");
		emp.setEmployee_type(sc.next());
		System.out.println("enter emailid");
		emp.setEmail(sc.next());
		System.out.println("enter password");
		emp.setPassword(sc.next());
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("employee_db");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		em.persist(emp);
		tr.commit();
		System.out.println("Register successful");

	}

}

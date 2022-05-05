package com.te.employee;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Register {
	public void add(Scanner sc,Employee_Info empinf) {
		System.out.println("enter employee name");
		empinf.setEmployee_name(sc.next());
		System.out.println("enter employee type");
		empinf.setEmployee_type(sc.next());
		System.out.println("enter email id");
		empinf.setEmail(sc.next());
		System.out.println("enter password");
		empinf.setPassword(sc.next());
	}
	
	

}

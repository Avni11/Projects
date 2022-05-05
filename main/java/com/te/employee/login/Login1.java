package com.te.employee.login;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.te.employee.Employee_Info;
import com.te.employee.leave.Employee_leave;
import com.te.employee.leave.Leave;

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
		Query query = manager.createQuery(" from Employee_Info where id=:i and password=:j");//fetch particular id data
		query.setParameter("i", l.id);
		query.setParameter("j", l.password);
		List<Employee_Info> result = query.getResultList();
		if (!result.isEmpty()) {
			int n = 1;
			Employee_Info lst = manager.find(Employee_Info.class, l.id);// geting all value for id
			if (lst.getEmployee_type().equals("manager")) {//type manager
				while (n != 3) {
					System.out.println("1.show leave Requests 2.Approve/Reject");
					int ans = sc.nextInt();//geting manager option
					    if (ans == 1) {//display  leave requests
						         Query query1 = manager.createQuery("from Employee_leave");
						         List<Employee_leave> res = query1.getResultList();
						         for (Employee_leave employee_leave : res) {
							     System.out.println(employee_leave);
						             }
					    }
					    else {
						       System.out.println("choose id to approve/Reject ");
						       
						       int ap_re = sc.nextInt();//geting id for reject/approve
						       System.out.println("ap_re"+ap_re);
						       Employee_leave one = manager.find(Employee_leave.class, ap_re);
						       System.out.println(Arrays.asList(one).contains(ap_re));
						           System.out.println(one);
						       if (one!=null) {
						            	 int a;
							              System.out.println("press 1 to Approve 2 to Reject");
							              a = sc.nextInt();
							              manager.getTransaction().begin();
							              if (a == 1) {
								                 one.setLeave_status("Approved");   
								                 manager.persist(one);
                                                    } else{if (a == 2) {
							                         	    one.setLeave_status("Rejected");
								                            manager.persist(one);
							                                  } else {
								                               System.out.println("enter valid option (1/2)");
							                                          }
							                                 } 
							         manager.getTransaction().commit();
						            }     
					         	else {
							           System.out.println("for entered id there is no leave request");
						             }
					    }
					    System.out.println("press 3 to exit \n any number to continue");
					    n = sc.nextInt();				
					    }
			} else {
				int x = 1;
				while (x != 3) {
					System.out.println("1.check leave status 2.apply for leave");
					int e_da = sc.nextInt();
					if (e_da == 1) {
						 Query query1 = manager.createQuery("from Employee_leave where id=:i");
						 query1.setParameter("i",l.id);
				         List<Employee_leave> res = query1.getResultList();
				         for (Employee_leave employee_leave : res) {
					     System.out.println(employee_leave);
				             }
					} else {
						System.out.println("enter your id");
						el.setId(sc.nextInt());
						System.out.println("enter leave  date");
						el.setLeave_date(sc.next());
						el.setLeave_status("pending");
						System.out.println(el);
						manager.getTransaction().begin();
						manager.persist(el);
						manager.getTransaction().commit();

					}
					System.out.println("enter 3 to exit \n press any number to continue");
					x = sc.nextInt();
				}
				System.out.println("pgm ended");
			}

		} else {
			System.out.println("Invalid credintials");

		}
	}
}

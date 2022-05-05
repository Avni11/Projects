package com.te.employee.login;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.te.employee.leave.Employee_leave;

public class Manager {

	public void managerfunc(EntityManager manager) {
		Scanner sc = new Scanner(System.in);
		int n = 1;
		while (n != 3) {
			System.out.println("1.show leave Requests /n 2.Approve/Reject");
			int ans = sc.nextInt();
			if (ans == 1) {
				Query query1 = manager.createQuery("from Employee_leave");
				List<Employee_leave> res = query1.getResultList();
				for (Employee_leave employee_leave : res) {
					System.out.println(employee_leave);
				}
			} else {
				System.out.println("choose id to approve/Reject ");
				int ap_re = sc.nextInt();
				System.out.println("ap_re" + ap_re);
				Employee_leave one = manager.find(Employee_leave.class, ap_re);
				System.out.println(Arrays.asList(one).contains(ap_re));
				System.out.println(one);
				if (one != null) {
					int a;
					System.out.println("press 1 to Approve 2 to Reject");
					a = sc.nextInt();
					manager.getTransaction().begin();
					if (a == 1) {
						one.setLeave_status("Approved");
						manager.persist(one);
					} else {
						if (a == 2) {
							one.setLeave_status("Rejected");
							manager.persist(one);
						} else {
							System.out.println("enter valid option (1/2)");
						}
					}
					manager.getTransaction().commit();
				} else {
					System.out.println("for entered id there is no leave request");
				}
			}
			System.out.println("press 3 to exit \n any number to continue");
			n = sc.nextInt();
		}
	}
}

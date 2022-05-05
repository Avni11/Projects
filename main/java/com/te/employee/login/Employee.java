package com.te.employee.login;

import java.util.Scanner;
import java.util.List;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Arrays;
import com.te.employee.Employee_Info;
import com.te.employee.leave.Employee_leave;

public class Employee {
	public void empfunc(EntityManager manager, Employee_leave el, int id) {
		Scanner sc = new Scanner(System.in);
		Employee_Info empi = new Employee_Info();
		int x = 1;
		while (x != 3) {
			System.out.println("1.check leave status \n 2.apply for leave");
			int e_da = sc.nextInt();
			if (e_da == 1) {
				Employee_leave leave_sts = manager.find(Employee_leave.class, id);
				if (leave_sts == null) {
					System.out.println("There is no leave requests");
				} else {
					System.out.println(leave_sts);
				}
			} else {
				if (e_da == 2) {
					System.out.println("enter your id");
					el.setId(sc.nextInt());
					System.out.println("enter leave  date");
					el.setLeave_date(sc.next());
					el.setLeave_status("pending");
					empi.setEl(Arrays.asList(el));
					manager.getTransaction().begin();
					manager.persist(Arrays.asList(el));
					manager.getTransaction().commit();
					System.out.println("Leave Applied");
				} else {
					System.out.println("Enter either 1 for check leave status or 2 for apply leave");
				}
			}
			System.out.println("Enter 3 to exit \n press any number to continue");
			x = sc.nextInt();
		}
	}
}

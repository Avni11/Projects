package com.te.employee.leave;
import java.util.Scanner;
public class Leave {
	public static void leave(Scanner sc, Employee_leave el) {
		System.out.println("enter employee id");
		el.setId(sc.nextInt());
		System.out.println("enter your leave date");
		el.setLeave_date(sc.next());
		el.setLeave_status("Applied");
		
	}
}

package jp.co.sss.crud.io;

import java.util.List;

import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.util.ConstantMsg;

public class ConsoleWriter {
	public static void showEmployees(List<Employee> employeeList) {
		if (employeeList.isEmpty()) {
			System.out.println(ConstantMsg.NOT_FOUND + "\n");

		} else {
			System.out.println(ConstantMsg.HEADER_EMPLOYEE_TABLE);

			for (Employee emp : employeeList) {
				System.out.println(emp);
			}

			System.out.println("");
		}
	}

}

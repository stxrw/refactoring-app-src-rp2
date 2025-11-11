package jp.co.sss.crud.service;

import java.sql.SQLException;
import java.util.List;

import jp.co.sss.crud.db.DBController;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeAllFindService implements IEmployeeService {
	public void execute() throws SystemErrorException {

		try {
			List<Employee> employeeList = DBController.findAll();

			if (employeeList.isEmpty()) {
				System.out.println(ConstantMsg.NOT_FOUND + "\n");
			} else {
				System.out.println(ConstantMsg.HEADER_EMPLOYEE_TABLE);
				for (Employee emp : employeeList) {
					System.out.println(emp);
				}
				System.out.println("");
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new SystemErrorException();
		}
	}

}

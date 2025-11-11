package jp.co.sss.crud.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

import jp.co.sss.crud.db.DBController;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeFindByEmpNameService {
	public void execute() throws SystemErrorException, IllegalInputException {
		try {
			// 社員名検索
			System.out.print("社員名:");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			// 検索ワード
			String searchWord = br.readLine();

			List<Employee> employeeList = DBController.findByEmpName(searchWord);

			if (employeeList.isEmpty()) {
				System.out.println(ConstantMsg.NOT_FOUND + "\n");
			} else {
				System.out.println(ConstantMsg.HEADER_EMPLOYEE_TABLE);
				for (Employee emp : employeeList) {
					System.out.println(emp);
				}
				System.out.println("");
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			throw new SystemErrorException();
		}
	}

}

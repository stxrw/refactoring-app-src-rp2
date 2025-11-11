package jp.co.sss.crud.service;

import static jp.co.sss.crud.util.ConstantMsg.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;

public class EmployeeFindByEmpNameService implements IEmployeeService {
	public void execute() throws SystemErrorException, IllegalInputException {
		try {
			// 社員名検索
			System.out.print("社員名:");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			// 検索ワード
			String searchWord = br.readLine();

			List<Employee> employeeList = new EmployeeDAO().findByEmployeeName(searchWord);

			ConsoleWriter.showEmployees(employeeList);

		} catch (IOException e) {
			throw new SystemErrorException(MSG_SYSTEM_ERROR, e);
		}
	}

}

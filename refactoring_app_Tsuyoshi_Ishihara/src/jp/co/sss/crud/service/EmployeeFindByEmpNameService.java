package jp.co.sss.crud.service;

import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeNameReader;

public class EmployeeFindByEmpNameService implements IEmployeeService {
	public void execute() throws SystemErrorException, IllegalInputException {

		EmployeeNameReader nameReader = new EmployeeNameReader();
		// 社員名検索
		System.out.print("社員名:");

		// 検索ワード
		String searchWord = (String) nameReader.input();

		List<Employee> employeeList = new EmployeeDAO().findByEmployeeName(searchWord);

		ConsoleWriter.showEmployees(employeeList);
	}

}

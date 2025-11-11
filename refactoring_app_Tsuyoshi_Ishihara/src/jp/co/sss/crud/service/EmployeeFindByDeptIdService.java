package jp.co.sss.crud.service;

import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeDeptIdReader;

public class EmployeeFindByDeptIdService implements IEmployeeService {
	public void execute() throws SystemErrorException, IllegalInputException {
		EmployeeDeptIdReader deptIdReader = new EmployeeDeptIdReader();

		// 社員名検索
		System.out.print("部署ID(1:営業部、2:経理部、3:総務部)を入力してください:");

		// 検索対象の部署ID
		int deptIdTarget = (int) deptIdReader.input();

		List<Employee> employeeList = new EmployeeDAO().findByDeptId(deptIdTarget);

		ConsoleWriter.showEmployees(employeeList);

	}

}

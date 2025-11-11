package jp.co.sss.crud.service;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.EmployeeBirthdayReader;
import jp.co.sss.crud.io.EmployeeDeptIdReader;
import jp.co.sss.crud.io.EmployeeEmpIdReader;
import jp.co.sss.crud.io.EmployeeGenderReader;
import jp.co.sss.crud.io.EmployeeNameReader;
import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeUpdateService implements IEmployeeService {
	public void execute() throws SystemErrorException, IllegalInputException {
		EmployeeEmpIdReader empIdReader = new EmployeeEmpIdReader();
		EmployeeDeptIdReader deptIdReader = new EmployeeDeptIdReader();
		EmployeeNameReader nameReader = new EmployeeNameReader();
		EmployeeGenderReader genderReader = new EmployeeGenderReader();
		EmployeeBirthdayReader birthDayReader = new EmployeeBirthdayReader();
		Integer result;

		// 更新する社員IDを入力
		System.out.print("更新する社員の社員IDを入力してください：");
		int empIdUpdate = (int) empIdReader.input();

		// 登録する値を入力
		System.out.print("社員名:");
		String empName = (String) nameReader.input();

		System.out.print("性別(0:その他, 1:男性, 2:女性, 9:回答なし):");
		int gender = (int) genderReader.input();

		System.out.print("生年月日(西暦年/月/日):");
		String birthday = (String) birthDayReader.input();

		System.out.print("部署ID(1:営業部、2:経理部、3:総務部):");
		int deptId = (int) deptIdReader.input();

		Employee employee = new Employee();
		employee.setEmpId(empIdUpdate);
		employee.setEmpName(empName);
		employee.setGender(gender);
		employee.setBirthDay(birthday);
		employee.setDeptId(deptId);

		result = new EmployeeDAO().update(employee);

		// 登録完了メッセージを出力
		if (Integer.valueOf(0).equals(result)) {
			System.out.println("対象者がいませんでした");
		} else {
			System.out.println(ConstantMsg.SUCCESS_UPDATE_EMPLOYEE);
		}

	}

}

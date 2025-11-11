package jp.co.sss.crud.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeUpdateService implements IEmployeeService {
	public void execute() throws SystemErrorException, IllegalInputException {
		try {
			Integer result;
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			// 更新する社員IDを入力
			System.out.print("更新する社員の社員IDを入力してください：");
			String empIdUpdate = br.readLine();

			// 登録する値を入力
			System.out.print("社員名:");
			String empName = br.readLine();
			System.out.print("性別(0:その他, 1:男性, 2:女性, 9:回答なし):");
			String gender = br.readLine();
			System.out.print("生年月日(西暦年/月/日):");
			String birthday = br.readLine();
			System.out.print("部署ID(1:営業部、2:経理部、3:総務部):");
			String deptId = br.readLine();

			Employee employee = new Employee();
			employee.setEmpId(Integer.parseInt(empIdUpdate));
			employee.setEmpName(empName);
			employee.setGender(Integer.parseInt(gender));
			employee.setBirthDay(birthday);
			employee.setDeptId(Integer.parseInt(deptId));

			result = new EmployeeDAO().update(employee);

			// 登録完了メッセージを出力
			if (Integer.valueOf(0).equals(result)) {
				System.out.println("対象者がいませんでした");
			} else {
				System.out.println(ConstantMsg.SUCCESS_UPDATE_EMPLOYEE);
			}

		} catch (IOException e) {
			throw new SystemErrorException();
		}
	}

}

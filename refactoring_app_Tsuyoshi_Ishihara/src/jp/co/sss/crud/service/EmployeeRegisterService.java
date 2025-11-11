package jp.co.sss.crud.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.db.DBController;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;

public class EmployeeRegisterService {
	public void execute() throws SystemErrorException, IllegalInputException {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			// 登録する値を入力
			System.out.print("社員名:");
			String empName = br.readLine();
			System.out.print("性別(0:その他, 1:男性, 2:女性, 9:回答なし):");
			String gender = br.readLine();
			System.out.print("生年月日(西暦年/月/日):");
			String birthday = br.readLine();
			System.out.print("部署ID(1:営業部、2:経理部、3:総務部):");
			String deptId = br.readLine();

			DBController.insert(empName, gender, birthday, deptId);

			// 登録完了メッセージを出力
			System.out.println("社員情報を登録しました");
		} catch (ClassNotFoundException | SQLException | IOException | ParseException e) {
			throw new SystemErrorException();
		}
	}

}

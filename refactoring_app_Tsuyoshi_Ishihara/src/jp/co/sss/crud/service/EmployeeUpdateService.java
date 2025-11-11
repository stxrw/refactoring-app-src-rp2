package jp.co.sss.crud.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.db.DBController;
import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeUpdateService {
	public void execute() throws ClassNotFoundException, SQLException, IOException, ParseException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 更新する社員IDを入力
		System.out.print("更新する社員の社員IDを入力してください：");

		String empIdUpdate = br.readLine();
		Integer.parseInt(empIdUpdate); //　数値判定

		// 登録する値を入力
		System.out.print("社員名:");
		String empName = br.readLine();
		System.out.print("性別(0:その他, 1:男性, 2:女性, 9:回答なし):");
		String gender = br.readLine();
		System.out.print("生年月日(西暦年/月/日):");
		String birthday = br.readLine();
		System.out.print("部署ID(1:営業部、2:経理部、3:総務部):");
		String deptId = br.readLine();

		DBController.update(empIdUpdate, empName, gender, birthday, deptId);

		// 登録完了メッセージを出力
		System.out.println(ConstantMsg.SUCCESS_UPDATE_EMPLOYEE);
	}

}

package jp.co.sss.crud.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.db.DBController;

public class EmployeeDeleteService {
	public void execute() throws ClassNotFoundException, SQLException, IOException, ParseException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 削除する社員IDを入力
		System.out.print("削除する社員の社員IDを入力してください：");

		String empIdDelete = br.readLine();
		Integer.parseInt(empIdDelete); //　数値判定

		DBController.delete(empIdDelete);

		// 登録完了メッセージを出力
		System.out.println("社員情報を削除しました");
	}

}

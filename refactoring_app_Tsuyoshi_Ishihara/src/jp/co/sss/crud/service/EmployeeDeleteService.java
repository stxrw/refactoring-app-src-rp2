package jp.co.sss.crud.service;

import static jp.co.sss.crud.util.ConstantMsg.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.exception.SystemErrorException;

public class EmployeeDeleteService implements IEmployeeService {
	public void execute() throws SystemErrorException {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Integer result;

			// 削除する社員IDを入力
			System.out.print("削除する社員の社員IDを入力してください：");

			String empIdDelete = br.readLine();
			int empIdDeleteInt = Integer.parseInt(empIdDelete); //　数値判定

			result = new EmployeeDAO().delete(empIdDeleteInt);

			// 登録完了メッセージを出力
			if (Integer.valueOf(0).equals(result)) {
				System.out.println("対象者がいませんでした");
			} else {
				System.out.println("社員情報を削除しました");
			}

		} catch (IOException e) {
			throw new SystemErrorException(MSG_SYSTEM_ERROR, e);
		}
	}

}

package jp.co.sss.crud.service;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.EmployeeEmpIdReader;

public class EmployeeDeleteService implements IEmployeeService {
	public void execute() throws SystemErrorException, IllegalInputException {

		EmployeeEmpIdReader empIdReader = new EmployeeEmpIdReader();
		Integer result;

		// 削除する社員IDを入力
		System.out.print("削除する社員の社員IDを入力してください：");
		int empIdDeleteInt = (int) empIdReader.input();

		//　DBに削除操作を実施
		result = new EmployeeDAO().delete(empIdDeleteInt);

		// 登録完了メッセージを出力
		if (Integer.valueOf(0).equals(result)) {
			System.out.println("対象者がいませんでした");
		} else {
			System.out.println("社員情報を削除しました");
		}

	}

}

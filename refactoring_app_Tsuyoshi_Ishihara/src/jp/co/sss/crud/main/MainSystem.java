package jp.co.sss.crud.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.service.EmployeeAllFindService;
import jp.co.sss.crud.service.EmployeeDeleteService;
import jp.co.sss.crud.service.EmployeeFindByDeptIdService;
import jp.co.sss.crud.service.EmployeeFindByEmpNameService;
import jp.co.sss.crud.service.EmployeeRegisterService;
import jp.co.sss.crud.service.EmployeeUpdateService;
import jp.co.sss.crud.util.ConstantMsg;
import jp.co.sss.crud.util.ConstantValue;

/**
 * 社員情報管理システム開始クラス 社員情報管理システムはこのクラスから始まる。<br/>
 * メニュー画面を表示する。
 *
 * @author System Shared
 *
 */
public class MainSystem {
	/**
	 * 社員管理システムを起動
	 *
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException, ParseException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int menuNo = 0;

		do {
			// メニューの表示
			System.out.println("=== 社員管理システム ===");
			System.out.println("1.全件表示");
			System.out.println("2.社員名検索");
			System.out.println("3.部署ID検索");
			System.out.println("4.新規登録");
			System.out.println("5.更新");
			System.out.println("6.削除");
			System.out.println("7.終了");
			System.out.print(ConstantMsg.INPUT_NO);

			// メニュー番号の入力
			String menuNoStr = br.readLine();
			menuNo = Integer.parseInt(menuNoStr);

			// 機能の呼出
			switch (menuNo) {
			case ConstantValue.MENU_FIND_ALL:
				// 全件表示機能の呼出
				EmployeeAllFindService employeeAllFindService = new EmployeeAllFindService();
				employeeAllFindService.execute();
				// DBController.findAll();
				break;

			case ConstantValue.MENU_FIND_BY_EMP_NAME:
				// 検索機能の呼出
				EmployeeFindByEmpNameService employeeFindByEmpNameService = new EmployeeFindByEmpNameService();
				employeeFindByEmpNameService.execute();
				// DBController.findByEmpName();
				break;

			case ConstantValue.MENU_FIND_BY_DEPT_ID:

				// 検索機能の呼出
				EmployeeFindByDeptIdService employeeFindByDeptIdService = new EmployeeFindByDeptIdService();
				employeeFindByDeptIdService.execute();
				break;

			case ConstantValue.MENU_INSERT:

				// 登録機能の呼出
				EmployeeRegisterService employeeRegisterService = new EmployeeRegisterService();
				employeeRegisterService.execute();
				break;

			case ConstantValue.MENU_UPDATE:

				// 更新機能の呼出
				EmployeeUpdateService employeeUpdateService = new EmployeeUpdateService();
				employeeUpdateService.execute();
				break;

			case ConstantValue.MENU_DELETE:
				// 削除機能の呼出
				EmployeeDeleteService employeeDeleteService = new EmployeeDeleteService();
				employeeDeleteService.execute();
				break;
			}

		} while (menuNo != ConstantValue.MENU_SHUT_DOWN);
		System.out.println(ConstantMsg.SHUT_DOWN);
	}
}

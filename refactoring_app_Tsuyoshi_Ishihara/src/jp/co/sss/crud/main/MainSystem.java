package jp.co.sss.crud.main;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.MenuNoReader;
import jp.co.sss.crud.service.IEmployeeService;
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
	 * @throws SystemErrorException 
	 */
	public static void main(String[] args) {

		MenuNoReader menuNoReader = new MenuNoReader();
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

			try {
				// メニュー番号の入力
				menuNo = (int) menuNoReader.input();

				if (menuNo != ConstantValue.MENU_SHUT_DOWN) {
					// サービスクラスの取得
					IEmployeeService employeeService = IEmployeeService.getInstanceByMenuNo(menuNo);

					// 機能の呼出
					employeeService.execute();
				}

			} catch (IllegalInputException e) {
				System.out.println(e.getMessage());
				continue;

			} catch (SystemErrorException e) {
				System.out.println(e.getMessage());
				break;
			}

		} while (menuNo != ConstantValue.MENU_SHUT_DOWN);
		System.out.println(ConstantMsg.SHUT_DOWN);
	}
}

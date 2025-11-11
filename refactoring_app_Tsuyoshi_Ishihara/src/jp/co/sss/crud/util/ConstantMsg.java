package jp.co.sss.crud.util;

/**
 * 設定値をまとめたクラス(メッセージ関連)
 *
 * @author System Shared
 *
 */
public class ConstantMsg {

	/** インスタンス化を禁止 */
	private ConstantMsg() {
	}

	// ***** コンソール表示用メッセージ *****

	/** メニュー選択の入力を促す */
	public static final String INPUT_NO = "メニュー番号を入力してください：";

	/** 該当する検索結果（従業員情報）がない時に表示 */
	public static final String NOT_FOUND = "該当者はいませんでした";

	/** 従業員情報の更新成功時に表示 */
	public static final String SUCCESS_UPDATE_EMPLOYEE = "社員情報を更新しました";

	/** システム終了時に表示 */
	public static final String SHUT_DOWN = "システムを終了します。";

	/** employeeテーブルのレコードを表示する際のヘッダ */
	public static final String HEADER_EMPLOYEE_TABLE = "社員ID\t社員名\t性別\t生年月日\t部署名";

}

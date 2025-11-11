package jp.co.sss.crud.util;

/**
 * 設定値をまとめたクラス(各項目値)
 *
 * @author System Shared
 *
 */
public class ConstantValue {

	/** インスタンス化を禁止 */
	private ConstantValue() {
	}

	// ***** システムのメニュー番号 *****
	/** 全件表示 */
	public static final int MENU_FIND_ALL = 1;

	/** 社員名検索 */
	public static final int MENU_FIND_BY_EMP_NAME = 2;

	/** 部署ID検索 */
	public static final int MENU_FIND_BY_DEPT_ID = 3;

	/** 新規登録 */
	public static final int MENU_INSERT = 4;

	/** 更新 */
	public static final int MENU_UPDATE = 5;

	/** 削除 */
	public static final int MENU_DELETE = 6;

	/** 削除 */
	public static final int MENU_SHUT_DOWN = 7;

	// ***** 性別（gender）の項目値 *****
	/** 回答なし */
	public static final int GENDER_EMPTY = 0;

	/** 男性 */
	public static final int GENDER_MALE = 1;

	/** 女性 */
	public static final int GENDER_FEMALE = 2;

	/** その他 */
	public static final int GENDER_OTHERS = 9;

	// ***** 部署ID（empId）の項目値 *****
	/** 営業部 */
	public static final int DEPT_SALES = 1;

	/** 経理部 */
	public static final int DEPT_ACCOUNTING = 2;

	/** 総務部 */
	public static final int DEPT_GENERAL = 3;

}

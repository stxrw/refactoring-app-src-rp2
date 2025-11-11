/**
 * 
 */
package jp.co.sss.crud.dto;

import jp.co.sss.crud.util.ConstantValue;

/**
 * 従業員情報を格納するdtoクラス
 */
public class Employee {
	private int empId;

	private String empName;

	private int gender;

	private String birthDay;

	private String deptName;

	@Override
	public String toString() {
		// genderを文字列に変換
		String genderString = getStringValOfGender(gender);

		return empId + "\t" + empName + "\t" + genderString + "\t" + birthDay + "\t" + deptName;
	}

	// ***helper メソッド***

	/**
	 * int型の性別を受け取って文字列の形式で返す
	 * @param gender 性別（int型）
	 * @return 性別の文字列
	 */
	private String getStringValOfGender(int gender) {
		String genderString = null;
		switch (gender) {
		case ConstantValue.GENDER_EMPTY:
			genderString = "回答なし";
			break;
		case ConstantValue.GENDER_MALE:
			genderString = "男性";
			break;
		case ConstantValue.GENDER_FEMALE:
			genderString = "女性";
			break;
		case ConstantValue.GENDER_OTHERS:
			genderString = "その他";
			break;
		}
		return genderString;
	}

	// ***setter　及び getter***
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

}

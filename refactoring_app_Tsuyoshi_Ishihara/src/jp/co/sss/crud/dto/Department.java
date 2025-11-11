package jp.co.sss.crud.dto;

/**
 * 部署情報を格納するdtoクラス
 */
public class Department {

	private int deptId;

	private String deptName;

	@Override
	public String toString() {
		return deptId + "\t" + deptName;
	}

	// ***setter　及び getter***
	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

}

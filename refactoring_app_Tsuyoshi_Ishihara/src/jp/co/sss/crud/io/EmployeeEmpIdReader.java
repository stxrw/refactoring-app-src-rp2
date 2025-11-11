package jp.co.sss.crud.io;

public class EmployeeEmpIdReader implements IConsoleReader {

	@Override
	public String getErrorMsg() {
		return "1以上9999以下の整数を入力してください";
	}

	@Override
	public boolean isValid(String inputString) {
		if (inputString == null) {
			return false;
		}

		if (inputString.matches("^[1-9１-９]{1}[0-9１-９]{0,3}$")) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isParseInt() {
		return true;
	}

}

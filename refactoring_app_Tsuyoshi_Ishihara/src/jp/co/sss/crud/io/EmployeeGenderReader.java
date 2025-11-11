package jp.co.sss.crud.io;

public class EmployeeGenderReader implements IConsoleReader {

	@Override
	public String getErrorMsg() {
		return "不正な入力値です。再度入力してください";
	}

	@Override
	public boolean isValid(String inputString) {
		if (inputString == null) {
			return false;
		}

		if (inputString.matches("^|[0129０１２９]{1}$")) {
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

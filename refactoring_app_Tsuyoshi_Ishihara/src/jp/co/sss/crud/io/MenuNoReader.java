package jp.co.sss.crud.io;

public class MenuNoReader implements IConsoleReader {

	@Override
	public String getErrorMsg() {
		return "1以上7以下の整数を入力してください";
	}

	@Override
	public boolean isValid(String inputString) {
		if (inputString == null) {
			return false;
		}

		if (inputString.matches("^[1-7１-７]{1}$")) {
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

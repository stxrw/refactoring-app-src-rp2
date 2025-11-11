package jp.co.sss.crud.io;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class EmployeeBirthdayReader implements IConsoleReader {

	@Override
	public String getErrorMsg() {
		return "正しい形式(西暦年/月/日)で日付を入力してください";
	}

	@Override
	public boolean isValid(String inputString) {
		if (inputString == null || inputString.isBlank()) {
			return false;
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		try {
			sdf.parse(inputString);
		} catch (ParseException e) {
			return false;
		}

		return true;
	}

	@Override
	public boolean isParseInt() {
		return false;
	}

}

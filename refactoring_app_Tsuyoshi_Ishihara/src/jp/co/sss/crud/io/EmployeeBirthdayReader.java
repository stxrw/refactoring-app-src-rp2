package jp.co.sss.crud.io;

public class EmployeeBirthdayReader implements IConsoleReader {

	@Override
	public String getErrorMsg() {
		return "正しい形式(西暦年/月/日)で日付を入力してください";
	}

	@Override
	public boolean isValid(String inputString) {
		//TODO 正しく実装できていないので要修正

		//		if (inputString == null || inputString.isBlank()) {
		//			return false;
		//		}
		//
		//		String[] inputArray = inputString.split("/");
		//		if (inputArray.length != 2) {
		//			return false;
		//		}
		//
		//		int year, month, day;
		//
		//		try {
		//			year = Integer.parseInt(inputArray[0]);
		//			month = Integer.parseInt(inputArray[1]);
		//			day = Integer.parseInt(inputArray[2]);
		//		} catch (NumberFormatException e) {
		//			return false;
		//		}
		//
		//		try {
		//			LocalDate.of(year, month, day);
		//		} catch (DateTimeException e) {
		//			return false;
		//		}

		//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		//		try {
		//			sdf.parse(inputString);
		//		} catch (ParseException e) {
		//			return false;
		//		}

		return true;
	}

	@Override
	public boolean isParseInt() {
		return false;
	}

}

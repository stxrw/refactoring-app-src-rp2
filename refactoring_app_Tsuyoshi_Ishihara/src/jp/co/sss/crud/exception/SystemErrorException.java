package jp.co.sss.crud.exception;

public class SystemErrorException extends Exception {
	public SystemErrorException(String errorMsg, Throwable cause) {
		super(errorMsg, cause);
	}

}

package exception;

public class DuplicateException extends Exception {

	public DuplicateException() {
		super("존재하는 데이터입니다.!!");
	}

	public DuplicateException(String message) {
		super(message+" : 존재하는 데이터입니다.!!");
	}

}
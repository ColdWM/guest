package exception;

public class RecordNotFoundException extends Exception {

	public RecordNotFoundException() {
		super("존재하지 않는 데이터입니다.!!");
	}

	public RecordNotFoundException(String message) {
		super(message+" : 존재하지 않는 데이터입니다.!!");
	}

}
package pfpsc.service.exception;

public class UserException extends Exception {
	String information;
	public UserException() {};
	public UserException(String string) {
		information=string;
	}

}

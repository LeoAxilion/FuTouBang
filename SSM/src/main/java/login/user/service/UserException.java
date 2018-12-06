package login.user.service;

/**
 * 0自定义一个异常类
 *  1只是给出父类中的构造器即可！方便来创建对象
 */
public class UserException extends Exception{

	private static final long serialVersionUID = 1L;

	public UserException() {
		super();
	}
	
	public UserException(String message) {
		super(message);
	}
	
	public UserException(String message,Throwable cause) {
		super(message,cause);
	}
}

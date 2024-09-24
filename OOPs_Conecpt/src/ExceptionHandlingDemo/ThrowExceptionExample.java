package ExceptionHandlingDemo;

class VoteException extends Exception {
	public VoteException() {
		super();
		System.out.println("Hi");
		
	}
	public VoteException(String msg) {
		super(msg);  // calling parameterized constructor of Exception to set the message 
	}
}
public class ThrowExceptionExample {

	public static void main(String[] args) {
	int age=17;
		try {
		if(age>=18) {
			System.out.println("You Can Vote!");
		}else {
//			throw new Exception();// generic exception 
//			throw new Exception("age must be >=18");
//			throw new VoteException();
			throw new VoteException("age must be >=18");
		}
	}catch(Exception e) {
		System.out.println(e);
	}
	}

}

package ExceptionHandlingDemo;

public class RunTimeExceptionExample {

	public static void main(String[] args) {
		System.out.println("Hi");
		int a=10;
		int b=1;
		int abc[]= {10,20,30,40};
		String str = "10a";
	try {
	int res =a/b;
	System.out.println("Result is "+res);
	int res1 = abc[2];
	System.out.println("Result is "+res1);
	System.out.println(str+10);
	System.out.println(Integer.parseInt(str)+10);
	}catch(Exception e) {
		//System.out.println("I Take Care!");
		//System.out.println(e.getMessage());
		System.out.println(e.toString());
		//e.printStackTrace();
	}
		System.out.println("bye...");
		System.out.println("bye...");
		System.out.println("bye...");
		
	}

}
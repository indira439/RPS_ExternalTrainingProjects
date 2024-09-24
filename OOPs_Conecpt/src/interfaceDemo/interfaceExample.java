package interfaceDemo;

public interface interfaceExample {
	int a = 10;
	void displayPen();
	default void common() {
		System.out.println("interface1");

	}

} 

interface interface2{
	 void displayPencil() ;
	default void common() {
		System.out.println("interface2");

	}
}

class write implements interfaceExample, interface2{
	public static void main(String[] args)
	{

	}

	@Override
	public void displayPencil() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayPen() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void common() {
		// TODO Auto-generated method stub
		interface2.super.common();
	}




}

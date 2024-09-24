package interfaceDemo;


interface A {
	public int add(int x, int y);
	
}
interface B {	
	public int sub(int x, int y);
}
class ClientImpl implements A,B {
	@Override
	public int add(int x, int y) {
		return x+y;
	}
	@Override
	public int sub(int x, int y) {
		return x-y;
	}
	public void serverMethod() {
		System.out.println("Own method");
	}
}
public class InterfacePolymorphisim {

	public static void main(String[] args) {
		ClientImpl obj1 = new ClientImpl();
		System.out.println(obj1.add(10, 20));
		System.out.println(obj1.sub(10, 5));
		obj1.serverMethod();
		A obj2 = new ClientImpl();
		B obj3 = new ClientImpl();
		System.out.println(obj2.add(10, 30));
		//System.out.println(obj2.sub(10,5)));
		//obj2.serverMethod();
		//System.out.println(obj3.add(10, 30));
		System.out.println(obj3.sub(10, 30));

	}
}

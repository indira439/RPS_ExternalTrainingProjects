package polymorphism;

class Operation {
	public void add() {
		System.out.println(10+20);
	}
	public void add(int x) {
		System.out.println(x+20);
	}
	public void add(int x, int y) {
		System.out.println(x+y);
	}
	public void add(float x, float y) {
		System.out.println(x+y);
	}
	public void add(String x, String y) {
		System.out.println(x+y);
	}
	public void add(int...abc) {
		
	}
}
public class MethodOverloading {
	public static void main(String []args) {
	Operation op = new Operation();
	op.add(10);
	op.add(10, 20);
	op.add(10.10f, 20.20f);
	op.add();
	op.add("10", "20");
	}

}
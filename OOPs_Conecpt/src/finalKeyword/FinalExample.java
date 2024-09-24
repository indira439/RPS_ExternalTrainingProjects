package finalKeyword;

final class Bike {
	final void speed() {
		System.out.println("60km/hr");
	}
}
class Honda  {		
	public Honda() {
		// TODO Auto-generated constructor stub
	}
	void speed() {
		System.out.println("90km/hr");
	}
	void colour() {
		System.out.println("Red Colour");
	}
}
public class FinalExample {

	public static void main(String[] args) {
		final int A=10;
//		A = 20;
		Honda hh = new Honda();
		hh.speed();
		
		Bike bk = new Bike();
		bk.speed();
	}	

}
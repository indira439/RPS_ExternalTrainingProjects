package abstractDemo;

abstract class Bike {
	abstract void speed();
	Bike() {
		System.out.println("bike class object created...");
	}
}
class Honda extends Bike {	
	Honda(){
//		super();
		System.out.println("Honda Constructor");
	}
	@Override
	void speed() {
		System.out.println("60km/hr");
	}
	void colour() {
		System.out.println("Red Colour");
	}
}
class Pulsar extends Bike {
	void colour() {
		System.out.println("Black Colour");
	}
	@Override
	void speed() {					// override it 
		System.out.println("90km/hr");
	}
}
public class AbstarctExample {
	public static void main(String[] args) {
	Honda hh = new Honda(); 
//	hh.speed(); hh.colour();
	Pulsar pu = new Pulsar(); 
//	pu.speed(); pu.colour();
//	Bike bb = new Bike();
	}

}
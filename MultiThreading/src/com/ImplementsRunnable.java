package com;
class C implements Runnable {

	@Override
	public void run() {
		for(int i=0;i<=10;i++) {
			System.out.println("i "+i);
		}
	}	
}
class D implements Runnable {
	@Override
	public void run() {
		for(int j=0;j<=10;j++) {
			System.out.println("j "+j);
		}
	}
}
public class ImplementsRunnable {
	public static void main(String[] args) {
		Runnable obj1 = new C();
		Runnable obj2 = new D();
		
		
		Thread t1 = new Thread(obj1);
		Thread t2 = new Thread(obj2);
		t1.run();
		t2.start();
	}

}
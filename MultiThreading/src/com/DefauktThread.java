package com;

public class DefauktThread {

	public static void main(String[] args) {
	Thread t = Thread.currentThread();
	System.out.println(t);
	t.setName("Demo Thread");
	t.setPriority(10);
	System.out.println(t);
	}

}
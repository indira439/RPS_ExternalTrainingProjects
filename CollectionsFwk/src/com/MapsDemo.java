package com;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapsDemo {

	public MapsDemo() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		
		Map mm = new HashMap();
		mm.put(1, "indu");
		mm.put("in", 1);
		mm.put(2, "shiva");
		
		System.out.println("key present" + mm.containsKey(1));
		System.out.println("key present" + mm.containsValue(1));
		System.out.println("key present" + mm);
		
		Map mp = new LinkedHashMap(mm);
		System.out.println("key present" + mm);
		
	}

	

}

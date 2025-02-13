package com;

import reactor.core.publisher.Mono;

public class MonoExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Mono mm2 = Mono.just("Hi Indu");
		
		mm2.subscribe(data -> System.out.println(data));
		
		
		// 2nd example 	
				Mono<String> mm	= Mono.justOrEmpty("Hello");			// backend 
																		// frontend 
				mm.subscribe(
						data-> {
							System.out.println(data);
						},
						error->{
							System.out.println(error);
						},
						()-> {
							System.out.println("done");
						}
				);
			

	}

}

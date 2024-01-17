package com.javaex.ex03;

public class Ex01 {

	public static void main(String[] args) {
		//출장 1~20
		DigitThreadImpl dt = new DigitThreadImpl();
		
		Thread thread = new Thread(dt);
		thread.start();
		
		
		for(char ch='A'; ch<='Z'; ch++) {
			System.out.println(ch);
			try {
				Thread.sleep(1000);
			} catch(Exception e) {
				System.out.println("처리");
			}
			
		}
	}

}

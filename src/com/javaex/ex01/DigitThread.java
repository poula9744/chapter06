package com.javaex.ex01;

public class DigitThread extends Thread {

	//필드
	
	//생성자
	
	//메소드
	public void run() {
		for(int i=0; i<=30; i++) {
			System.out.println(i);
			
			try {
				Thread.sleep(1000); //속도조절. 하나찍고 좀 쉬고
			} catch (Exception e) {
				System.out.println(e);
			}
			
		}
	}

}

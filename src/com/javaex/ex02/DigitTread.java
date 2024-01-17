package com.javaex.ex02;

public class DigitTread extends Thread{

	//필드
	//생성자
	//메소드
	public void run() {
		for(int i=0; i<=30; i++) {
			System.out.println(i);
			
			try {
				Thread.sleep(400);
			} catch(Exception e) {
				System.out.println(e);
			}
		}
	}
}

package com.javaex.ex02;

public class UpperThread extends Thread {

	//필드
	//생성자
	//메소드
	public void run() {
		for(char ch='A'; ch<='Z'; ch++) {
			System.out.println(ch);	
			try {
				Thread.sleep(800);
			} catch(Exception e) {
				System.out.println(e);
			}
		}
	}
}

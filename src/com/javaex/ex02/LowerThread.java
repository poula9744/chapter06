package com.javaex.ex02;

public class LowerThread extends Thread{

	//필드
	//생성자
	//메소드
	public void run() {
		for(char ch='a'; ch<='z'; ch++) {
			System.out.println(ch);
			try {
				Thread.sleep(800);
			} catch(Exception e) {
				System.out.println(e);
			}
		}
	}
}

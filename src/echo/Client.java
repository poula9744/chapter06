package echo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws IOException {
		
		Socket socket = new Socket();
		
		System.out.println("<클라이언트 시작>");
		System.out.println("==================================================");
		System.out.println("[서버에 연결을 요청합니다.]");
		socket.connect(new InetSocketAddress("192.168.0.79", 10001));
		
		System.out.println("[서버에 연결 되었습니다.]");
		
		//메세지 보내기: write
		//OutputStream out = new FileOutputStream("C:\\javaStudy\\song.txt");
		
		OutputStream os = socket.getOutputStream(); // 소켓<---내놔
		OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);
		
		//메세지 받기용 스트림
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		bw.write(str);
		bw.newLine();
		
		//Buffered는 일정한 양을 모아서 보냄
		//일정한 양이 안 차도 보내도록 설정 필요
		bw.flush();
		
		//읽기
		String remsg = br.readLine();
		System.out.println("받은 메세지: " + remsg);
		
		//닫기
		socket.close();
		br.close();
		bw.close();
		sc.close();
	}

}

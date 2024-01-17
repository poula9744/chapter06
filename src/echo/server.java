package echo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server {

	public static void main(String[] args) throws IOException {

		// 서버소켓 생성
		ServerSocket serverSocket = new ServerSocket();

		// 바인딩
		serverSocket.bind(new InetSocketAddress("192.168.0.44", 10001)); // 아이피, 포트번호

		// 서버시작
		System.out.println("<서버시작>");
		System.out.println("==================================================");
		System.out.println("[연결을 기다리고 있습니다.]");

		// 클라이언트 접속을 하면 accept()가 실행됨
		Socket socket = serverSocket.accept(); // 대기중
		System.out.println("[클라이언트가 연결되었습니다.]");

		// in
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader br = new BufferedReader(isr);

		// out 메세지 보내기용 스트림
		OutputStream os = socket.getOutputStream();
		OutputStreamWriter isw = new OutputStreamWriter(os, "UTF-8");
		BufferedWriter bw = new BufferedWriter(isw);
		
		//스캐너 준비
		Scanner sc = new Scanner(System.in);

		while (true) {

			// 읽기
			String message = br.readLine();
			
			if (message==null) {
				break;
			}
			
			System.out.println("받은 메세지: " + message);

			
			// 키보드 입력
			System.out.print("[입력]: ");
			String str = sc.nextLine();
			
			// 메세지 보내기
			bw.write(str);
			bw.newLine();
			bw.flush();
		}
		
		System.out.println("=======================================");
		System.out.println("=============<서버 종료>=============");
		System.out.println("=======================================");
		

		// 닫기
		sc.close();
		serverSocket.close();
		socket.close();
		bw.close();
		br.close();
	}

}

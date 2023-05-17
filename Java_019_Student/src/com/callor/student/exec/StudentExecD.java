package com.callor.student.exec;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class StudentExecD {
	
	public static void main(String[] args) {
		/*
		 * 컴퓨터 줒기억장치 외부로부터(키보드, 파일, 네트워크 등)을 통하여
		 * 데이터를 입력받는 통로
		 * 정보처리에서 모든 데이터는 주기억장치에 적재(저장)되어야만
		 * 그 이후로 모든 것을 처리할 수 있다.
		 * 주기억장치를 기준으로 연결되어 사용되는 여러 통로를
		 * Stream이라고 하고,
		 * 주기억장치에 데이터가 들어오는 경우 InputStream
		 * 주기억장치로 부터 데이터가 나가는 경우 OutputStream 이라고 한다.
		 */
		InputStream is = System.in;
		
		/*
		 * InputStream을 통하여 키보드에서 데이터를 직접 주기억장치에
		 * 저장하는 코드를 작성할수도 있지만, 상당히 많은 코드를
		 * 직접 작성해야 한다.
		 * 그러한 수고를 Scanner 클래스를 통하여 대신 처리한다.
		 */
		Scanner scan = new Scanner(is);
		String studentFile = "src/com/callor/student/student.txt";
		
		OutputStream os = null;
		PrintWriter out = null;
		
		try {
			os = new FileOutputStream(studentFile);
			out = new PrintWriter(os);
			for(int i=0; i<10; i++) {
				
				out.print("0001 ,");
				out.print("홍길동 ,");
				out.print("정보통신 ,");
				out.print("3 ,");
				out.print("010-111-1111");
				out.println();
				
			}
			out.close();
			os.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}

package com.callor.classes.exec;

/*
 * Java의 class
 * 객체지향 프로그래밍 방법론적인 부분에서
 * 가장 표준적인 코딩 스타일
 * 
 * Java는 모든 코드(파일)가 기본적으로 class 로 부터 시작한다.
 * 
 * Java의 소스코드는 *.java 라는 이름으로 파일이 저장되지만
 * "Java 클래스 파일" 이라고 명명한다.
 * 
 * method 들이 포함되고, 변수들이 포함된다.
 * method만 있는 클래스 파일이 있고,
 * 변수들만 있는 클래스 파일이 있고,
 * method와 변수하 함께 있는 파일이 있다.
 * 
 * 코드를 테스트하고 실행하기 위해 main() method를 작성한다.
 * main() method를 진입점, 시작점 method라고 하며
 * main() method를 포함하는 java class 코드를 진입점 코드라고 한다.
 */
public class ExecA {
	
	public static void main(String[] args) {
		
		int num1 = (int)(Math.random() * 50) + 51;
		
		// 여러개의 정수형을 저장할 수 있는 정수형 배열 선언
		// 10개의 정수를 저장할 수 있는 배열 만들기
		int[] arrNum = new int[10];
		
		// 생성된 배열(공간)에 정수값을 저장하기
		// 배열에 값을 저장하기 위해서는 배열의 index를 지정 (배열[index])
		// 배열의 index는 항상 0부터 시작
		// 배열의 index 끝은 (배열의 길이) - 1
		arrNum[0] = 100;
		arrNum[1] = 99;
		arrNum[2] = 98;
		arrNum[3] = 97;
		arrNum[4] = 96;
		arrNum[5] = 95;
		arrNum[6] = 94;
		arrNum[7] = 93;
		arrNum[8] = 92;
		arrNum[9] = 91;
	}

}

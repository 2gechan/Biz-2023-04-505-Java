package com.callor.system.exec;

public class StringC {
	
	public static void main(String[] args) {
		String str1 = "Korea";
		String str2 = new String("Korea");
		String str3 = "KOREA";
		
		boolean bYes = str1 == str2;
		
		// 문자열 값의 비교는 equals() method를 사용해야 한다.
		bYes = str1.equals(str2);
		bYes = str2.equals(str1);
		
		System.out.println(str1.equals(str2));
		System.out.println(str2.equals(str1));
		
		// equals() method는 저장된 영문자의 대소문자를
		// 서로 다른 문자열로 본다.
		bYes = str1.equals(str3);
		System.out.println(bYes);
		
		// 영문자를 비교할 때, 대/소문자 구문없이 비교하고 싶을 때
		// korea == KOREA 가 같음을 확인하고 싶을 때
		// Korea == koReA, KoReA == KOREa
		bYes = str1.equalsIgnoreCase(str3);
		System.out.println(bYes);
		
		str1 = "Republic of KOrea";
		str2 = "Republic of Korea";
		str2 = "Republic of    Korea";
		
		/*
		 * eqaulsIgnoreCase()
		 * 변수에 저장된 문자열의 배열은 일치하고
		 * 대소문자가 섞여있을때는 같은 값으로 본다
		 */
		System.out.println(str1.equalsIgnoreCase(str2));
		System.out.println(str1.equalsIgnoreCase(str3));
		System.out.println(str2.equalsIgnoreCase(str3));
	}

}

package com.callor.classes.exec;

import java.util.ArrayList;
import java.util.List;

public class ClassH {

	public static void main(String[] args) {

		// java 1.7 이후 버전에서는 생성자에는 Generic을 생략해도 된다.
		List<Integer> numList;
		numList = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			numList.add(i, (int) (Math.random() * 50) + 51);

		}
		for (int i = 0; i < numList.size(); i++) {

			for (int j = i + 1; j < numList.size(); j++) {
				
				int tmp = 0;
				if (numList.get(i) > numList.get(j)) {
					tmp = numList.get(i);
					numList.set(i, numList.get(j));
					numList.set(j, tmp);

				}
			}
		}

		// List type의 객체 변수에는 toString() method가 포함되고
		// 단순히 List의 값들을 출력해 볼 수 있다.
		System.out.print(numList.toString());
	}

}

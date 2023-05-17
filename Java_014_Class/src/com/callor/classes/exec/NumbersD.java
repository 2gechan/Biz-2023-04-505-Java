package com.callor.classes.exec;

import java.util.ArrayList;
import java.util.List;

public class NumbersD {

	public static void main(String[] args) {
		List<Integer> numList = new ArrayList<>();
		for (int i = 0; i < 45; i++) {
			numList.add(i, i + 1);

		}
		
		for(int i=0; i<numList.size(); i++) {
			System.out.print(numList.get(i) + " ");
			
		}
		int tmp = 0;
		for (int i = 0; i < 1000; i++) {
			int rndIndex1 = (int)(Math.random() * numList.size());
			int rndIndex2 = (int)(Math.random() * numList.size());
			tmp = numList.get(rndIndex1);
			numList.set(rndIndex1, numList.get(rndIndex2));
			numList.set(rndIndex2, tmp);
		}
		
		System.out.println();
		for(int i=0; i<5; i++) {
			System.out.print(numList.get(i) + " ");
			
		}
	}

}

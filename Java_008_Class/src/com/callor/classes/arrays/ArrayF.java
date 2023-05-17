package com.callor.classes.arrays;

public class ArrayF {
	public static int prime(int rndNum) {

		int index;
		for (index = 2; index < rndNum; index++) {
			if (rndNum % index == 0) {
				return 0;
			}
		}

		return rndNum;

	}

	/*
	 * 다수의 데이터를 정보처리 할 경우
	 * 데이터를 수집하고, 수집이 완료되었을 때
	 * 한꺼번에 처리를 한다.
	 * 
	 * 실시간 처리 : 데이터가 발생하는 즉시 처리 ex) 티켓 예매
	 * 배치(Batch) 처리 : 데이터를 모두 수집하고 수집이 완료되었을때 처리
	 * 						ex) 급여계산, 인구 통계
	 */
	public static void main(String[] args) {
		int[] nums = new int[10];

		for (int i = 0; i < nums.length; i++) {
			nums[i] = (int) (Math.random() * 50) + 51;
		}
		
		// 데이터를 수집 완료 후 처리

		for (int i = 0; i < nums.length; i++) {
			
			int result = prime(nums[i]); // nums[i]는 int[] 안에 있는 한개의 정수형
			
			if (result > 0) {
				System.out.println(nums[i] + " 는 소수");
			} else {
				System.err.println(nums[i] + " 는 소수 아님");
				
			}
		}
	}

}

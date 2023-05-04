package com.callor.scanner.exec;

import com.callor.scanner.service.PrimeServiceV1;

public class ScannerC {

	public static void main(String[] args) {
		PrimeServiceV1 primeService = new PrimeServiceV1();

		while (true) {
			int num = primeService.getNum();
			if (num < 0) {
				System.out.println("GAME OVER");
				return;
			}

			int result = primeService.primeYesNo(num);

			if (result > 0) {
				System.out.println(num + "는 소수");
			} else {
				System.out.println(num + "는 소수 아님");
			}
		}

	}

}

import java.util.ArrayList;
import java.util.List;

public class NumList {

	public static int prime(int rndNum) {
		for (int i = 2; i < rndNum; i++) {
			if (rndNum % i == 0) {
				return 0;
			}
		}

		return rndNum;

	}

	public static void main(String[] args) {
		List<Integer> numList = new ArrayList<>();

		for (int i = 0; i < 30; i++) {

			int rndNum = (int) (Math.random() * 50) + 51;
			numList.add(rndNum);
		}

		int count = 0;
		int sum = 0;
		for (int i = 0; i < numList.size(); i++) {

			if (prime(numList.get(i)) > 0) {
				count++;
				sum += prime(numList.get(i));
			}
		}

		System.out.println("소수 개수 : " + count);
		System.out.println("소수의 합 : " + sum);

	}

}

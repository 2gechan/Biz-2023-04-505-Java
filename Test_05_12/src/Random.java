
public class Random {

	public static void main(String[] args) {

		int index;

		for (index = 1; index <= 100; index++) {
			int rndNum = (int) (Math.random() * 100) + 1;

			if ((rndNum < 1 || rndNum > 100)) {
				System.out.println("테스트 횟수 : " + index);
				System.out.println((index) + "번 째 테스트에서 실패");
			}

		}
		// index++ 을 하고 반복문이 종료하기 때문에 index-1을 해주었음
		System.out.println("테스트 횟수 : " + (index - 1));

		if (index > 100) {
			System.out.println((index-1) + "번 테스트 수행 결과 1 ~ 100까지 범위의 랜덤수를 만들어 내고 있음");
		} else {
			System.out.println("100번 테스트를 수행하려고 하였으나 " + index + "번쨰에서 테스트에 실패함");
		}
	}

}

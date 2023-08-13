package onboarding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
	static MoneyChangeHandler moneyChangeHandler = new MoneyChangeHandler();

	public static List<Integer> solution(int money) {
		List<Integer> answer = Arrays.asList( moneyChangeHandler.converyMoney(money));
		return answer;
	}

	public static class MoneyChangeHandler {
		private final Integer[] currencyArray = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
		private Integer[] result = new Integer[9];

		public Integer[] converyMoney(int money) {
			for (int i = 0; i < currencyArray.length; i++) {
				result[i] = money / currencyArray[i];
				money %= currencyArray[i];
			}
			return result;
		}

	}
}

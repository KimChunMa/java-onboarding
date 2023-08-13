package onboarding;

public class Problem3 {
	static Game game = new Game();

	public static int solution(int number) {
		int clab = 0;
		for (int i = 1; i <= number; i++) {
			clab += game.gameStart(i);
		}
		return clab;
	}

	enum GameNumber {
		THREE('3'), SIX('6'), NINE('9');

		private final char value;

		GameNumber(char value) {
			this.value = value;
		}

		public char getValue() {
			return value;
		}
	}

	public static class Game {
		public int gameStart(int number) {
			int result = 0;
			String StringNumber = String.valueOf(number);
			for (int i = 0; i < StringNumber.length(); i++) {
				result += countNumber(StringNumber.charAt(i));
			}
			return result;
		}

		public int countNumber(char stringNumber) {
			int result = 0;
			for (GameNumber value : GameNumber.values()) {
				if (stringNumber == value.value) {
					result++;
				}
			}
			return result;
		}
	}
}

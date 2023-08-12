package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem2 {
	static Valid valid = new Valid();
	static Code code = new Code();

	public static String solution(String cryptogram) {
		if(valid.validate(cryptogram)){
			return code.decode(cryptogram);
		}
		return null;
	}

	static class Valid {
		public boolean validate(String cryptogram) {
			return isExistCryptogram(cryptogram) && isCorrectRange(cryptogram) &&
				   isLowerCase(cryptogram);
		}

		public boolean isExistCryptogram(String cryptogram) {
			return !(cryptogram == null || cryptogram.isEmpty());
		}

		public boolean isCorrectRange(String cryptogram) {
			return cryptogram.length() >= 1 && cryptogram.length() <= 1000;
		}

		public boolean isLowerCase(String cryptogram) {
			return cryptogram.equals(cryptogram.toLowerCase());
		}
	}

	static class Code{
		public String decode(String cryptogram){
			Stack<Character> stack = new Stack<>();

			int index = 0;
			while(index < cryptogram.length()){
				if(stack.isEmpty() || stack.peek() != cryptogram.charAt(index)){
					stack.push(cryptogram.charAt(index));
					index++;
				}else if(stack.peek() == cryptogram.charAt(index) ){
					stack.pop();
					index++;
				}
			}
			return stack.stream().map(Objects::toString).collect(Collectors.joining());
		}
	}
}

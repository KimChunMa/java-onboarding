package onboarding;

public class Problem4 {
	static Converter converter = new Converter();
    public static String solution(String word) {
        return converter.encode(word);
    }

	public static class Converter{
		private final int LOWER_OFFSET = 155;
		private final int UPPER_OFFSET = 219;

		public String encode(String word){
			String result = "";
			for(int i = 0 ; i < word.length() ; i++){
				result += changeChar( word.charAt(i) );
			}
			return result;
		}

		public char changeChar(char letter){
			if(Character.isUpperCase(letter)){
				return (char) (LOWER_OFFSET - letter);
			}else if(Character.isLowerCase(letter)){
				return (char) (UPPER_OFFSET - letter);
			}
			return letter;
		}
	}
}

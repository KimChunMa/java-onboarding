package onboarding;

import java.util.List;

class Problem1 {
	static Valid valid = new Valid();

	public static int solution(List<Integer> pobi, List<Integer> crong) {

		return 0;
	}

	static public class Valid {
		private static final int START_PAGE = 1;
		private static final int END_PAGE = 400;

		//사이즈 체크
		public boolean checkLength(List<Integer> pages){
			return pages.size()==2;
		}

		//널값체크
		public boolean checkNull(List<Integer> pages){
			return pages.get(0)!=null && pages.get(1)!=null;
		}

		//1~400을 넘지않는가?
		public boolean checkPage(List<Integer> pages){
			int leftPage = pages.get(0);
			int rightPage = pages.get(1);
			return (leftPage >= START_PAGE && leftPage <= END_PAGE)
				&& (rightPage >= START_PAGE && rightPage <= END_PAGE);
		}


	}


}

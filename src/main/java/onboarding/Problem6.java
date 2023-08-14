package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem6 {
	private final int EMAIL = 1;
	private final int NICK_NAME = 2;
	private final int CONSECUTIVE_NICKNAME = 2;

	ListMapper listMapper = new ListMapper();

	public static List<String> solution(List<List<String>> forms) {

		return null;
	}

	public class ListMapper {
		public HashMap<String, String> toHashMap(List<List<String>> forms) {
			HashMap<String, String> crewHashMap = new HashMap<>();
			for (List<String> list : forms) {
				String email = list.get(EMAIL);
				String nickname = list.get(NICK_NAME);
				crewHashMap.put(email, nickname);
			}
			return crewHashMap;
		}

		public List<String> subStringNickname(String nickName) {
			List<String> substringList = new ArrayList<>();
			for (int i = 0; i < nickName.length() - CONSECUTIVE_NICKNAME; i++) {
				String substringNickName = nickName.substring(i, CONSECUTIVE_NICKNAME);
				substringList.add(substringNickName);
			}
			return substringList;
		}
	}

	public class NicknameValidator {
		public HashMap<String, String> findDuplicateNicknames(HashMap<String,String> crewHashMap){
			HashMap<String, String> duplicateNicknames = new HashMap<>();

			crewHashMap.forEach((email,nickname)->{
				List<String> nicknameList = listMapper.subStringNickname(nickname);
				if(findSimilarNickname(nickname , nicknameList)){
					duplicateNicknames.put(email,nickname);
				}
			});

			return duplicateNicknames;
		}

		public boolean findSimilarNickname(String nickname , List<String> splitNicknameList){
			for (String name : splitNicknameList) {
				if(nickname.indexOf(name)>=0){
					return true;
				}
			}
			return false;
		}


	}

}




package onboarding;

import java.util.*;

public class Problem6 {
	private static final int EMAIL = 0;
	private static final int NICK_NAME = 1;
	private static final int CONSECUTIVE_NICKNAME = 2;

	private static ListMapper listMapper = new ListMapper();
	private static NicknameValidator nicknameValidator = new NicknameValidator();

	public static List<String> solution(List<List<String>> forms) {
		HashMap<String, String> crewHashMap = listMapper.toHashMap(forms);
		List<String> duplicateEmailList = nicknameValidator.findDuplicateNicknames(crewHashMap);
		Collections.sort(duplicateEmailList);
		return duplicateEmailList;
	}

	public static class ListMapper {
		public HashMap<String, String> toHashMap(List<List<String>> forms) {
			HashMap<String, String> crewHashMap = new HashMap<>();
			for (List<String> list : forms) {
				String email = list.get(EMAIL);
				String nickname = list.get(NICK_NAME);
				crewHashMap.put(email, nickname);
			}
			return crewHashMap;
		}
	}

	public static class NicknameValidator {
		static HashMap<String, List<String>> duplicateEmailMap = new HashMap<>();
		static List<String> duplicateEmail = new ArrayList<>();

		public List<String> findDuplicateNicknames(HashMap<String, String> crewHashMap) {
			crewHashMap.forEach((email, nickname) -> {
				subStringNickname(email, nickname);
			});
			findDuplicateEmail();

			return duplicateEmail;
		}

		public void subStringNickname(String email, String nickName) {
			for (int i = 0; i <= nickName.length() - CONSECUTIVE_NICKNAME; i++) {
				String substringNickName = nickName.substring(i, i+CONSECUTIVE_NICKNAME);
				findKey(substringNickName);
				putEmail(email, nickName, substringNickName);
			}
		}

		public void findKey(String substringNickName){
			if(!duplicateEmailMap.containsKey(substringNickName)){
				duplicateEmailMap.put(substringNickName, new ArrayList<>());
			}
		}

		public void putEmail(String email, String nickName, String substringNickName) {
			if(nickName.indexOf(substringNickName)>=0){
				duplicateEmailMap.get(substringNickName).add(email);
			}
		}

		public void findDuplicateEmail(){
			duplicateEmailMap.forEach((nickname,emailList)->{
				findListSize(emailList);
			});
		}

		public void findListSize(List<String> emailList){
			if(emailList.size()>=2){
				duplicateEmail.addAll(emailList);
			}
		}
	}


}




package onboarding;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Problem7 {
	private static ListMapper listMapper = new ListMapper();
	private static FriendFlow friendFlow = new FriendFlow();

	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		HashMap<String, List<String>> friendHashMap = listMapper.toHashMap(friends);
		return friendFlow.recommendFriends(friendHashMap, user, visitors);
	}

	public static class ListMapper {
		public HashMap<String, List<String>> toHashMap(List<List<String>> forms) {
			HashMap<String, List<String>> friendHashMap = new HashMap<>();

			for (List<String> friend : forms) {
				String firstFriend = friend.get(0);
				String twoFriend = friend.get(1);
				addFriendList(friendHashMap, firstFriend, twoFriend);
			}
			return friendHashMap;
		}

		public void addFriendList(HashMap<String, List<String>> friendHashMap, String firstFriend, String twoFriend) {
			if (friendHashMap.containsKey(firstFriend)) {
				friendHashMap.get(firstFriend).add(twoFriend);
			}
			if (!friendHashMap.containsKey(firstFriend)) {
				friendHashMap.put(firstFriend, new ArrayList<String>() {{
					add(twoFriend);
				}});
			}
			if (friendHashMap.containsKey(twoFriend)) {
				friendHashMap.get(twoFriend).add(firstFriend);
			}
			if (!friendHashMap.containsKey(twoFriend)) {
				friendHashMap.put(twoFriend, new ArrayList<String>() {{
					add(firstFriend);
				}});
			}
		}
	}

	public static class FriendFlow {
		static final int VISITE_SCOPE = 1;
		static final int FRIEND_SCOPE = 10;

		static HashMap<String, Integer> result = new HashMap<>();
		static List<String> userFriendList = new ArrayList<>();

		public List<String> recommendFriends(HashMap<String, List<String>> friendHashMap, String user, List<String> visitors) {
			userFriendList = friendHashMap.get(user);

			friendHashMap.forEach((friend, friendList) -> {
				checkUser(friendList, user);
			});

			for (String visitor : visitors) {
				rateFriend(visitor,VISITE_SCOPE);
			}

			return result.entrySet().stream()
				.filter(friend->friend.getValue()>0)
				.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());
		}

		private void checkUser(List<String> friendList, String user) {
			if (friendList.contains(user)) {
				List<String> copyFriendList = friendList;
				copyFriendList.remove(user);
				inquireFriendList(copyFriendList, user);
			}
		}

		private void inquireFriendList(List<String> friendList, String user) {
			for (String friendOfFriend : friendList) {
				rateFriend(friendOfFriend,FRIEND_SCOPE);
			}
		}

		private void rateFriend(String other, int point) {
			if (!userFriendList.contains(other) && result.containsKey(other)) {
				int score = result.get(other) + point;
				result.put(other, score);
			}
			if (!userFriendList.contains(other) && !result.containsKey(other)) {
				result.put(other, point);
			}
		}
	}
}

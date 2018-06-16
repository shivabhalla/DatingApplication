package com.dateme.data_access;

import com.dateme.pojo.User;

import java.util.*;

public class DataStore {
    private static Map<String, User> users;
    private static Map<String, Set<User>> likedUsers;
    private static Map<String, Set<User>> matchedUSers;

    public static void createDataStore() {
        users = new HashMap<String, User>();
        likedUsers = new HashMap<String, Set<User>>();
        matchedUSers = new HashMap<String, Set<User>>();
    }

    public static Map<String, User> getUsers() {
        return users;
    }

    public static boolean addUser(User user) throws RuntimeException {
        if(users.containsKey(user.getId())) {
            return false;
        }
        users.put(user.getId(), user);
        return true;
    }

    public static Set<User> findMatches(String userId) {
        if(matchedUSers.containsKey(userId)) {
            return matchedUSers.get(userId);
        } else {
            return new HashSet<User>();
        }
    }

    public static Set<User> likedUsers(String userId) {
        return likedUsers.get(userId);
    }

    public static boolean likeUser(String userId1, String userId2) {
        if (!users.containsKey(userId1) || !users.containsKey(userId2)) {
            return false;
        }
        if(likedUsers.get(userId1) == null) {
            likedUsers.put(userId1, new HashSet<User>());
        }
        if(likedUsers.get(userId2) == null) {
            likedUsers.put(userId2, new HashSet<User>());
        }
        likedUsers.get(userId1).add(users.get(userId2));
        if (likedUsers.get(userId2).contains(users.get(userId1))) {
            if(!matchedUSers.containsKey(userId1)) {
                matchedUSers.put(userId1, new HashSet<User>());
            }
            matchedUSers.get(userId1).add(users.get(userId2));
            matchedUSers.get(userId1).add(users.get(userId1));
        }
        return true;
    }
}

package com.dateme.strategy;

import com.dateme.pojo.User;
import com.dateme.spi.Strategy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by shiva.b on 16/06/18.
 */
public class HobbyScoreStrategy implements Strategy {
  @Override
  public double calculateScore(User user1, User user2) {
    Set<String> union = new HashSet<>(user1.getHobbies());
    union.addAll(user1.getHobbies());
    Set<String> intersection = new HashSet<>(user1.getHobbies());
    intersection.retainAll(user2.getHobbies());

    return (1.0 * intersection.size())/union.size();
  }
}

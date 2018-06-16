package com.dateme.strategy;

import com.dateme.pojo.User;
import com.dateme.spi.Strategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by shiva.b on 16/06/18.
 */
public class StrategyAggregator {

  private Map<Strategy, Double> strategyDoubleMap;

  public StrategyAggregator() {
    this.strategyDoubleMap = new HashMap<>();
  }

  public Map<Strategy, Double> getStrategyScoreMap() {
    return strategyDoubleMap;
  }

  public Map<String, Double> calculateScore(User user, List<User> users) {
    Map<String, Double> scoreMap = new HashMap<>();
    for (User user1 : users) {
      Double score = 0.0;
      for (Strategy strategy : strategyDoubleMap.keySet()) {
        score = score + strategy.calculateScore(user1, user) * strategyDoubleMap.get(strategy);
      }
      scoreMap.put(user1.getId(), score);
    }
    return scoreMap;
  }
}

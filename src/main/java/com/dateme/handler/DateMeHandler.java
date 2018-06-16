package com.dateme.handler;

import com.dateme.data_access.DataStore;
import com.dateme.filter.FilterAggregator;
import com.dateme.pojo.User;
import com.dateme.spi.Filter;
import com.dateme.spi.Strategy;
import com.dateme.strategy.StrategyAggregator;
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import javafx.scene.chart.PieChart;

import javax.jws.soap.SOAPBinding;
import java.util.*;


public class DateMeHandler {
    private FilterAggregator filterAggregator;
    private StrategyAggregator strategyAggregator;

    public DateMeHandler(FilterAggregator filterAggregator, StrategyAggregator strategyAggregator) {
        this.filterAggregator = filterAggregator;
        this.strategyAggregator = strategyAggregator;
    }

    public void addUser(User user) {
        if(DataStore.addUser(user)) {
            System.out.println("User created successfully");
        } else {
            System.out.println("Not able to create user");
        }
    }

    public void findMatches(String userId) {
        Set<User> matchedUsers = DataStore.findMatches(userId);

        for(User user: matchedUsers) {
            System.out.println("User name is: " + user.getName());
        }
    }

    public void likeUser(String userId1, String userId2) {
         if(DataStore.likeUser(userId1, userId2)) {
             System.out.println("Successfully liked user");
         } else {
             System.out.println("User not liked successfully");
         }
    }

    public void getLikedUsers(String userId) {
        Set<User> likedUsers = DataStore.likedUsers(userId);

        for(User user: likedUsers) {
            System.out.println("User name is: " + user.getName());
        }
    }

    public void showAvailableUsers(String userId) {
        Map<String, User> totalUsers = DataStore.getUsers();
        List<User> totalUsersList = new ArrayList<>();

        for(User user: totalUsers.values()) {
            totalUsersList.add(user);
        }
        filterAggregator.pass(DataStore.getUsers().get(userId), totalUsersList);
        Map<String, Double> scoreMap = strategyAggregator.calculateScore(DataStore.getUsers().get(userId), totalUsersList);

        for(String userId1: scoreMap.keySet()) {
            System.out.println("Name is: " + DataStore.getUsers().get(userId1).getName() + "  and score is: " + scoreMap.get(userId1));
        }
    }
}

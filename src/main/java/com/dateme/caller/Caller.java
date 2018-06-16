package com.dateme.caller;

import com.dateme.data_access.DataStore;
import com.dateme.enums.Gender;
import com.dateme.enums.LocationPreference;
import com.dateme.enums.Status;
import com.dateme.filter.FilterAggregator;
import com.dateme.filter.GenderFilter;
import com.dateme.filter.LocationFilter;
import com.dateme.filter.StatusFilter;
import com.dateme.handler.DateMeHandler;
import com.dateme.pojo.Location;
import com.dateme.pojo.User;
import com.dateme.strategy.HobbyScoreStrategy;
import com.dateme.strategy.StrategyAggregator;

import java.util.*;

public class Caller {

    public static void main(String[] args) {
        DataStore.createDataStore();
        FilterAggregator filterAggregator = new FilterAggregator();
        StrategyAggregator strategyAggregator = new StrategyAggregator();

        Location location1 = new Location(0, 10);

        LocationFilter locationFilter1 = new LocationFilter(LocationPreference.FAR, location1);
        GenderFilter genderFilter1 = new GenderFilter(Collections.singletonList(Gender.FEMALE));
        StatusFilter statusFilter1 = new StatusFilter(Collections.singletonList(Status.UNMARRIED));


        User user1 = new User.UserBuilder().id("guptaji@gmail.com").gender(Gender.MALE).status(Status.UNMARRIED).location(location1)
                .name("Gupta").addFilter(locationFilter1).addFilter(genderFilter1).addFilter(statusFilter1).addHobby("hobby1")
                .addHobby("hobby2").build();


        Location location2 = new Location(10, 0);

        LocationFilter locationFilter2 = new LocationFilter(LocationPreference.FAR, location1);
        GenderFilter genderFilter2 = new GenderFilter(Collections.singletonList(Gender.MALE));
        StatusFilter statusFilter2 = new StatusFilter(Collections.singletonList(Status.MARRIED));


        User user2 = new User.UserBuilder().id("sonu@gmail.com").gender(Gender.FEMALE).status(Status.UNMARRIED).location(location1)
                .name("Sonu").addFilter(locationFilter2).addFilter(genderFilter2).addFilter(statusFilter2).addHobby("hobby2")
                .addHobby("hobby2").build();

        HobbyScoreStrategy hobbyScoreStrategy = new HobbyScoreStrategy();
        strategyAggregator.getStrategyScoreMap().put(hobbyScoreStrategy, 10.0);
        DateMeHandler dateHandler = new DateMeHandler(filterAggregator, strategyAggregator);

        dateHandler.addUser(user1);
        dateHandler.addUser(user2);

        dateHandler.showAvailableUsers(user1.getId());
        dateHandler.likeUser(user1.getId(), user2.getId());

        dateHandler.showAvailableUsers(user2.getId());
        dateHandler.likeUser(user2.getId(), user1.getId());

        System.out.println("hello");

    }
}

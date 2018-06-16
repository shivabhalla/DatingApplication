package com.dateme.filter;

import com.dateme.pojo.User;
import com.dateme.spi.Filter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shiva.b on 16/06/18.
 */
public class FilterAggregator {

  public void pass(User user, List<User> userList) {
    for (Filter filter : user.getFilters()) {
      List<User> rejectList = new ArrayList<>();
      for (User user1 : userList) {
        if (!filter.pass(user1)) {
          rejectList.add(user1);
        }
      }
      userList.removeAll(rejectList);
    }
  }
}

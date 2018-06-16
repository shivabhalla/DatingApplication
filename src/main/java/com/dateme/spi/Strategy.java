package com.dateme.spi;

import com.dateme.pojo.User;

import java.util.Map;

/**
 * Created by shiva.b on 16/06/18.
 */
public interface Strategy {

  double calculateScore(User user1, User user2);
}

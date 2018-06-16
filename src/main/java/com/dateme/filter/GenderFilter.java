package com.dateme.filter;

import com.dateme.enums.Gender;
import com.dateme.pojo.User;
import com.dateme.spi.Filter;

import java.util.List;

/**
 * Created by shiva.b on 16/06/18.
 */
public class GenderFilter implements Filter {

  private List<Gender> gender;

  public GenderFilter(List<Gender> gender) {
    this.gender = gender;
  }

  public boolean pass(User user) {
    return gender.contains(user.getGender());
  }
}

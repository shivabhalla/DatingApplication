package com.dateme.filter;

import com.dateme.enums.Status;
import com.dateme.pojo.User;
import com.dateme.spi.Filter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shiva.b on 16/06/18.
 */
public class StatusFilter implements Filter {

  private List<Status> status;

  public StatusFilter(List<Status> status) {
    this.status = status;
  }

  @Override
  public boolean pass(User user) {
    return status.contains(user.getStatus());
  }
}

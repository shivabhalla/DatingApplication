package com.dateme.spi;

import com.dateme.pojo.User;

import java.util.List;

/**
 * Created by shiva.b on 16/06/18.
 */
public interface Filter {
  boolean pass(User users);
}

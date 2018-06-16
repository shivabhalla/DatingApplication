package com.dateme.filter;

import com.dateme.enums.LocationPreference;
import com.dateme.pojo.Location;
import com.dateme.pojo.User;
import com.dateme.spi.Filter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shiva.b on 16/06/18.
 */
public class LocationFilter implements Filter {

  private LocationPreference locationPreference;
  private Location location;

  public LocationFilter(LocationPreference locationPreference, Location location) {
    this.locationPreference = locationPreference;
    this.location = location;
  }

  @Override
  public boolean pass(User user) {
    return user.getLocation().calculateDistance(location) <= locationPreference.value;
  }
}

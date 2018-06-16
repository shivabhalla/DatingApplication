package com.dateme.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by shiva.b on 16/06/18.
 */
@AllArgsConstructor
@Getter
public class Location {
  private double latitude;
  private double longitude;

  public double calculateDistance(Location location) {
    return Math.sqrt(
      Math.pow(location.getLatitude() - this.getLatitude(), 2)
        + Math.pow(location.getLongitude() - this.getLatitude(), 2));
  }
}

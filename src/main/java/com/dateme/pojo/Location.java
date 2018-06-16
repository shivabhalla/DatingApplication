package com.dateme.pojo;

/**
 * Created by shiva.b on 16/06/18.
 */
public class Location {
  private double latitude;
  private double longitude;

  public Location(double latitude, double longitude) {
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public double calculateDistance(Location location) {
    return Math.sqrt(
      Math.pow(location.getLatitude() - this.getLatitude(), 2)
        + Math.pow(location.getLongitude() - this.getLatitude(), 2));
  }

  public double getLatitude() {
    return this.latitude;
  }

  public double getLongitude() {
    return this.longitude;
  }
}

package com.dateme.enums;

/**
 * Created by shiva.b on 16/06/18.
 */
public enum LocationPreference {
  NEAR_BY(10.0),
  FAR(20.0),
  VERY_FAR(50.0);

  public double value;

  LocationPreference(double v) {
    this.value = v;
  }
}

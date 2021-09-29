package com.rimac.hr.aggregationservice.model;

public enum SignalName {
  CURRENT_SPEED,
  ODOMETER,
  DRIVING_TIME,
  IS_CHARGING;

  public String getSignalName() {

    switch (this) {
      case CURRENT_SPEED:
        return "currentSpeed";
      case ODOMETER:
        return "odometer";
      case DRIVING_TIME:
        return "drivingTime";
      case IS_CHARGING:
        return "isCharging";
      default:
        return null;
    }
  }
}

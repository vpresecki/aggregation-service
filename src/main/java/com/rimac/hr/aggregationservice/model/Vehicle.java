package com.rimac.hr.aggregationservice.model;

import java.util.List;

public class Vehicle {

  private String vehicleId;
  private List<TelemetrySample> telemetrySample;

  public Vehicle(String vehicleId) {
    this.vehicleId = vehicleId;
  }

  public String getVehicleId() {
    return vehicleId;
  }

  public void setVehicleId(String vehicleId) {
    this.vehicleId = vehicleId;
  }

  public List<TelemetrySample> getTelemetrySample() {
    return telemetrySample;
  }

  public void setTelemetrySample(List<TelemetrySample> telemetrySample) {
    this.telemetrySample = telemetrySample;
  }
}

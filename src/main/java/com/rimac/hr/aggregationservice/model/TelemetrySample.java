package com.rimac.hr.aggregationservice.model;

import java.time.Instant;
import java.util.HashMap;

public class TelemetrySample {

  private String vehicleId;
  private Long recordedAt;
  private HashMap<String, Double> signalValues;

  public TelemetrySample(String vehicleId, HashMap<String, Double> signalValues) {
    this.vehicleId = vehicleId;
    this.recordedAt = Instant.now().toEpochMilli();
    this.signalValues = signalValues;
  }

  public String getVehicleId() {
    return vehicleId;
  }

  public void setVehicleId(String vehicleId) {
    this.vehicleId = vehicleId;
  }

  public Long getRecordedAt() {
    return recordedAt;
  }

  public HashMap<String, Double> getSignalValues() {
    return signalValues;
  }

  public void setSignalValues(HashMap<String, Double> signalValues) {
    this.signalValues = signalValues;
  }
}

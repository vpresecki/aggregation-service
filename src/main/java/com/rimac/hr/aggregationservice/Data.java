package com.rimac.hr.aggregationservice;

import com.rimac.hr.aggregationservice.model.SignalName;
import com.rimac.hr.aggregationservice.model.TelemetrySample;
import com.rimac.hr.aggregationservice.model.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;

public class Data {

  public Vehicle getVehicleData() {
    Vehicle vehicle = new Vehicle("vehicle000");
    vehicle.setTelemetrySample(new ArrayList<>());

    // Telemetry 1
    HashMap<String, Double> signalValues1 = new HashMap<>();
    signalValues1.put(SignalName.DRIVING_TIME.getSignalName(), 3600000.00);
    signalValues1.put(SignalName.ODOMETER.getSignalName(), 60.0);
    signalValues1.put(SignalName.CURRENT_SPEED.getSignalName(), 90.00);
    signalValues1.put(SignalName.IS_CHARGING.getSignalName(), 0.00);
    TelemetrySample telemetrySample1 = new TelemetrySample(vehicle.getVehicleId(), signalValues1);
    vehicle.getTelemetrySample().add(telemetrySample1);

    //    Telemetry 2
    HashMap<String, Double> signalValues2 = new HashMap<>();
    signalValues2.put(SignalName.DRIVING_TIME.getSignalName(), 7200000.00);
    signalValues2.put(SignalName.ODOMETER.getSignalName(), 100.00);
    signalValues2.put(SignalName.CURRENT_SPEED.getSignalName(), 201.74);
    signalValues2.put(SignalName.IS_CHARGING.getSignalName(), 0.00);
    TelemetrySample telemetrySample2 = new TelemetrySample(vehicle.getVehicleId(), signalValues2);
    vehicle.getTelemetrySample().add(telemetrySample2);

    //    Telemetry 3
    HashMap<String, Double> signalValues3 = new HashMap<>();
    signalValues3.put(SignalName.DRIVING_TIME.getSignalName(), 5400000.00);
    signalValues3.put(SignalName.ODOMETER.getSignalName(), 84.57);
    signalValues3.put(SignalName.CURRENT_SPEED.getSignalName(), 227.32);
    signalValues3.put(SignalName.IS_CHARGING.getSignalName(), 0.00);
    TelemetrySample telemetrySample3 = new TelemetrySample(vehicle.getVehicleId(), signalValues3);
    vehicle.getTelemetrySample().add(telemetrySample3);

    return vehicle;
  }
}

package com.rimac.hr.aggregationservice.controller;

import com.rimac.hr.aggregationservice.Data;
import com.rimac.hr.aggregationservice.model.Vehicle;
import com.rimac.hr.aggregationservice.service.AggregationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehicleStatusController {

  @Autowired AggregationService aggregationService;

  @GetMapping("/vehicle/status")
  public String getVehicleStatus() {
    Vehicle vehicle = new Data().getVehicleData();
    return aggregationService.getCurrentVehicleStatus(vehicle.getTelemetrySample());
  }
}

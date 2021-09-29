package com.rimac.hr.aggregationservice;

import com.rimac.hr.aggregationservice.model.Vehicle;
import com.rimac.hr.aggregationservice.service.AggregationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AggregationServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(AggregationServiceApplication.class, args);

    AggregationService aggregationService = new AggregationService();
    Vehicle vehicle = new Data().getVehicleData();

    System.out.println(
        "Latest timestamp: "
            + aggregationService.getLastMessageStamp(vehicle.getTelemetrySample()));
    System.out.println(
        "Average Speed: " + aggregationService.getAverageSpeed(vehicle.getTelemetrySample()));
    System.out.println(
        "Max Speed: " + aggregationService.getMaximumSpeed(vehicle.getTelemetrySample()));
    System.out.println(
        "Number of Charges: "
            + aggregationService.getNumberOfChargers(vehicle.getTelemetrySample()));
    System.out.println(
        "Vehicle Status: "
            + aggregationService.getCurrentVehicleStatus(vehicle.getTelemetrySample()));
  }
}

package com.rimac.hr.aggregationservice.service;

import com.rimac.hr.aggregationservice.model.SignalName;
import com.rimac.hr.aggregationservice.model.TelemetrySample;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class AggregationService {

  DecimalFormat df = new DecimalFormat("#.##");

  public Double getAverageSpeed(List<TelemetrySample> telemetrySamples) {

    List<Double> totalDrivingTime =
        extractSignalValues(telemetrySamples, SignalName.DRIVING_TIME.getSignalName());
    double sumTotalDrivingTime = totalDrivingTime.stream().mapToDouble(Double::doubleValue).sum();
    double sumTotalDrivingTimeSeconds = sumTotalDrivingTime / 1000;
    Double sumTotalDrivingTimeHours = sumTotalDrivingTimeSeconds / 3600;
    List<Double> totalDistance =
        extractSignalValues(telemetrySamples, SignalName.ODOMETER.getSignalName());
    Double sumTotalDistance = totalDistance.stream().mapToDouble(Double::doubleValue).sum();

    Double averageSpeed = sumTotalDistance / sumTotalDrivingTimeHours;
    return Double.valueOf(df.format(averageSpeed));
  }

  public Double getMaximumSpeed(List<TelemetrySample> telemetrySamples) {

    return telemetrySamples.stream()
        .map(
            telemetrySample ->
                telemetrySample.getSignalValues().get(SignalName.CURRENT_SPEED.getSignalName()))
        .mapToDouble(Double::doubleValue)
        .max()
        .orElse(-1);
  }

  public Long getLastMessageStamp(List<TelemetrySample> telemetrySamples) {

    return telemetrySamples.stream()
        .map(TelemetrySample::getRecordedAt)
        .mapToLong(Long::longValue)
        .max()
        .orElse(-1L);
  }

  public Long getNumberOfChargers(List<TelemetrySample> telemetrySamples) {

    return telemetrySamples.stream()
        .filter(
            telemetrySample ->
                telemetrySample.getSignalValues().get(SignalName.IS_CHARGING.getSignalName())
                    == 1.00)
        .count();
  }

  public String getCurrentVehicleStatus(List<TelemetrySample> telemetrySamples) {
    Long lastMessageStamp = getLastMessageStamp(telemetrySamples);
    TelemetrySample telemetrySample =
        telemetrySamples.stream()
            .filter(sample -> sample.getRecordedAt().equals(lastMessageStamp))
            .findFirst()
            .orElse(null);

    if (Objects.nonNull(telemetrySample)) {
      if (telemetrySample.getSignalValues().get(SignalName.IS_CHARGING.getSignalName()) == 1.00) {
        return "Charging";
      } else if (telemetrySample.getSignalValues().get(SignalName.CURRENT_SPEED.getSignalName())
          > 0.00) {
        return "Driving";
      } else if (telemetrySample.getSignalValues().get(SignalName.DRIVING_TIME.getSignalName())
          == 0.00) {
        return "Parked";
      }
    }
    return "Unknown";
  }

  private List<Double> extractSignalValues(
      List<TelemetrySample> telemetrySamples, String signalName) {

    List<Double> signalValues = new ArrayList<>();
    for (TelemetrySample telemetrySample : telemetrySamples) {
      signalValues.add(telemetrySample.getSignalValues().get(signalName));
    }

    return signalValues;
  }
}

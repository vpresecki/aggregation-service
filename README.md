# Aggregation Service

## How to run

* Must have maven and JDK installed

### Option A

* In terminal, from root directory type:
  ``./mvnw spring-boot:run``

### Option B

* Open project in IntelliJ and run AggregationServiceApplication

### Description

* There is only one Vehicle loaded from Data.java class, it has three TelemetrySamples with signal
  values
* Soon as application runs it should print vehicle average speed, maximum speed, last message
  timestamp, number of charges and current vehicle status
* AggregationService.java handles all logic for handling telemetry samples
* VehicleStatusController.java exposes vehicle state, it can be fetched via any browser after the
  application is run on: localhost:8080/vehicle/status

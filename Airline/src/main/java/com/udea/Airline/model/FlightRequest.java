package com.udea.Airline.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class FlightRequest {


    @NotNull(message = "Se requiere información del pasajero")
    @Valid
    private Passenger passenger;

    @NotNull(message = "Debe asignarse la duración del vuelo")
    @Min(value = 0, message = "La duración del vuelo debe ser un valor positivo")
    private Double flightDurationHours;

    @NotNull(message = "Debe indicarse el retraso del vuelo")
    @Min(value = 0, message = "El retraso del vuelo no puede ser negativo")
    private Integer flightDelayMinutes;

    @NotNull(message = "Debe indicarse disponibilidad de asiento de emergencia")
    private Boolean emergencyExitAvailable;

    public FlightRequest() {}

    public FlightRequest(Passenger passenger,
                         Double flightDurationHours,
                         Integer flightDelayMinutes,
                         Boolean emergencyExitAvailable) {
        this.passenger = passenger;
        this.flightDurationHours = flightDurationHours;
        this.flightDelayMinutes = flightDelayMinutes;
        this.emergencyExitAvailable = emergencyExitAvailable;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Double getFlightDurationHours() {
        return flightDurationHours;
    }

    public void setFlightDurationHours(Double flightDurationHours) {
        this.flightDurationHours = flightDurationHours;
    }

    public Integer getFlightDelayMinutes() {
        return flightDelayMinutes;
    }

    public void setFlightDelayMinutes(Integer flightDelayMinutes) {
        this.flightDelayMinutes = flightDelayMinutes;
    }

    public Boolean getEmergencyExitAvailable() {
        return emergencyExitAvailable;
    }

    public void setEmergencyExitAvailable(Boolean emergencyExitAvailable) {
        this.emergencyExitAvailable = emergencyExitAvailable;
    }
}

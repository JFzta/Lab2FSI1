package com.udea.Airline.model;

public class FlightResponse {

    private boolean upgradeToBusiness;
    private boolean priorityCheckIn;
    private double discount;           // % de descuento aplicable (0.0 - 1.0)
    private boolean upgradeEligible;
    private boolean emergencySeatAssigned;
    private double compensationAmount;
    private int loyaltyPoints;
    private boolean luggageAllowed;
    private boolean vipAccess;
    private boolean familySeatAssigned;
    private String message;

    public FlightResponse() {
        // inicializar valores por defecto
        this.upgradeToBusiness = false;
        this.priorityCheckIn = false;
        this.discount = 0.0;
        this.upgradeEligible = true;
        this.emergencySeatAssigned = false;
        this.compensationAmount = 0.0;
        this.loyaltyPoints = 0;
        this.luggageAllowed = true;
        this.vipAccess = false;
        this.familySeatAssigned = false;
        this.message = null;
    }

    // Getters y setters

    public boolean isUpgradeToBusiness() {
        return upgradeToBusiness;
    }

    public void setUpgradeToBusiness(boolean upgradeToBusiness) {
        this.upgradeToBusiness = upgradeToBusiness;
    }

    public boolean isPriorityCheckIn() {
        return priorityCheckIn;
    }

    public void setPriorityCheckIn(boolean priorityCheckIn) {
        this.priorityCheckIn = priorityCheckIn;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public boolean isUpgradeEligible() {
        return upgradeEligible;
    }

    public void setUpgradeEligible(boolean upgradeEligible) {
        this.upgradeEligible = upgradeEligible;
    }

    public boolean isEmergencySeatAssigned() {
        return emergencySeatAssigned;
    }

    public void setEmergencySeatAssigned(boolean emergencySeatAssigned) {
        this.emergencySeatAssigned = emergencySeatAssigned;
    }

    public double getCompensationAmount() {
        return compensationAmount;
    }

    public void setCompensationAmount(double compensationAmount) {
        this.compensationAmount = compensationAmount;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public boolean isLuggageAllowed() {
        return luggageAllowed;
    }

    public void setLuggageAllowed(boolean luggageAllowed) {
        this.luggageAllowed = luggageAllowed;
    }

    public boolean isVipAccess() {
        return vipAccess;
    }

    public void setVipAccess(boolean vipAccess) {
        this.vipAccess = vipAccess;
    }

    public boolean isFamilySeatAssigned() {
        return familySeatAssigned;
    }

    public void setFamilySeatAssigned(boolean familySeatAssigned) {
        this.familySeatAssigned = familySeatAssigned;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

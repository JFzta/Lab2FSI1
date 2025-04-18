package com.udea.Airline.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Passenger {

        @NotBlank(message = "El nombre no puede estar vacío")
        @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
        private String name;

        @NotNull(message = "La edad es obligatoria")
        @Min(value = 0, message = "La edad no puede ser negativa")
        private Integer age;

        @NotNull(message = "La membresía es obligatoria")
        private MembershipStatus membershipStatus;

        @NotNull(message = "Debe indicar si viaja con niños")
        private Boolean travelingWithChildren;

        @NotBlank(message = "La preferencia de asiento es obligatoria")
        private SeatPreference seatPreference;

        @NotNull(message = "El peso del equipaje es obligatorio")
        @Min(value = 0, message = "El peso del equipaje no puede ser negativo")
        private Double luggageWeightKg;

        public Passenger() {}

        public Passenger(String name,
                         Integer age,
                         MembershipStatus membershipStatus,
                         Boolean travelingWithChildren,
                         SeatPreference seatPreference,
                         Double luggageWeightKg) {
                this.name = name;
                this.age = age;
                this.membershipStatus = membershipStatus;
                this.travelingWithChildren = travelingWithChildren;
                this.seatPreference = seatPreference;
                this.luggageWeightKg = luggageWeightKg;
        }

        // Getters y setters

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public Integer getAge() {
                return age;
        }

        public void setAge(Integer age) {
                this.age = age;
        }

        public MembershipStatus getMembershipStatus() {
                return membershipStatus;
        }

        public void setMembershipStatus(MembershipStatus membershipStatus) {
                this.membershipStatus = membershipStatus;
        }

        public Boolean getTravelingWithChildren() {
                return travelingWithChildren;
        }

        public void setTravelingWithChildren(Boolean travelingWithChildren) {
                this.travelingWithChildren = travelingWithChildren;
        }

        public SeatPreference getSeatPreference() {
                return seatPreference;
        }

        public void setSeatPreference(SeatPreference seatPreference) {
                this.seatPreference = seatPreference;
        }

        public Double getLuggageWeightKg() {
                return luggageWeightKg;
        }

        public void setLuggageWeightKg(Double luggageWeightKg) {
                this.luggageWeightKg = luggageWeightKg;
        }
}
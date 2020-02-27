package com.pramati.bookingservice.model;

import javax.persistence.*;

@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int doctorId;
    private String name;
    private int booked;

    public Doctor() {
    }

    public Doctor(int doctorId, String name, int booked) {
        this.doctorId = doctorId;
        this.name = name;
        this.booked = booked;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBooked() {
        return booked;
    }

    public void setBooked(int booked) {
        this.booked = booked;
    }
}

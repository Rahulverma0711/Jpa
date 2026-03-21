package com.youngcoder.healthcare.enitity;

import jakarta.persistence.*;

import javax.print.Doc;


@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="patient_name")
    private String name;
    @Column(name="patient_age")
    private int age;
    @OneToOne
    @JoinColumn(name="patient_medicalrecord")
    private MedicalRecord medicalRecord;

    @ManyToOne
    @JoinColumn(name="doctor_id")
    private Doctor doctor;

    public Patient() {
    }

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    public Patient(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}

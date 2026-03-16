package com.youngcoder.healthcare.enitity;

import jakarta.persistence.*;

@Entity
public class MedicalRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String diagnosis;
    @OneToOne(mappedBy = "medicalRecord")
    private Patient patient;

    public MedicalRecord() {
    }


    public MedicalRecord( String diagnosis) {
        this.diagnosis = diagnosis;
    }


    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}

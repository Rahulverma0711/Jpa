package com.youngcoder.healthcare.enitity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="medicine_prescription",
            joinColumns = @JoinColumn(name="medicine_id"),
            inverseJoinColumns = @JoinColumn(name = "prescription_id")
    )
    private List<Medicine> medicineList;


    public Prescription() {
    }

    public Prescription(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Medicine> getMedicineList() {
        return medicineList;
    }

    public void setMedicineList(List<Medicine> medicineList) {
        this.medicineList = medicineList;
    }
}

package com.youngcoder.healthcare.demo;



import com.youngcoder.healthcare.enitity.Doctor;
import com.youngcoder.healthcare.enitity.Medicine;
import com.youngcoder.healthcare.enitity.Patient;
import com.youngcoder.healthcare.enitity.Prescription;
import com.youngcoder.healthcare.repository.DoctorRepository;
import com.youngcoder.healthcare.repository.MedicineRepository;
import com.youngcoder.healthcare.repository.PatientRepository;
import com.youngcoder.healthcare.repository.PrescriptionRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.print.Doc;
import java.util.List;

@Component
public class ManyToManyDemo implements CommandLineRunner {

    private MedicineRepository medicineRepository;
    private PrescriptionRepository prescriptionRepository;

    public ManyToManyDemo(MedicineRepository medicineRepository, PrescriptionRepository prescriptionRepository) {
        this.medicineRepository = medicineRepository;
        this.prescriptionRepository = prescriptionRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        Medicine paracetamol= new Medicine("paracetamol");
        Medicine minogain = new Medicine("minogain");

        Prescription p1 = new Prescription("flu ");
        Prescription p2 = new Prescription("fever");

        // Set relationships
        p1.setMedicineList(List.of(paracetamol, minogain));
        p2.setMedicineList(List.of(paracetamol));

        // Save prescriptions (owning side)
        prescriptionRepository.save(p1);
        prescriptionRepository.save(p2);


    }
}


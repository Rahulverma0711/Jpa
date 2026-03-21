package com.youngcoder.healthcare.demo;


import com.youngcoder.healthcare.enitity.MedicalRecord;
import com.youngcoder.healthcare.enitity.Patient;
import com.youngcoder.healthcare.repository.MedicalRecordRepository;
import com.youngcoder.healthcare.repository.PatientRepository;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


public class RelationshipDemo implements CommandLineRunner {
    private MedicalRecordRepository medicalRecordRepository;
    private PatientRepository patientRepository;

    public RelationshipDemo(MedicalRecordRepository medicalRecordRepository, PatientRepository patientRepository) {
        this.medicalRecordRepository = medicalRecordRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {


       MedicalRecord m1 = new MedicalRecord("fever");
       medicalRecordRepository.save(m1);
       Patient p1 = new Patient("Ravi",35);
       p1.setMedicalRecord(m1);
       patientRepository.save(p1);
       m1.setPatient(p1);


       System.out.println(p1.getMedicalRecord().getDiagnosis());

       MedicalRecord fetchedMedicalRecord = medicalRecordRepository.findById(1L).orElseThrow();

       System.out.println(fetchedMedicalRecord.getPatient().getName());



    }
}

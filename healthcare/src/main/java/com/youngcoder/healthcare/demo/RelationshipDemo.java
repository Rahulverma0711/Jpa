package com.youngcoder.healthcare.demo;


import com.youngcoder.healthcare.enitity.MedicalRecord;
import com.youngcoder.healthcare.enitity.Patient;
import com.youngcoder.healthcare.repository.MedicalRecordRepository;
import com.youngcoder.healthcare.repository.PatientRepository;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
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

        Patient p1 = new Patient("Ravi",35);

        MedicalRecord medicalRecord = new MedicalRecord("Fever");

        p1.setMedicalRecord(medicalRecord);
        medicalRecord.setPatient(p1);
        patientRepository.save(p1);

        medicalRecordRepository.save(medicalRecord);

        System.out.println(p1.getMedicalRecord().getDiagnosis());

        System.out.println(medicalRecord.getPatient().getName());


    }
}

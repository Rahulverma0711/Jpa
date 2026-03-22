package com.youngcoder.healthcare.demo;

import com.youngcoder.healthcare.enitity.Doctor;
import com.youngcoder.healthcare.enitity.Patient;
import com.youngcoder.healthcare.repository.DoctorRepository;
import com.youngcoder.healthcare.repository.PatientRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;


public class CascadingDemo implements CommandLineRunner {

    private DoctorRepository doctorRepository;
    private PatientRepository patientRepository;

    public CascadingDemo(DoctorRepository doctorRepository, PatientRepository patientRepository) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        Doctor d1 = new Doctor("Dr Alex");

        Patient p1 = new Patient("Ravi", 34);
        Patient p2 = new Patient("Raju", 22);

        // maintain both sides
        p1.setDoctor(d1);
        p2.setDoctor(d1);

        List<Patient> patients = new ArrayList<>();
        patients.add(p1);
        patients.add(p2);

        d1.setPatientList(patients);

        // Save doctor (since cascade is from Doctor side)
        doctorRepository.save(d1);

        System.out.println("======CascadeType_Merge======");

        Doctor managedDoctor = doctorRepository.findById(1L).orElseThrow();
        managedDoctor.setName("name updated");

        Patient managedPatient = patientRepository.findById(1L).orElseThrow();
        managedPatient.setAge(91);

        // IMPORTANT: modify existing list instead of replacing it
        managedDoctor.getPatientList().clear();
        managedDoctor.getPatientList().add(managedPatient);

        doctorRepository.save(managedDoctor);
    }
}

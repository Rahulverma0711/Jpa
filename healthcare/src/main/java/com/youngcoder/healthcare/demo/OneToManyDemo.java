package com.youngcoder.healthcare.demo;

import com.youngcoder.healthcare.enitity.Doctor;
import com.youngcoder.healthcare.enitity.Patient;
import com.youngcoder.healthcare.repository.DoctorRepository;
import com.youngcoder.healthcare.repository.PatientRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.print.Doc;
import java.util.List;


public class OneToManyDemo implements CommandLineRunner {

    private DoctorRepository doctorRepository;
    private PatientRepository patientRepository;

    public OneToManyDemo(DoctorRepository doctorRepository, PatientRepository patientRepository) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        Patient p1 = new Patient("Ravi",34);
        Doctor d1 = new Doctor("Dr. Alex");
        Doctor d2 = new Doctor("Dr. Pritam");
        Patient p2 = new Patient("Jane",43);
        p2.setDoctor(d1);

        doctorRepository.save(d1);
        doctorRepository.save(d2);
        p1.setDoctor(d1);
        patientRepository.save(p1);
        patientRepository.save(p2);

        d1.setPatientList(List.of(p1,p2));

        System.out.println(d1.getPatientList().get(0).getName());

    }
}

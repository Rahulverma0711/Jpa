package com.youngcoder.healthcare;

import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;


public class PatientRepositoryCrud implements CommandLineRunner {

    private PatientRepository patientRepository;

    public PatientRepositoryCrud (PatientRepository patientRepository) {
        this.patientRepository=patientRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        //create
        Patient p1=new Patient("Ravi",45);
        Patient p2=new Patient("Simran",35);

        patientRepository.save(p1);
        patientRepository.save(p2);

        //read
       Patient patientIdOne =  patientRepository.findById(1L).get();
       System.out.println(patientIdOne);

       //read all data

//        List<Patient> patientList = patientRepository.findAll();
//        patientList.forEach(patient -> System.out.println(patient.getName()));

        //Update
//
        Patient patientIdTwo = patientRepository.findById(2L).get();
        patientIdTwo.setName("Simran updated");

        //delete

//        patientRepository.deleteById(1L);
    }
}

package com.youngcoder.healthcare.repository;

import com.youngcoder.healthcare.enitity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {

}

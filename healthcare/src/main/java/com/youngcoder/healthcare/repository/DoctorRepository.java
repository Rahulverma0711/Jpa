package com.youngcoder.healthcare.repository;

import com.youngcoder.healthcare.enitity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
}

package com.youngcoder.healthcare.repository;

import com.youngcoder.healthcare.enitity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;

public interface PrescriptionRepository extends JpaRepository<Prescription,Long> {
}

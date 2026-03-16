package com.youngcoder.healthcare.repository;

import com.youngcoder.healthcare.enitity.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord,Long> {
}

package com.youngcoder.healthcare.repository;

import com.youngcoder.healthcare.enitity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine,Long> {
}

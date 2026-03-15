package com.youngcoder.healthcare;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class JpaEntityManagerDemo implements CommandLineRunner {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    @Transactional
    public void run(String... args) throws Exception {

        Patient p1=new Patient("Simaran",35);
        entityManager.persist(p1);

        //check if the entity is in managed state i.e object inside persistence context
        // A managed entity is a java object which is tracked by JPA inside persistence context
        System.out.println("Is Managed? "+entityManager.contains(p1));

        //JPA find() method

        Patient findPatient = entityManager.find(Patient.class,1L);

        System.out.println(findPatient);

        // getReference - it will not hit run the db when the method is called. When we used that referenced object
        //then the query runs
//
        Patient referencedPatient = entityManager.getReference(Patient.class,1L);
        System.out.println(referencedPatient.getName());


        //merge()
        p1.setName("Simran updated");
        Patient mergedPatient= entityManager.merge(p1);


        // remove

        Patient p3= new Patient("Kali",43);
        entityManager.persist(p3);

        entityManager.remove(p3);







    }
}

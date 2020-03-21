package org.codejudge.sb.repositories;

import org.codejudge.sb.entities.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Integer> {

    Optional<Lead> findById(int id);
    Optional<Lead> findByMobile(String mobile);
    Optional<Lead> findByEmail(String email);

}

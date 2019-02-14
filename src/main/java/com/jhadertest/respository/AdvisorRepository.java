package com.jhadertest.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jhadertest.domain.Advisor;

@Repository
public interface AdvisorRepository extends CrudRepository<Advisor, Long> {

}

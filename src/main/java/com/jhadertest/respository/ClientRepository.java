package com.jhadertest.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jhadertest.domain.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

}

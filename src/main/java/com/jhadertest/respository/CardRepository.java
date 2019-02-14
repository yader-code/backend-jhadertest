package com.jhadertest.respository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jhadertest.domain.Card;

@Repository
public interface CardRepository extends CrudRepository<Card, Long>{
	@Query("SELECT c FROM Card c WHERE c.client.id = :client_id")
	List<Card> clientCards(@Param("client_id")Long client_id);
}

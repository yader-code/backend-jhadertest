package com.jhadertest.respository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jhadertest.domain.Payment;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long> {
	
	@Query("SELECT p FROM Payment p WHERE p.card.id = :card_id")
	List<Payment> payments(@Param("card_id") Long card_id);
}

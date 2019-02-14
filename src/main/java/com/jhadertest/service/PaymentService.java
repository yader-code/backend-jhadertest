package com.jhadertest.service;

import java.util.List;
import java.util.Optional;

import com.jhadertest.domain.Payment;
import com.jhadertest.service.ex.ServiceAppException;

public interface PaymentService {
	Payment save(Payment payment)throws ServiceAppException;
	Optional<Payment> findById(Long id)throws ServiceAppException;
	List<Payment> payments(Long id)throws ServiceAppException;
}

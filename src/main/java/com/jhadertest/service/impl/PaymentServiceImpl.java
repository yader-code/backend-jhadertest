package com.jhadertest.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientResponseException;

import com.jhadertest.domain.Payment;
import com.jhadertest.respository.PaymentRepository;
import com.jhadertest.service.PaymentService;
import com.jhadertest.service.ex.ServiceAppException;

@Service
public class PaymentServiceImpl implements PaymentService{

	Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);
	
	@Autowired
	private PaymentRepository paymentService;
	
	@Override
	public Payment save(Payment payment) throws ServiceAppException {
		try {
			return paymentService.save(payment);
		}catch (RestClientResponseException e) {
			logger.error("!Error trying to save payment: "+e);
			throw new ServiceAppException("!Error trying to save payment: "+e.getMessage());
		}
	}

	@Override
	public Optional<Payment> findById(Long id) throws ServiceAppException {
		try {
			return paymentService.findById(id);
		}catch (RestClientResponseException e) {
			logger.error("!Error trying to load payment: "+e);
			throw new ServiceAppException("!Error trying to load payment: "+e.getMessage());
		}
	}

	@Override
	public List<Payment> payments(Long id) throws ServiceAppException {
		try {
			return paymentService.payments(id);
		}catch (RestClientResponseException e) {
			logger.error("!Error trying to load payment: "+e);
			throw new ServiceAppException("!Error trying to load payment: "+e.getMessage());
		}
	}

}

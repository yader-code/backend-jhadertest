package com.jhadertest.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhadertest.domain.Payment;
import com.jhadertest.service.PaymentService;
import com.jhadertest.service.ex.ServiceAppException;

@RestController
@RequestMapping("api_rest/payments")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping
	public Payment save(@RequestBody Payment payment) throws ServiceAppException {
		return paymentService.save(payment);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Payment>> getById(@PathVariable Long id) throws ServiceAppException{
		Optional<Payment> payment = paymentService.findById(id);
		if(!payment.isPresent()) {
			return new ResponseEntity<Optional<Payment>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Optional<Payment>>(payment,HttpStatus.OK);
	}
	
	@GetMapping("/card/{id}")
	public List<Payment> paymentByCard(@PathVariable Long id) throws ServiceAppException{
		return paymentService.payments(id);
	}
}

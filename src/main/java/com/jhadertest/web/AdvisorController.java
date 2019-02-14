package com.jhadertest.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jhadertest.domain.Advisor;
import com.jhadertest.service.AdvisorService;
import com.jhadertest.service.ex.ServiceAppException;

@RestController
@RequestMapping("api_rest/advisors")
@CrossOrigin(value = "http://localhost:4200/")
public class AdvisorController {
	
	@Autowired
	private AdvisorService advisorService;
	
	@PostMapping
	public Advisor save(@RequestBody Advisor request) throws ServiceAppException{
		return advisorService.save(request);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) throws ServiceAppException {
		Optional<Advisor> advisor = advisorService.findById(id);
		if(!advisor.isPresent()) {
			return new ResponseEntity<Optional<Advisor>>(advisor,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Optional<Advisor>>(advisorService.findById(id),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) throws ServiceAppException{
		advisorService.deleteById(id);
	}
	
	@PutMapping
	public Advisor update(@RequestBody Advisor advisor) throws ServiceAppException{
		return advisorService.update(advisor);
	}
	
	@GetMapping
	public List<Advisor> findAll()throws ServiceAppException{
		return advisorService.findAll();
	}
}

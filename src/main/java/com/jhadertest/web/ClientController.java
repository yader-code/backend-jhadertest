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

import com.jhadertest.domain.Client;
import com.jhadertest.service.ClientService;
import com.jhadertest.service.ex.ServiceAppException;

@RestController
@RequestMapping("api_rest/clients")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@PostMapping
	public Client save(@RequestBody Client client) throws ServiceAppException {
		return clientService.save(client);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getByID(@PathVariable Long id) throws ServiceAppException{
		Optional<Client> client = clientService.findById(id);
		if(!client.isPresent()) {
			return new ResponseEntity<Optional<Client>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Optional<Client>>(client,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) throws ServiceAppException {
		clientService.delete(id);
	}
	
	@PutMapping
	public Client update(@RequestBody Client client) throws ServiceAppException {
		return clientService.save(client);
	}
	
	@GetMapping
	public List<Client> listClient() throws ServiceAppException{
		return clientService.findAll();
	}

}

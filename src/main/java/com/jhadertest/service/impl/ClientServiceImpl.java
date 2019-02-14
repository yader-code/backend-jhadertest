package com.jhadertest.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhadertest.domain.Client;
import com.jhadertest.respository.ClientRepository;
import com.jhadertest.service.ClientService;
import com.jhadertest.service.ex.ServiceAppException;

@Service
public class ClientServiceImpl implements ClientService{

	Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);
	
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public Client save(Client client) throws ServiceAppException {
		try {
			return clientRepository.save(client);
		}catch (Exception e) {
			logger.error("!Error trying to save client: "+e);
			throw new ServiceAppException("!Error trying to save client: "+e.getMessage());
		}
	}

	@Override
	public Optional<Client> findById(Long id) throws ServiceAppException {
		try {
			return clientRepository.findById(id);
		}catch (Exception e) {
			logger.error("!Error trying to find client: "+e);
			throw new ServiceAppException("!Error trying to find client: "+e.getMessage());
		}
	}

	@Override
	public Client update(Client client) throws ServiceAppException {
		try {
			return clientRepository.save(client);
		}catch (Exception e) {
			logger.error("!Error trying to update client: "+e);
			throw new ServiceAppException("!Error trying to update client: "+e.getMessage());
		}
	}

	@Override
	public void delete(Long id) throws ServiceAppException {
		try {
			clientRepository.deleteById(id);
		}catch (Exception e) {
			logger.error("!Error trying to delete client: "+e);
			throw new ServiceAppException("!Error trying to delete client: "+e.getMessage());
		}
	}

	@Override
	public List<Client> findAll() throws ServiceAppException {
		try {
			return (List<Client>) clientRepository.findAll();
		}catch (Exception e) {
			logger.error("!Error trying to list clients: "+e);
			throw new ServiceAppException("!Error trying to list clients: "+e.getMessage());
		}
	}
}

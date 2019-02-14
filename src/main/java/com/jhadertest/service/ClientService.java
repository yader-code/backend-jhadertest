package com.jhadertest.service;

import java.util.List;
import java.util.Optional;

import com.jhadertest.domain.Client;
import com.jhadertest.service.ex.ServiceAppException;

public interface ClientService {
	Client save(Client client)throws ServiceAppException;
	Optional<Client> findById(Long id)throws ServiceAppException;
	Client update(Client client)throws ServiceAppException;
	void delete(Long id)throws ServiceAppException;
	List<Client> findAll()throws ServiceAppException;
}

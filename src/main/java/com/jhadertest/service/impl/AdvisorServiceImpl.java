package com.jhadertest.service.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientResponseException;

import com.jhadertest.domain.Advisor;
import com.jhadertest.respository.AdvisorRepository;
import com.jhadertest.service.AdvisorService;
import com.jhadertest.service.ex.ServiceAppException;

@Service
public class AdvisorServiceImpl implements AdvisorService{
	
	Logger logger = LoggerFactory.getLogger(AdvisorServiceImpl.class);
	
	@Autowired
	private AdvisorRepository advisorRepository;

	@Override
	public Advisor save(Advisor advisor) throws ServiceAppException {
		try {
			return advisorRepository.save(advisor);
		}catch (RestClientResponseException e) {
			logger.error("!Error trying to save advisor: "+e);
			throw new ServiceAppException("!Error trying to save advisor: "+e.getMessage());
		}
	}

	@Override
	public Optional<Advisor> findById(Long id) throws ServiceAppException {
		try {
			return advisorRepository.findById(id);
		}catch (RestClientResponseException e) {
			logger.error("!Error trying to find advisor by id: "+e);
			throw new ServiceAppException("!Error trying to get advisor: "+e.getMessage());
		}
	}

	@Override
	public void deleteById(Long id) throws ServiceAppException {
		try {
			advisorRepository.deleteById(id);
		}catch (RestClientResponseException e) {
			logger.error("!Error trying to delete advisor by id: "+e);
			throw new ServiceAppException("!Error trying to delete advisor: "+e.getMessage());
		}
		
	}

	@Override
	public List<Advisor> findAll() {
		try {
			return (List<Advisor>) advisorRepository.findAll();
		}catch (Exception e) {
			logger.error("!Error trying to find all advisors: "+e);
			throw new ServiceException("!Error trying to find all advisors: "+e);
		}
	}

	@Override
	public Advisor update(Advisor advisor) throws ServiceAppException {
		try {
		 return advisorRepository.save(advisor);
		}catch (Exception e) {
			logger.error("!Error trying to update advisor: "+e);
			throw new ServiceException("!Error trying to update advisor: "+e);
		}
	}

}

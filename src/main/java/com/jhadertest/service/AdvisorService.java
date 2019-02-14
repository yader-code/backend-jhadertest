package com.jhadertest.service;

import java.util.List;
import java.util.Optional;

import com.jhadertest.domain.Advisor;
import com.jhadertest.service.ex.ServiceAppException;

public interface AdvisorService {
	Advisor save(Advisor advisor)throws ServiceAppException;
	Advisor update(Advisor advisor)throws ServiceAppException;
	Optional<Advisor> findById(Long id)throws ServiceAppException;
	void deleteById(Long id)throws ServiceAppException;
	List<Advisor> findAll()throws ServiceAppException;
}

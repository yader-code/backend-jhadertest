package com.jhadertest.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientResponseException;

import com.jhadertest.domain.Card;
import com.jhadertest.respository.CardRepository;
import com.jhadertest.service.CardService;
import com.jhadertest.service.ex.ServiceAppException;

@Service
public class CardServiceImpl implements CardService {
	
	Logger logger = LoggerFactory.getLogger(CardServiceImpl.class);
	
	@Autowired
	private CardRepository cardRespository;

	@Override
	public Card save(Card card) throws ServiceAppException {
		try {
			return cardRespository.save(card);
		}catch (RestClientResponseException e) {
			logger.error("!Error trying to save card: "+e);
			throw new ServiceAppException("!Error trying to save card: "+e.getMessage());
		}
	}

	@Override
	public Optional<Card> findById(Long id) throws ServiceAppException {
		try {
			return cardRespository.findById(id);
		}catch (RestClientResponseException e) {
			logger.error("!Error trying to load card: "+e);
			throw new ServiceAppException("!Error trying to load card: "+e.getMessage());
		}
	}

	@Override
	public List<Card> clientCards(Long id) throws ServiceAppException {
		try {
			return cardRespository.clientCards(id);
		}catch (RestClientResponseException e) {
			logger.error("!Error trying to load client cards: "+e);
			throw new ServiceAppException("!Error trying to load client cards: "+e.getMessage());
		}
	}

}

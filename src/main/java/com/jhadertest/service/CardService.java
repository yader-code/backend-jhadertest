package com.jhadertest.service;

import java.util.List;
import java.util.Optional;

import com.jhadertest.domain.Card;
import com.jhadertest.service.ex.ServiceAppException;

public interface CardService {
	Card save(Card card)throws ServiceAppException;
	Optional<Card> findById(Long id)throws ServiceAppException;
	List<Card> clientCards(Long id)throws ServiceAppException;
}

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

import com.jhadertest.domain.Card;
import com.jhadertest.service.CardService;
import com.jhadertest.service.ex.ServiceAppException;

@RestController
@RequestMapping("api_rest/cards")
public class CardController {
	
	@Autowired
	private CardService cardService;
	
	@PostMapping
	public Card save(@RequestBody Card card) throws ServiceAppException {
		return cardService.save(card);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Card>> getById(@PathVariable Long id) throws ServiceAppException {
		Optional<Card> card = cardService.findById(id);
		if(!card.isPresent()) {
			return new ResponseEntity<Optional<Card>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Optional<Card>>(card,HttpStatus.OK);
	}
	
	@GetMapping("/client/{id}")
	public List<Card> clientCards(@PathVariable Long id) throws ServiceAppException{
		return cardService.clientCards(id);
	}

}

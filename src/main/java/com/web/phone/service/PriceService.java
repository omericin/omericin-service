package com.web.phone.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.web.phone.dto.PriceRequestDTO;
import com.web.phone.model.Price;
import com.web.phone.repository.PriceRepository;

@Service
public class PriceService {
	
	@Autowired
	private PriceRepository priceRepository;

	public Price getPriceByBrandId(PriceRequestDTO price) {
		return priceRepository.findPriceById(price.getBrandId(), price.getSize(), price.getStatus());
	}
	
	public ResponseEntity<Price> create(Price price) {
		return ResponseEntity.ok(priceRepository.save(price));
	}
	
	public ResponseEntity<Price> updatePrice(PriceRequestDTO newPrice) {
		Optional<Price> price = priceRepository.findById(newPrice.getId());
		if(price != null) {
			price.get().setBrandId(newPrice.getBrandId());
			price.get().setPrice(newPrice.getPrice());
			price.get().setSize(newPrice.getSize());
			price.get().setStatus(newPrice.getStatus());
			return ResponseEntity.ok(priceRepository.save(price.get()));
		}
		return null;
	}
	
	public void deletePrice(String id) {
		priceRepository.deleteById(id);
	}

}

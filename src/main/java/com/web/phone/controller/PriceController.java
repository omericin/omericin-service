package com.web.phone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.phone.dto.PriceRequestDTO;
import com.web.phone.model.Price;
import com.web.phone.service.PriceService;

@RestController
@RequestMapping("/api/price")
public class PriceController {

	@Autowired
	private PriceService priceService;
	
	  @CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
    @PostMapping("/create")
    public ResponseEntity<Price> create(@RequestBody Price price) {
		return priceService.create(price);
    }
	
    @CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
    @PostMapping("/get")
    public Price getPriceById(@RequestBody PriceRequestDTO price) {
		return priceService.getPriceByBrandId(price);
    }
	
    @CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
    @DeleteMapping("/")
    public int delete(@RequestBody PriceRequestDTO price) {
		try {
			priceService.deletePrice(price.getId());
			return 1;
		} catch (Exception e) {
			return 0;
		}
    }
	
    @CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
    @PutMapping("/")
    public ResponseEntity<Price> update(@RequestBody PriceRequestDTO price) {
		return priceService.updatePrice(price);
    }
	
}

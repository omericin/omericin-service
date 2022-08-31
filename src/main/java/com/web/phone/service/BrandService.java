package com.web.phone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.web.phone.dto.BrandRequestDTO;
import com.web.phone.model.Brand;
import com.web.phone.repository.BrandRepository;

@Service
public class BrandService {
	
	@Autowired
	private BrandRepository brandRepository;
	
	public ResponseEntity<Brand> createBrand(Brand brand) {
		return ResponseEntity.ok(brandRepository.save(brand));
	}
	
	public ResponseEntity<List<Brand>> brandList() {
		return ResponseEntity.ok(brandRepository.findAll());
	}
	
	public List<Brand> getBrandByDeviceId(String deviceId) {
		return brandRepository.findBrandByDeviceId(deviceId);
	}
	
	public Brand updateBrand(BrandRequestDTO newBrand) {
		Optional<Brand> brand = brandRepository.findById(newBrand.getId());
		if(brand != null) {
			brand.get().setColorList(newBrand.getColorList());
			brand.get().setDeviceId(newBrand.getDeviceId());
			brand.get().setStorageList(newBrand.getStorageList());
			brand.get().setImage(newBrand.getImage());
			brand.get().setName(newBrand.getName());
			return brandRepository.save(brand.get());
		}
		return null;
	}
	
	public void deleteBrand(String id) {
		brandRepository.deleteById(id);
	}

}

package com.web.phone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.phone.dto.BrandRequestDTO;
import com.web.phone.model.Brand;
import com.web.phone.service.BrandService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/brand")
public class BrandController {
	
    @Autowired
    private BrandService brandService;
    
    @GetMapping("/")
    public ResponseEntity<List<Brand>> list() {
        return brandService.brandList();
    }
    
    @PostMapping("/")
    public ResponseEntity<Brand> create(@RequestBody Brand brand) {
        return brandService.createBrand(brand);
    }
	
    @PostMapping("/get")
    public List<Brand> getBrand(@RequestBody BrandRequestDTO brand) {
        return brandService.getBrandByDeviceId(brand.getDeviceId());
    }

    @DeleteMapping("/")
	public int delete(@RequestBody BrandRequestDTO brand) {
		try {
			brandService.deleteBrand(brand.getId());
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
	
    @PutMapping("/")
	public Brand update(@RequestBody BrandRequestDTO brand) {
		return brandService.updateBrand(brand);
	}
	
	

}

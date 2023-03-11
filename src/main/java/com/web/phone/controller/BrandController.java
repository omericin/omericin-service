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
import org.springframework.web.bind.annotation.PathVariable;

import com.web.phone.dto.BrandRequestDTO;
import com.web.phone.model.Brand;
import com.web.phone.service.BrandService;

@RestController
@RequestMapping("/api/brand")
public class BrandController {
	
    @Autowired
    private BrandService brandService;
    
    @CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
    @GetMapping("/")
    public ResponseEntity<List<Brand>> list() {
        return brandService.brandList();
    }

    @CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
    @PostMapping("/")
    public ResponseEntity<Brand> create(@RequestBody Brand brand) {
        return brandService.createBrand(brand);
    }
	
    @CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
    @PostMapping("/get")
    public List<Brand> getBrand(@RequestBody BrandRequestDTO brand) {
        return brandService.getBrandByDeviceId(brand.getDeviceId());
    }

    @CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
	@DeleteMapping("/{id}")
	public int deleteB(@PathVariable String id) {
		try {
			brandService.deleteBrand(id);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
	
    @CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
    @PutMapping("/")
	public Brand update(@RequestBody BrandRequestDTO brand) {
		return brandService.updateBrand(brand);
	}
	
	

}

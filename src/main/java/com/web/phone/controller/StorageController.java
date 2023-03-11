package com.web.phone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.phone.dto.StorageRequestDTO;
import com.web.phone.model.Storage;
import com.web.phone.service.StorageService;

@RestController
@RequestMapping("/api/storage")
public class StorageController {
	
	@Autowired
	private StorageService storageService;
	
	@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
    @PostMapping("/")
    public ResponseEntity<Storage> create(@RequestBody Storage storage) {
		return storageService.createStorage(storage);
    }

	@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
    @GetMapping("/")
    public ResponseEntity<List<Storage>> list() {
        return storageService.getAll();
    }
	
	@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
	@DeleteMapping("/{id}")
	public int delete(@PathVariable String id) {
		try {
			storageService.deleteStorage(id);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
	
	@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
	@PutMapping("/")
	public Storage update(@RequestBody StorageRequestDTO storage) {
		return storageService.updateStorage(storage);
	}
	

}

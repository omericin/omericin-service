package com.web.phone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.web.phone.dto.StorageRequestDTO;
import com.web.phone.model.Storage;
import com.web.phone.repository.StorageRepository;

@Service
public class StorageService {
	
	@Autowired
	private StorageRepository storageRepository;
	
	public ResponseEntity<Storage> createStorage(Storage color) {
		return ResponseEntity.ok(storageRepository.save(color));
	}
	
	public ResponseEntity<List<Storage>> getAll() {
		return ResponseEntity.ok(storageRepository.findAll());
	}
	
	public void deleteStorage(String id){
		storageRepository.deleteById(id);
	}
	
	public Storage updateStorage(StorageRequestDTO newStorage) {
		Optional<Storage> storage = storageRepository.findById(newStorage.getId());
		if(storage != null) {
			storage.get().setSize(newStorage.getSize());
			return storageRepository.save(storage.get());
		}
		return null;
	}

}

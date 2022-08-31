package com.web.phone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.web.phone.dto.DeviceRequestDTO;
import com.web.phone.model.Device;
import com.web.phone.repository.DeviceRepository;

@Service
public class DeviceService {
	
	@Autowired
    private DeviceRepository deviceRepository;
	
	public ResponseEntity<Device> createDevice(Device device) {
		return ResponseEntity.ok(deviceRepository.save(device));
	}
	
	public ResponseEntity<List<Device>> getAll() {
		return ResponseEntity.ok(deviceRepository.findAll());
	}
	
	public void deleteDevice(String id){
		deviceRepository.deleteById(id);
	}
	
	public Device updateDevice(DeviceRequestDTO newDevice) {
		Optional<Device> device = deviceRepository.findById(newDevice.getId());
		if(device != null) {
			device.get().setName(newDevice.getName());
			device.get().setImage(newDevice.getImage());
			return deviceRepository.save(device.get());
		}
		return null;
	}

}

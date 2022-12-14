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

import com.web.phone.dto.DeviceRequestDTO;
import com.web.phone.model.Device;
import com.web.phone.service.DeviceService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/device")
public class DeviceController {
	
    @Autowired
    private DeviceService deviceService;
    
	@CrossOrigin(origins = "http://82.180.155.55:3000", allowedHeaders = "*")
    @PostMapping("/")
    public ResponseEntity<Device> create(@RequestBody Device device) {
		return deviceService.createDevice(device);
    }

	@CrossOrigin(origins = "http://82.180.155.55:3000", allowedHeaders = "*")
    @GetMapping("/")
    public ResponseEntity<List<Device>> list() {
        return deviceService.getAll();
    }
	
	@CrossOrigin(origins = "http://82.180.155.55:3000", allowedHeaders = "*")
	@DeleteMapping("/")
	public int delete(@RequestBody DeviceRequestDTO id) {
		try {
			deviceService.deleteDevice(id.getId());
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
	
	@CrossOrigin(origins = "http://82.180.155.55:3000", allowedHeaders = "*")
	@PutMapping("/")
	public Device update(@RequestBody DeviceRequestDTO device) {
		return deviceService.updateDevice(device);
	}

}

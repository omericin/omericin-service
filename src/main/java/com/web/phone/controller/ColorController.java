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

import com.web.phone.dto.ColorRequestDTO;
import com.web.phone.model.Color;
import com.web.phone.service.ColorService;

@RestController
@RequestMapping("/api/color")
public class ColorController {

	@Autowired
	private ColorService colorService;
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/")
    public ResponseEntity<Color> create(@RequestBody Color color) {
		return colorService.createColor(color);
    }

	@CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/")
    public ResponseEntity<List<Color>> list() {
        return colorService.getAll();
    }
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@DeleteMapping("/{id}")
	public int delete(@PathVariable String id) {
		try {
			colorService.deleteColor(id);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PutMapping("/")
	public Color update(@RequestBody ColorRequestDTO color) {
		return colorService.updateColor(color);
	}
	
}

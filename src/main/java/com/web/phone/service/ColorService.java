package com.web.phone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.web.phone.dto.ColorRequestDTO;
import com.web.phone.model.Color;
import com.web.phone.repository.ColorRepository;

@Service
public class ColorService {
	
	@Autowired
	private ColorRepository colorRepository;
	
	public ResponseEntity<Color> createColor(Color color) {
		return ResponseEntity.ok(colorRepository.save(color));
	}
	
	public ResponseEntity<List<Color>> getAll() {
		return ResponseEntity.ok(colorRepository.findAll());
	}
	
	public void deleteColor(String id){
		colorRepository.deleteById(id);
	}
	
	public Color updateColor(ColorRequestDTO newColor) {
		Optional<Color> color = colorRepository.findById(newColor.getId());
		if(color != null) {
			color.get().setName(newColor.getName());
			color.get().setHexCode(newColor.getHexCode());
			return colorRepository.save(color.get());
		}
		return null;
	}

}

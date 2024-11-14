package com.devsuperior.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.entities.dto.GameDTO;
import com.devsuperior.dslist.entities.dto.GameFullDTO;
import com.devsuperior.dslist.serveces.GameServece;

@RestController
@RequestMapping(value = "/games")
public class GameController {
	
	@Autowired
	private GameServece gameServece;
	
	
	@GetMapping(value = "/{id}")
	public GameFullDTO findById(@PathVariable Long id){
		GameFullDTO result = gameServece.findById(id);
		return result;
		}
	
	@GetMapping
	public List<GameDTO> findAll(){
		List<GameDTO> result = gameServece.findAll();
		return result;

		}

}

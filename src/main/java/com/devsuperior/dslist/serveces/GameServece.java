package com.devsuperior.dslist.serveces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.entities.dto.GameDTO;
import com.devsuperior.dslist.repositiries.GameRepository;

@Service
public class GameServece {
	
	@Autowired
	private  GameRepository gameRepository;
	
	public List<GameDTO> findAll(){
		List<Game> result = gameRepository.findAll();
		List<GameDTO> dto = result.stream().map(x -> new GameDTO(x)).toList(); 
		return dto;
		
	}

}

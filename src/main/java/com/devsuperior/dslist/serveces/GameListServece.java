package com.devsuperior.dslist.serveces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.entities.dto.GameListDTO;
import com.devsuperior.dslist.repositiries.GameListRepository;

@Service
public class GameListServece {
	
	@Autowired
	private  GameListRepository gameListRepository;
	
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		List<GameList> result = gameListRepository.findAll();
		List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList(); 
		return dto;
		
	}

}

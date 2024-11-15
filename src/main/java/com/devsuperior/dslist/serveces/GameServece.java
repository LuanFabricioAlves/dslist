package com.devsuperior.dslist.serveces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.entities.dto.GameDTO;
import com.devsuperior.dslist.entities.dto.GameFullDTO;
import com.devsuperior.dslist.projection.GameMinProjection;
import com.devsuperior.dslist.repositiries.GameRepository;

@Service
public class GameServece {
	
	@Autowired
	private  GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public GameFullDTO findById(Long id){
		Game result = gameRepository.findById(id).get();
		GameFullDTO dto = new GameFullDTO(result);
		return dto;
	}
	
	@Transactional(readOnly = true)
	public List<GameDTO> findAll(){
		List<Game> result = gameRepository.findAll();
		List<GameDTO> dto = result.stream().map(x -> new GameDTO(x)).toList(); 
		return dto;
	}
	
	@Transactional(readOnly = true)
	public List<GameDTO> findByList(Long listId){
		List<GameMinProjection> result = gameRepository.searchByList(listId);
		return result.stream().map(x -> new GameDTO(x)).toList(); }

}

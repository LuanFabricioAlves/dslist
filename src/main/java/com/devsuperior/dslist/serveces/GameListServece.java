package com.devsuperior.dslist.serveces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.entities.dto.GameListDTO;
import com.devsuperior.dslist.projection.GameMinProjection;
import com.devsuperior.dslist.repositiries.GameListRepository;
import com.devsuperior.dslist.repositiries.GameRepository;

@Service
public class GameListServece {
	
	@Autowired
	private  GameListRepository gameListRepository;
	
	@Autowired
	private  GameRepository gameRepository;
	
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		List<GameList> result = gameListRepository.findAll();
		List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList(); 
		return dto;
		
	}
	
	@Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex ) {
		
		List<GameMinProjection> result = gameRepository.searchByList(listId);
		
		GameMinProjection obj = list.remove(sourceIndex);
		list.add(destinationIndex, obj);
		
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
		
		for(int i = min; i <= max; i++){
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
	}

}

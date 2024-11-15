package com.devsuperior.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.entities.dto.GameDTO;
import com.devsuperior.dslist.entities.dto.GameListDTO;
import com.devsuperior.dslist.entities.dto.ReplacementDTO;
import com.devsuperior.dslist.serveces.GameListServece;
import com.devsuperior.dslist.serveces.GameServece;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
	
	@Autowired
	private GameListServece gameListServece;
	
	@Autowired
	private GameServece gameServece;
	
	
	@GetMapping
	public List<GameListDTO> findAll(){
		List<GameListDTO> result = gameListServece.findAll();
		return result;
		}
	
	@GetMapping("/{listId}/games")
	public List<GameDTO> findByList(@PathVariable Long listId){
		List<GameDTO> result = gameServece.findByList(listId);
		return result;

		}
	
	@PostMapping("/{listId}/replacement")
	public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body){
		gameListServece.move(listId, body.getSouceIndex(), body.getDestinationIndex());
		}

}

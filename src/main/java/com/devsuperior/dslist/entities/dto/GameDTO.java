package com.devsuperior.dslist.entities.dto;

import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projection.GameMinProjection;

public class GameDTO {
	
	private long ID;
	private String title;
	private Integer year;
	private String imgUrl;
	private String shortDescription;
	
	public GameDTO(){
		
	}

	public GameDTO(Game entity) {
		ID = entity.getId();
		title = entity.getTitle();
		year = entity.getYear();
		imgUrl = entity.getImgUrl();
		shortDescription = entity.getShortDescription();
	}
	
	public GameDTO(GameMinProjection projection) {
		ID = projection.getId();
		title = projection.getTitle();
		year = projection.getYear();
		imgUrl = projection.getImgUrl();
		shortDescription = projection.getShortDescription();
	}

	public long getID() {
		return ID;
	}

	public String getTitle() {
		return title;
	}

	public Integer getYear() {
		return year;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public String getShortDescription() {
		return shortDescription;
	}
	
	

}

package com.devsuperior.dslist.entities.dto;

import com.devsuperior.dslist.entities.Game;

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

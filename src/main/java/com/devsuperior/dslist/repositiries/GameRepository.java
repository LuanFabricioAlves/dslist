package com.devsuperior.dslist.repositiries;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dslist.entities.Game;

public interface GameRepository extends JpaRepository <Game, Long>{

}

package com.devsuperior.dslist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;
	
	// Retorna uma lista preenchendo o GameMinDTO de acordo com as 
	// infos adquiridas do Game, copiando apenas os campos solicitados.
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll() {
		List<Game> result = gameRepository.findAll();
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}
	
	@Transactional(readOnly = true) // Assegura que não havera acoes escritas
	public GameDTO findById(Long id) {
		Game result = gameRepository.findById(id).get();
		return new GameDTO(result);
	}
	
	@Transactional(readOnly = true) // Assegura que não havera acoes escritas
	public List<GameMinDTO> findByGameList(Long listId) {
		List<GameMinProjection> result = gameRepository.searchByList(listId);
		return result.stream().map(x -> new GameMinDTO(x)).toList(); 
		// Transforma a lista de GameMinProjection p/ GameMinDTO

	}
	
	@Transactional
	public GameDTO updateShortDescription(Long id, GameDTO gameDTO) {
		Optional<Game> gameOpt = gameRepository.findById(id); //Possibilidade de encontrar ou nao
		
		if(gameOpt.isPresent()) {
			Game game = gameOpt.get();
			game.setShortDescription(gameDTO.getShortDescription());
			game = gameRepository.save(game);
			return new GameDTO(game);
		} else {
			throw new IllegalArgumentException("Jogo com Id informado não encontrado");
		}
	}
}

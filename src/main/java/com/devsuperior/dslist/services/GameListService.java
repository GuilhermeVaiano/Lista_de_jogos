package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameListRepository;
import com.devsuperior.dslist.repositories.GameRepository;

@Service
public class GameListService {

	@Autowired
	private GameListRepository gameListRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll() {
		List<GameList> result = gameListRepository.findAll();
		return result.stream().map(x -> new GameListDTO(x)).toList();
		// Cria um novo objeto para cada linha da tabela e armazena na lista.
	}
	
	// Move o jogo que esta na lista na posicao x para a posicao y.
	public void move(Long listId, int sourceIndex, int destIndex) {
		List<GameMinProjection> list = gameRepository.searchByList(listId);
		GameMinProjection obj = list.remove(sourceIndex);
		list.add(destIndex, obj);
		
		int min = (sourceIndex < destIndex ? sourceIndex : destIndex);
		int max = (sourceIndex < destIndex ? destIndex : sourceIndex);
		
		//Atualiza a ordem da tabela no BD de acordo com a mudanca na lista
		for(int i=min; i<= max; i++) {
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}

	}
	
}

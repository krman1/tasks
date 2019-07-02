package com.crud.tasks.controller;

import com.crud.tasks.domain.CreatedTrelloCardDto;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.service.TrelloService;
import com.crud.tasks.trello.facade.TrelloFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/trello")
@CrossOrigin(origins = "*")
public class TrelloController {
	
//	@Autowired
//	private TrelloService trelloService;
	
	@Autowired
	private TrelloFacade trelloFacade;
	
	@RequestMapping(method = RequestMethod.GET, value = "/boards")
	public List<TrelloBoardDto> getTrelloBoards() {
		return trelloFacade.fetchTrelloBoards();
		
		//List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();
		
//		trelloBoards.stream()
//				.filter(s -> s.getId()!= null)
//				.filter(s -> s.getName() != null)
//				.filter(s -> s.getName().contains("Kodilla"))
//				.forEach(trelloBoardDto -> System.out.println(trelloBoardDto.getId() + " " + trelloBoardDto.getName()));
		
//		trelloBoards.forEach(trelloBoardDto -> {
//
//			System.out.println(trelloBoardDto.getName() + " - " + trelloBoardDto.getId());
//
//			System.out.println("This board contains lists: ");
//
//			trelloBoardDto.getLists().forEach(trelloList ->
//					System.out.println(trelloList.getName() + " - " + trelloList.getId() + " - " + trelloList.isClosed()));
//		});
			
		}
		
		@RequestMapping(method = RequestMethod.POST,value = "/cards")
	public CreatedTrelloCardDto createdTrelloCard(@RequestBody TrelloCardDto trelloCardDto){
			return trelloFacade.createCard(trelloCardDto);
		}
	}


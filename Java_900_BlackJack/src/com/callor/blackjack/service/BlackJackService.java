package com.callor.blackjack.service;

import java.util.ArrayList;
import java.util.List;

import com.callor.blackjack.service.impl.DeckServiceImplV1;
import com.callor.blackjack.service.impl.PlayerServiceImplV1;

public class BlackJackService {
	
	protected final List<PlayerService> playerList;
	protected final DeckService deckService;
	
	public BlackJackService() {
		playerList = new ArrayList<>();
		deckService = new DeckServiceImplV1();
		
	}
	
	public void gameStart() {
		playerList.add(new PlayerServiceImplV1()); // 생성자의 매개변수가 없으면 딜러
		playerList.add(new PlayerServiceImplV1("타짜"));
		playerList.add(new PlayerServiceImplV1("영수"));
		
		for(int i =0; i< 2; i++) {
			for(PlayerService player : playerList) {
				player.hit(deckService.getDeck());
			}
		}
		
		if(playerList.get(0).getScore() < 17) {
			playerList.get(0).hit(deckService.getDeck());
		}
		
		for(PlayerService player : playerList) {
			player.showDeck();
		}
	}

}

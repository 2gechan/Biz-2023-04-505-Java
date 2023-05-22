package com.callor.blackjack.service;

import java.util.ArrayList;
import java.util.List;

import com.callor.blackjack.service.impl.DeckServiceImplV1;
import com.callor.blackjack.service.impl.PlayerServiceImplV1;
import com.callor.blackjack.utils.Line;

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

		for (int i = 0; i < 2; i++) {
			for (PlayerService player : playerList) {
				player.hit(deckService.getDeck());
			}
		}

		if (playerList.get(0).getScore() < 17) {
			playerList.get(0).hit(deckService.getDeck());
		}

		for (PlayerService player : playerList) {
			player.showDeck();
		}

		// player가 다수일 경우 승부를 어떻게 계산할 것인가
		int maxScore = 0;
		String playerName = "";
		for (PlayerService player : playerList) {
			if (player.getScore() > maxScore) {
				maxScore = player.getScore();
				playerName = player.getPlayName();
			}
		}
		System.out.printf("승자 : %s, 점수 : %d\n", playerName, maxScore);

		for (int i = 1; i < playerList.size(); i++) {
			System.out.println(Line.sLine(100));
			String dealer = playerList.get(0).getPlayName();
			int dealerScore = playerList.get(0).getScore();
			String player = playerList.get(i).getPlayName();
			int playerScore = playerList.get(i).getScore();
			
			if(playerList.get(0).getScore() > playerList.get(i).getScore()) {
				System.out.printf("%s 점수 : %d, %s 점수 : %d, 승자 : %s\n", 
						dealer, dealerScore, player, playerScore, dealer);
			} else if(playerList.get(0).getScore() < playerList.get(i).getScore()) {
				System.out.printf("%s 점수 : %d, %s 점수 : %d, 승자 : %s\n", 
						dealer, dealerScore, player, playerScore, player);
			} else if(playerList.get(0).getScore() == playerList.get(i).getScore()) {
				System.out.printf("%s 점수 : %d, %s 점수 : %d, 무승부\n", 
						dealer, dealerScore, player, playerScore);
			}
			System.out.println(Line.sLine(100));
			
		}

	}

}

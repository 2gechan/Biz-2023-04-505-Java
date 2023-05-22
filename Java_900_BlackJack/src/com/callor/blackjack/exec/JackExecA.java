package com.callor.blackjack.exec;

import com.callor.blackjack.service.DeckService;
import com.callor.blackjack.service.impl.DeckServiceImplV1;
import com.callor.blackjack.service.impl.PlayerServiceImplV1;

public class JackExecA {
	
	public static void main(String[] args) {
		
		DeckService deckService = new DeckServiceImplV1();
		
		PlayerServiceImplV1 딜러 = new PlayerServiceImplV1();
		PlayerServiceImplV1 타짜 = new PlayerServiceImplV1("타짜");
		PlayerServiceImplV1 영수 = new PlayerServiceImplV1("영수");
		
		deckService.newCardDeck();
		
		딜러.hit(deckService.getDeck());
		타짜.hit(deckService.getDeck());
		영수.hit(deckService.getDeck());
		
		딜러.hit(deckService.getDeck());
		타짜.hit(deckService.getDeck());
		영수.hit(deckService.getDeck());
		
		딜러.showDeck();
		타짜.showDeck();
		영수.showDeck();
		
		int 딜러점수 = 딜러.getScore();
		int 타짜점수 = 타짜.getScore();
		int 영수점수 = 영수.getScore();
		
		if(딜러점수 > 타짜점수 && 타짜점수 > 영수점수) {
			System.out.println("딜러 승리");
		} else if(타짜점수 > 딜러점수 && 타짜점수 > 영수점수) {
			System.out.println("타짜 승리");
		} else if(영수점수 > 타짜점수 && 영수점수 > 딜러점수) {
			System.out.println("영수 승리");
		}
	}

}

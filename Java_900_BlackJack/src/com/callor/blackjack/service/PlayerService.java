package com.callor.blackjack.service;

import com.callor.blackjack.models.CardDto;

/*
 * hit() 카드받기
 * showDeck() : 보유한 카드 보이기
 * showScore() : 보유한 카드 점수 보이기 
 */
public interface PlayerService {


	public void hit(CardDto card);

	public void showDeck();

	public int getScore();

}

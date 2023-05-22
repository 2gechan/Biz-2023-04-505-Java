package com.callor.blackjack.service;

import java.util.List;

import com.callor.blackjack.models.CardDto;

/*
 * 게임을 위한 52매의 카드 이미지를 생성
 * hit를 했을 때 사용할 카드 제출하기
 */
public interface DeckService {


	public List<CardDto> newCardDeck();
	
	public CardDto getDeck();

	public void makeDeckList();

}

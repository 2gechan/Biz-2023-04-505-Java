package com.callor.books.service;

import java.util.List;

import com.callor.books.models.PublisherDto;

public interface PublisherService {
	
	public void loadPubliser();
	public void printPublisherList();
	public PublisherDto getPublisher(String code);
	public List<PublisherDto> getPublisherList();
	
	// 가나를 입력하면 --> 가나가 포함되어 있으면 전부 찾아내기 
	public List<PublisherDto> getPublisherListByName(String name);
	

}

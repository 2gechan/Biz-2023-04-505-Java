package com.callor.books.exec;

import com.callor.books.service.PublisherService;
import com.callor.books.service.impl.PublisherServiceImplV1;

public class PublisherExecA {
	
	public static void main(String[] args) {
		PublisherService pubService = new PublisherServiceImplV1();
		pubService.loadPubliser();
		pubService.printPublisherList();
		pubService.getPublisher("C0097");
		System.out.println();
		System.out.println(pubService.getPublisherListByName("라"));
		
	}

}

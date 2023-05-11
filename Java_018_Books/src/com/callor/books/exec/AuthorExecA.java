package com.callor.books.exec;

import com.callor.books.service.AuthorService;
import com.callor.books.service.impl.AuthorServiceImplV1;

public class AuthorExecA {
	
	public static void main(String[] args) {
		
		AuthorService auService = new AuthorServiceImplV1();
		
		auService.loadAuthor();
		auService.printAuthorList();
		
	}

}

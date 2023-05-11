package com.callor.books.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.books.models.BookDto;
import com.callor.books.service.BookService;

public class BookServiceImplV1 implements BookService {

	List<BookDto> bookList;
	
	public BookServiceImplV1() {
		bookList = new ArrayList<>();
	}
	
	@Override
	public void loadBooks() {
		String file = "src/com/callor/books/data/도서정보(2023-05-11)2.txt";
		Scanner scan = null;
		InputStream is = null;
		try {
			is = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(file + "을 확인해주세요");
		}
		
		scan = new Scanner(is);
		int rows = 0;
		while(scan.hasNext()) {
			String line = scan.nextLine();
			String[] books = line.split(",");
			rows++;
			if(books.length < 7) {
				System.out.println(rows + "번째 데이터를 확인하세요");
				break;
			}
			// ISBN, 도서명, 출판사, 저자, 발행일, 페이지, 가격

			BookDto bookDto = new BookDto(
					books[0], books[1], books[2],
					books[3], books[4], 
					Integer.valueOf(books[5]), 
					Integer.valueOf(books[6].trim())
					);
			bookList.add(bookDto);
		}
		
		scan.close();
		
	}

	// 도서 정보 전체 조회
	@Override
	public void printBookList() {
		System.out.println("=".repeat(150));
		System.out.println("ISBN\t\t도서명\t\t\t\t\t\t\t출판사\t\t저자\t\t발행일\t\t페이지\t\t가격");
		System.out.println("-".repeat(150));
		for(BookDto bDto : bookList) {
			System.out.printf("%-15s\t", bDto.getbIsbn());
			System.out.printf("%-50s\t", bDto.getbTitle());
			System.out.printf("%s15\t", bDto.getbPublisher());
			System.out.printf("%10s\t", bDto.getbAuthor());
			System.out.printf("%10s\t", bDto.getbPublishDate());
			System.out.printf("%5d\t", bDto.getbPages());
			System.out.printf("%5d\n", bDto.getbPrice());
		}
		System.out.println("=".repeat(150));
		
	}

	@Override
	public BookDto getBook(String isbn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookDto> getBookList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateBook(BookDto bookdto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBook(String isbn) {
		// TODO Auto-generated method stub
		
	}
	

}

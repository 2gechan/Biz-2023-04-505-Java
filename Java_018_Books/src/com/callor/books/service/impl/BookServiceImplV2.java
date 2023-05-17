package com.callor.books.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.books.config.DataIndex;
import com.callor.books.config.Utils;
import com.callor.books.models.BookDto;
import com.callor.books.service.BookService;

public class BookServiceImplV2 implements BookService {

	protected List<BookDto> bList;
	
	public BookServiceImplV2() {
		bList = new ArrayList<>();
	}
	
	// 도서정보.txt 파일을 읽어와서
	// List<BookDto> type 리스트 데이터로 변환하는 method
	@Override
	public void loadBooks() {
		String bookFile = "src/com/callor/books/data/도서정보(2023-05-11)2.txt";
		InputStream is = null;
		Scanner scan = null;
		
		try {
			is = new FileInputStream(bookFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		scan = new Scanner(is);
		
		while(scan.hasNext()) {
			String line = scan.nextLine();
			String[] book = line.split(",");
			
			BookDto bDto = new BookDto();
			bDto.setbIsbn(book[DataIndex.BOOK.ISBN]);
			bDto.setbTitle(book[DataIndex.BOOK.TITLE]);
			bDto.setbPublisher(book[DataIndex.BOOK.PUBLISHER]);
			bDto.setbAuthor(book[DataIndex.BOOK.AUTHOR]);
			bDto.setbPublishDate(book[DataIndex.BOOK.PDATE]);
			bDto.setbPages(Integer.valueOf(book[DataIndex.BOOK.PAGE]));
			
			// "  가나다   " : 문자열 앞이나 뒤에 공백이 포함된 상태
			// " 1000 " : Integer.valueOf(" 1000 ")
			//		=> NumberFormatException 발생
			// 이러한 상황에서 숫자 앞 뒤에 붙어 있는 공백을 제거해줘야 한다.
			// trim() method : 문자열의 앞 뒤에 붙어 있는 공백 제거 method
			// 문자열.trim()
			String strPrice = book[DataIndex.BOOK.PRICE].trim();
			
			bDto.setbPrice(Integer.valueOf(strPrice));
			
			bList.add(bDto);
		}
		scan.close();
		
	}

	@Override
	public void printBookList() {
		
		String[] printTitle = "ISBN,도서명,출판사,저자,출판일,페이지,가격".split(",");
		
		System.out.println(Utils.dLine(100));
		System.out.printf("%-13s\t", printTitle[DataIndex.BOOK.ISBN]);
		System.out.printf("%-20s\t\t", printTitle[DataIndex.BOOK.TITLE]);
		System.out.printf("%s\t", printTitle[DataIndex.BOOK.PUBLISHER]);
		System.out.printf("%s\t", printTitle[DataIndex.BOOK.AUTHOR]);
		System.out.printf("%s\t\t", printTitle[DataIndex.BOOK.PDATE]);
		System.out.printf("%s\t", printTitle[DataIndex.BOOK.PAGE]);
		System.out.printf("%s\n", printTitle[DataIndex.BOOK.PRICE]);
		
		System.out.println(Utils.sLine(100));
		
		for(BookDto bDto : bList) {
			System.out.printf("%s\t", bDto.getbIsbn());
			
			String bTitle = bDto.getbTitle();
			if(bTitle.length() > 10) {
				System.out.printf("%-20s\t", bTitle.substring(0, 10));
			} else {
				System.out.printf("%-20s\t", bDto.getbTitle());
			}
			System.out.printf("%s\t", bDto.getbPublisher());
			System.out.printf("%s\t", bDto.getbAuthor());
			System.out.printf("%s\t", bDto.getbPublishDate());
			System.out.printf("%d\t", bDto.getbPages());
			System.out.printf("%d\n", bDto.getbPrice());
		}
		
		System.out.println(Utils.dLine(100));
		
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

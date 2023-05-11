package com.callor.books.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.books.config.DataIndex;
import com.callor.books.config.Utils;
import com.callor.books.models.AuthorDto;
import com.callor.books.service.AuthorService;

public class AuthorServiceImplV1 implements AuthorService {

	protected List<AuthorDto> auList;
	
	public AuthorServiceImplV1() {
		auList = new ArrayList<>();
	}
	
	@Override
	public void loadAuthor() {
		String auFile = "src/com/callor/books/data/저자정보(2023-05-11).txt";
		InputStream is = null;
		Scanner scan = null;
		
		try {
			is = new FileInputStream(auFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		scan = new Scanner(is);
		
		while(scan.hasNext()) {
			String line = scan.nextLine();
			String[] file = line.split(",");
			
			AuthorDto auDto = new AuthorDto();
			// code, name, tel, addr
			auDto.setAuCode(file[DataIndex.AUTHOR.CODE]);
			auDto.setAuName(file[DataIndex.AUTHOR.NAME]);
			auDto.setAuTel(file[DataIndex.AUTHOR.TEL]);
			auDto.setAuAddress(file[DataIndex.AUTHOR.ADDR]);
			
			auList.add(auDto);
		}
		
		scan.close();
		
		
	}

	@Override
	public void printAuthorList() {
		
		System.out.println(Utils.dLine(100));
		System.out.println("코드\t이름\t전화번호\t주소");
		System.out.println(Utils.sLine(100));
		
		for(AuthorDto auDto : auList) {
			System.out.printf("%s\t", auDto.getAuCode());
			System.out.printf("%s\t", auDto.getAuName());
			System.out.printf("%s\t", auDto.getAuTel());
			System.out.printf("%s\n", auDto.getAuAddress());
		}
		
		System.out.println(Utils.dLine(100));
	}

	@Override
	public AuthorDto getAuthor(String code) {
		for(AuthorDto auDto : auList) {
			if(auDto.getAuCode() == code) {
				return auDto;
			}
			
		}
		return null;
	}

	@Override
	public List<AuthorDto> getAuthorList() {
		
		return this.auList;
		
	}
	
	

}

package com.callor.books.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.books.config.Utils;
import com.callor.books.models.PublisherDto;
import com.callor.books.service.PublisherService;

public class PublisherServiceImplV1 implements PublisherService {

	protected List<PublisherDto> pubList;

	public PublisherServiceImplV1() {
		pubList = new ArrayList<>();
	}

	// 출판사코드,출판사명,대표,전화번호,주소
	@Override
	public void loadPubliser() {

		String file = "src/com/callor/books/data/출판사정보(2023-05-11).txt";
		Scanner scan = null;
		InputStream is = null;

		try {
			is = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		scan = new Scanner(is);

		while (scan.hasNext()) {
			String line = scan.nextLine();
			String[] pubArr = line.split(",");

			PublisherDto pbDto = new PublisherDto();

			pbDto.setPubCode(pubArr[0]);
			pbDto.setPubName(pubArr[1]);
			pbDto.setPubCeo(pubArr[2]);
			pbDto.setPubTel(pubArr[3]);
			pbDto.setPubAddr(pubArr[4]);

			pubList.add(pbDto);
		}
		scan.close();

	}

	@Override
	public void printPublisherList() {

		System.out.println(Utils.dLine(100));
		System.out.println("코드\t출판사명\t대표\t전화번호\t주소");
		System.out.println(Utils.sLine(100));

		for (PublisherDto pbDto : pubList) {

			System.out.printf("%s\t", pbDto.getPubCode());
			System.out.printf("%-10s\t", pbDto.getPubName());
			System.out.printf("%-5s\t", pbDto.getPubCeo());
			System.out.printf("%-15s\t", pbDto.getPubTel());
			System.out.printf("%-20s\n", pbDto.getPubAddr());

		}
		System.out.println(Utils.dLine(100));

	}

	@Override
	public PublisherDto getPublisher(String code) {

		for (PublisherDto pbDto : pubList) {
			if (pbDto.getPubCode().equals(code)) {
				System.out.println(pbDto.toString());
				return pbDto;
			}
		}

		return null;
	}

	@Override
	public List<PublisherDto> getPublisherList() {

		if (pubList.isEmpty()) {
			this.loadPubliser();
		}

		return this.pubList;

	}

	@Override
	public List<PublisherDto> getPublisherListByName(String name) {

		List<PublisherDto> pubList2 = new ArrayList<>();
		for (PublisherDto pbDto : pubList) {
			
			if(pbDto.getPubName().contains(name)) {
				
				pubList2.add(pbDto);
			}

		}

		return pubList2;

	}

}

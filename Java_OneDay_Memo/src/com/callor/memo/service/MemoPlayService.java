package com.callor.memo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import com.callor.memo.config.DBConnection;
import com.callor.memo.mapper.MemoDao;
import com.callor.memo.models.MemoDto;

public class MemoPlayService {

	SqlSession sqlSession = DBConnection.getFactory().openSession(true);
	MemoDao mDao = sqlSession.getMapper(MemoDao.class);

	protected Scanner scan;

	public MemoPlayService() {
		scan = new Scanner(System.in);
	}

	public void printMemo(MemoDto mDto) {
		System.out.printf("%d\t", mDto.m_seq);
		System.out.printf("%s\t", mDto.m_writer);
		System.out.printf("%s\t", mDto.m_date);
		System.out.printf("%s\t", mDto.m_subject);
		System.out.printf("%s\n", mDto.m_content);
	}

	public void printMemoList() {
		List<MemoDto> memoList = mDao.selectMemoList();

		if (memoList.isEmpty()) {
			System.out.println("작성된 메모가 없습니다.");
		} else {
			System.out.println("=".repeat(100));
			System.out.println("번호\t작성자\t작성일자\t제목\t내용");
			System.out.println("-".repeat(100));
			for (MemoDto mDto : memoList) {
				this.printMemo(mDto);
			}
			System.out.println("=".repeat(100));

		}
	}

	// 특정 메모 찾기
	public void selectMemo() {

		this.printMemoList();

		System.out.println("찾을 메모 번호를 입력하세요");
		System.out.print("번호 (종료:QUIT) >> ");
		String strNum = scan.nextLine();
		if (strNum.equals("QUIT"))
			return;

		int seq = 0;
		while (true) {
			try {
				seq = Integer.valueOf(strNum);
				break;
			} catch (Exception e) {
				System.out.println("번호를 정수로 입력하세요");
				continue;
			}

		}
		MemoDto mDto = mDao.findById(seq);
		if (mDto == null) {
			System.out.printf("입력하신 %d 번호의 메모가 없습니다.", seq);
		} else {
			System.out.println("=".repeat(100));
			System.out.println("번호\t작성자\t작성일자\t제목\t내용");
			System.out.println("-".repeat(100));
			this.printMemo(mDto);
			System.out.println("=".repeat(100));
		}

	}

	// 메모 작성하기
	public void memoWrite() {
		MemoDto mDto = new MemoDto();
		String strWriter = "";
		while (true) {
			System.out.println("작성자 본인의 이름을 입력하세요");
			System.out.print("이름 (종료:QUIT)>> ");
			strWriter = scan.nextLine();
			if (strWriter.equals("QUIT"))
				return;

			if (strWriter.equals("")) {
				System.out.println("작성자 이름은 필수 입니다.");
				continue;
			}
			break;

		}
		System.out.println("제목을 입력하세요");
		System.out.print("제목 (종료:QUIT)>> ");
		String strSubject = scan.nextLine();
		if (strSubject.equals("QUIT"))
			return;

		System.out.println("내용을 입력하세요 (종료:QUIT)");
		System.out.println("-".repeat(100));
		String strContent = scan.nextLine();
		if (strContent.equals("QUIT"))
			return;

		LocalDate localDate = LocalDate.now();

		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("YYYY-MM-dd");
		String date = localDate.format(dateFormat);

		mDto.m_writer = strWriter;
		mDto.m_date = date;
		mDto.m_subject = strSubject;
		mDto.m_content = strContent;

		mDao.insert(mDto);
	}

	public void updateMemo() {

		this.printMemoList();

		int seq = 0;
		MemoDto mDto = new MemoDto();
		while (true) {
			System.out.println("수정할 메모의 번호를 입력하세요");
			System.out.print("번호 (종료:QUIT) >> ");
			String strNum = scan.nextLine();
			if (strNum.equals("QUIT"))
				return;

			try {
				seq = Integer.valueOf(strNum);
				mDto = mDao.findById(seq);
				if (mDto == null) {
					System.out.printf("입력하신 %d 번호의 메모는 존재하지 않습니다.\n", seq);
					return;
				}
				break;
			} catch (Exception e) {
				System.out.println("번호는 정수로 입력해주세요");
				continue;
			}
			

		}
		String strWriter = "";
			System.out.println("작성자 본인의 이름을 입력하세요");
			System.out.print("이름 (종료:QUIT)>> ");
			strWriter = scan.nextLine();
			if (strWriter.equals("QUIT")) return;
			if (strWriter.equals("")) strWriter = mDto.m_writer;

		// 작성일자는 그날에 맞춰 갱신
		LocalDate localDate = LocalDate.now();

		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("YYYY-MM-dd");
		String date = localDate.format(dateFormat);
		
		

		System.out.print("제목 >> ");
		String strSubject = scan.nextLine();
		if(strSubject.equals("")) strSubject = mDto.m_subject;

		System.out.print("내용 >> ");
		String strContent = scan.nextLine();
		if(strContent.equals("")) strContent = mDto.m_content;

		mDto.m_writer = strWriter;
		mDto.m_date = date;
		mDto.m_subject = strSubject;
		mDto.m_content = strContent;
		
		mDao.update(mDto);
	}

	public void deleteMemo() {
		int seq = 0;

		while (true) {
			this.printMemoList();

			System.out.println("삭제할 메모의 번호를 입력하세요");
			System.out.print("번호 (종료:QUIT) >> ");
			String strNum = scan.nextLine();
			if (strNum.equals("QUIT"))
				return;

			try {
				seq = Integer.valueOf(strNum);
				MemoDto mDto = mDao.findById(seq);
				if (mDto == null) {
					System.out.printf("입력하신 %d 번호의 메모는 존재하지 않습니다.\n", seq);
					return;
				}
				break;
			} catch (Exception e) {
				System.out.println("번호는 정수로 입력해주세요");
				continue;
			}

		}
		mDao.delete(seq);
	}

}

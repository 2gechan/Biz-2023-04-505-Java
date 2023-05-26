package com.callor.memo.exec;

import java.util.Scanner;

import com.callor.memo.service.MemoPlayService;

public class DaoExec {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		MemoPlayService memoPlayService = new MemoPlayService();
		
		while(true) {
			System.out.println("=".repeat(15) + "메모장" + "=".repeat(15));
			System.out.println("1 : 작성된 메모장 리스트 보기");
			System.out.println("2 : 작성된 메모 번호로 찾기");
			System.out.println("3 : 메모 작성하기");
			System.out.println("4 : 작성된 메모 수정");
			System.out.println("5 : 작성된 메모 삭제");
			System.out.println("9 : 종료");
			
			System.out.print("원하는 작업을 선택하세요 >> ");
			String work = scan.nextLine();
			
			if(work.equals("1")) memoPlayService.printMemoList();
			else if(work.equals("2")) memoPlayService.selectMemo();
			else if(work.equals("3")) memoPlayService.memoWrite();
			else if(work.equals("4")) memoPlayService.updateMemo();
			else if(work.equals("5")) memoPlayService.deleteMemo();
			else if(work.equals("9")) break;
			
		}
		
	}
}

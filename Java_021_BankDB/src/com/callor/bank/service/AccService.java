package com.callor.bank.service;

import java.util.List;

import com.callor.bank.models.AccDto;

public interface AccService {
	
	public List<AccDto> selectAll();
	
	// 보통 Id의 의미는 PK 값을 의미해서 이름을 Id로 명명함
	public AccDto findById(String acNum);
	
	// 고객ID를 전달받아 고객의 계좌 정보 리스트를 return
	/*
	 * PK 칼럼이 아닌 칼럼으로 select를 수행했을 때
	 * 결과는 0 이상이다
	 * 만약 select 된 결과가 1개 뿐이라는 확신이 있더라도
	 * 이 데이터는 List type으로 취급한다
	 */
	public List<AccDto> findByBuId(String acBuId);
	
	public int insert(AccDto acDto);
	
	public int update(AccDto acDto);
	
	public int delete(String acNum);

}

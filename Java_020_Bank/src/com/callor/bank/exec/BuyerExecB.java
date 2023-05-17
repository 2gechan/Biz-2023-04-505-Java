package com.callor.bank.exec;

import com.callor.bank.service.BuyerService;
import com.callor.bank.service.impl.BuyerServiceImplV2;

public class BuyerExecB {

	public static void main(String[] args) {
		BuyerService buService = new BuyerServiceImplV2();
		
		buService.loadBuyer();
	}

}

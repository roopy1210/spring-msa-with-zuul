package com.roopy.services.payment.helper;

import org.springframework.stereotype.Component;

import com.roopy.services.payment.util.DateUtil;

@Component
public class IDGeneratorHelper {
	
	public String getPaymentId() {
		String year = DateUtil.getCurrentYearAsString();
		String month = DateUtil.getCurrentMonthAsString();
		String day = DateUtil.getCurrentDayAsString();
		String hour = DateUtil.getCurrentHourAsString();
		String minute = DateUtil.getCurrentMinuteAsString();
		String second = DateUtil.getCurrentSecondAsString();
		
		String orderId = "P" + year + month + day + hour + minute + second;
		
		return orderId;
	}
	
}

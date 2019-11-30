package com.roopy.services.order.helper;

import org.springframework.stereotype.Component;

import com.roopy.services.order.util.DateUtil;

@Component
public class IDGeneratorHelper {
	
	public String getOrderId() {
		String year = DateUtil.getCurrentYearAsString();
		String month = DateUtil.getCurrentMonthAsString();
		String day = DateUtil.getCurrentDayAsString();
		String hour = DateUtil.getCurrentHourAsString();
		String minute = DateUtil.getCurrentMinuteAsString();
		String second = DateUtil.getCurrentSecondAsString();
		
		String orderId = "O" + year + month + day + hour + minute + second;
		
		return orderId;
	}
	
}

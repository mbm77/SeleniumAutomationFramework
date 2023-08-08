package com.mbm.reports;

public class ExtentLoggerImpl implements Loggable{

	@Override
	public void log(String status, String message) {
		if(status.equalsIgnoreCase("pass")) {
			ExtentManager.getExtentTest().pass(message);
		}
		else if(status.equalsIgnoreCase("fail")){
			ExtentManager.getExtentTest().fail(message);
		}
	}


}

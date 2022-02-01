package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestResult;
import org.testng.internal.IResultListener;

public class TestNgListener implements IResultListener {

	
	public void onTestStart(ITestResult result) {
		Log.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		Log.info("++++ Start test case : "+ result.getMethod().getMethodName()+ "++++++++++++++++++++++++++++");
		Log.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		String timeStmap = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		Log.info("Start time :" + timeStmap);
		
	}

	public void onTestSuccess(ITestResult result) {
		Log.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		Log.info("++++ End test case : "+ result.getMethod().getMethodName()+ "++++++++++++++++++++++++++++");
		Log.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		String timeStmap = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		Log.info("End time :" + timeStmap);
	}

	public void onTestFailure(ITestResult result) {
		Log.error("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		Log.error("++++ Failed test case : "+ result.getMethod().getMethodName()+ "++++++++++++++++++++++++++++");
		Log.error("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		String timeStmap = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		Log.error("Failed time :" + timeStmap);
		Log.error(result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
		Log.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		Log.info("++++ Skipped test case : "+ result.getMethod().getMethodName()+ "++++++++++++++++++++++++++++");
		Log.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

	}
}
package qa.impListeners.utils;

import org.testng.IRetryAnalyzer;

import org.testng.ITestResult;

public class MyListener implements IRetryAnalyzer{
	
	int count =0;

	@Override
	public boolean retry(ITestResult result) {

		
		int maxRetryCount = 1;
		
		
		if (!result.isSuccess()) {
			
			if(count<maxRetryCount)
			{
				count++;
				
				System.out.println(result.getMethod().getTestClass().getName()+" failed. Re-running "+count);
				return true;
			}
			
		}
		
		return false;
	}
		
		
}



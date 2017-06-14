package org.com.bankapp.test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.cap.service.AcccountService;
import org.cap.service.AccountServiceImpl;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterisedTestCase {
	
	private int input;
	private int output;
	AcccountService acccountService=new AccountServiceImpl();
	
	public ParameterisedTestCase(int input,int output){
		super();
		this.input=input;
		this.output=output;
		
	}
	
	@Parameters
	public static List<Object[]> myParameters(){
		return Arrays.asList(new Object[][]{
			{1,2},
			{2,4}
		});
	}
	
	@Test
	public void test_addNumber(){
		Assert.assertArrayEquals(expecteds, actuals);
	}

}

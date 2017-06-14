package org.com.bankapp.test;

import org.cap.dao.AccountDao;
import org.cap.dto.Address;
import org.cap.exception.InvalidInitialAmountException;
import org.cap.dto.*;
import org.cap.service.AcccountService;
import org.cap.service.AccountServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class DependencyTestCase {
	
	@Mock
	private AccountDao  accountDao;
	private AcccountService acccountService;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		acccountService=new AccountServiceImpl(accountDao);
	}
	
	@Test
	public void test_addAccount_withMock() throws InvalidInitialAmountException{
		Customer customer=new Customer();
		customer.setCustAddress(new Address());
		customer.setCustName("ABC");
		
		
		Account  account=new Account();
		account.setAmount(5000);
		account.setCustomer(customer);
		account.setAccountNo(1000);
		
		Mockito.when(accountDao.createAccount(account)).thenReturn(true);
		
		Mockito.when(accountDao.findAccountById(account.getAccountNo())).thenReturn(account);
		
	//	Account newAccount=acccountService.addAccount(customer, 5000);
		Account deposit=acccountService.deposit(1000, 700);
		Mockito.verify(accountDao).findAccountById(1000);
	}
	
	
}

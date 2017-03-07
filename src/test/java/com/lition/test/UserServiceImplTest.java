package com.lition.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lition.service.IUserService;

public class UserServiceImplTest {

	IUserService user;
	
	@Before
	public void setUp() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		user = (IUserService) ac.getBean("IUserService");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
	}

}

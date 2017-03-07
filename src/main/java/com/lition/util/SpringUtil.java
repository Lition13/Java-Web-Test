package com.lition.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtil {
	private static ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");

	public static Object getBean(String id){
		return ac.getBean(id);
	}
	
	public static Object getBean(Class<?> type){
		return ac.getBean(type);
	}
}

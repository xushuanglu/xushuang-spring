package com.lulu.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lulu.Man;

public class TestMan {


	/**
	 * spring 动态获取对象
	 */
	@Test 
	public void test2() {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext-man.xml");
		Man m1 = applicationContext.getBean("m1", Man.class);
		System.out.println(m1);
		
		Man m2 = applicationContext.getBean("m2", Man.class);
		System.out.println(m2);
		
		Man m3 = applicationContext.getBean("m3", Man.class);
		System.out.println(m3);
		
		Man m4 = applicationContext.getBean("m4", Man.class);
		System.out.println(m4);
		
		
	}
}

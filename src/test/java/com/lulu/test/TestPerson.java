package com.lulu.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lulu.Person;

public class TestPerson {

	/**
	 * ԭʼ��ȡ����
	 */
	@Test
	public void tst1() {
		Person p = new Person(1, "lulu", "��");
		System.out.println(p);
	}

	/**
	 * spring ��̬��ȡ����
	 */
	@Test 
	public void test2() {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		Person p1 = applicationContext.getBean("p1", Person.class);
		System.out.println(p1);
		
		Person p2 = applicationContext.getBean("p2", Person.class);
		System.out.println(p2);
		
		Person p3 = applicationContext.getBean("p3", Person.class);
		System.out.println(p3);
		
		Person p4 = applicationContext.getBean("p4", Person.class);
		System.out.println(p4);
		
	}
}

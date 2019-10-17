package com.lulu.factory;

import com.lulu.Person;

public class PersonNoFactory {

	public  Person createPersonFactory() {
		return new Person(3,"xiaolu002","ÄÐ");
	}
}

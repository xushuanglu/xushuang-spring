package com.lulu.factory;

import com.lulu.Person;

public class PersonFactory {

	public static Person createPersonFactory() {
		return new Person(2,"xiaolu","ÄÐ");
	}
}

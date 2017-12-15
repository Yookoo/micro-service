package com.edu.utils;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class DiffUtilsTest {

	@Test
	public void testFormatDateW3C() {
		Date d = new Date();
		String string = DiffUtils.formatDateW3C(d);
		System.out.println("date:"+string);
	}

}

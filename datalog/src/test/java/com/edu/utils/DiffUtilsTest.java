package com.edu.utils;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.edu.entity.Action;
import com.edu.entity.ChangeItem;
import com.edu.entity.Product;

public class DiffUtilsTest {

	@Test
	public void testGetChangeItems() {
		Product oldObj = new Product();
		oldObj.setId(1L);
		oldObj.setName("wahaha");
		oldObj.setCategory("饮料");
		
		Product newObj = new Product();
		newObj.setId(1L);
		newObj.setName("wahahaAD钙奶");
		newObj.setCategory("牛奶");
		
		List<ChangeItem> changeItems = DiffUtils.getChangeItems(oldObj, newObj);
		for (ChangeItem changeItem : changeItems) {
			System.out.println(changeItem.toString());
		}
		
	}

	@Test
	public void testGetInsertChangeItems() {
		Product newObj = new Product();
		newObj.setId(1L);
		newObj.setName("wahaha");
		newObj.setCategory("饮料");
		

		List<ChangeItem> changeItems = DiffUtils.getInsertChangeItems(newObj);
		for (ChangeItem changeItem : changeItems) {
			System.out.println(changeItem.toString());
		}
		
	}

	@Test
	public void testGetDeleteChangeItems() {
		fail("Not yet implemented");
	}



	@Test
	public void testGetObjectById() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetFieldShowNameMap() {
		
		Map<String, String> cnName = DiffUtils.getFieldShowNameMap(Product.class);
		System.out.println(cnName);
	}

	@Test
	public void testFormatDateW3C() {
		Date d = new Date();
		String string = DiffUtils.formatDateW3C(d);
		System.out.println("date:"+string);
	}
}

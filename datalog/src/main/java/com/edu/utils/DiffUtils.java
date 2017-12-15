package com.edu.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.edu.entity.ChangeItem;

public class DiffUtils {

	private static final Logger logger = LoggerFactory.getLogger(DiffUtils.class);

	public static List<ChangeItem> getChangeItems(Object oldObj, Object newObj) {

		Class<? extends Object> cls = oldObj.getClass();
		List<ChangeItem> changeItems = new ArrayList<>();

		Map<String, String> fieldCnNameMap = getFieldNameMap(cls);

		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(cls, Object.class);

			for (PropertyDescriptor propertyDescriptor : beanInfo.getPropertyDescriptors()) {
				String field = propertyDescriptor.getName();

				String oldProp = getValue(PropertyUtils.getProperty(oldObj, field));
				String newProp = getValue(PropertyUtils.getProperty(newObj, field));

				// update
				if (!oldProp.equals(newProp)) {

					ChangeItem changeItem = new ChangeItem();
					changeItem.setField(field);
					String cnName = fieldCnNameMap.get(field);
					changeItem.setFieldName(StringUtils.isEmpty(cnName) ? field : cnName);
					changeItem.setOldValue(oldProp);
					changeItem.setNewValue(newProp);
					changeItems.add(changeItem);
				}
			}

		} catch (Throwable e) {
			logger.error("There is error when convert change item", e);
			e.printStackTrace();
		}
		return changeItems;
	}

	/**
	 * 记录添加方法的日志方法
	 * 
	 * @param args
	 * @return
	 */
	public static List<ChangeItem> getInsertChangeItems(Object newObj) {
		Map<String, String> fieldCnNameMap = getFieldNameMap(newObj.getClass());
		Map<String, String> valueMap = getBeanSimpleFiledValueMap(newObj, true/* filter null */);
		List<ChangeItem> items = new ArrayList<>();

		for (Map.Entry<String, String> entry : valueMap.entrySet()) {
			// 获取参数中的属性和值

			ChangeItem changeItem = changeItemFactory.createChangeItem(null, entry);	

			String cnName = fieldCnNameMap.get(fieldName);

			changeItem.setFieldName(StringUtils.isEmpty(cnName) ? fieldName : cnName);
			items.add(changeItem);
		}
		return items;
	}
	static class changeItemFactory{
		
		private static ChangeItem createChangeItem(Map.Entry<String, String> oldEntry, Map.Entry<String, String> newEntry) {
			ChangeItem changeItem = new ChangeItem();
			if(oldEntry != null) {
				
			}
			if(newEntry != null) {
				
			}
			String fieldName = newEntry.getKey();
			String value = newEntry.getValue();
			String fieldName = newEntry.getKey();
			String value = newEntry.getValue();
			changeItem.setOldValue("");
			changeItem.setNewValue(value);
			changeItem.setField(fieldName);	
			return null;
		};
	}
		

	private static Map<String, String> getBeanSimpleFiledValueMap(Object newObj, boolean b) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 将不同类型转换为字符串
	 * 
	 * @param property
	 * @return
	 */
	private static String getValue(Object obj) {
		if (obj == null) {
			return "";
		}
		if (obj instanceof Date) {
			return formatDateW3C((Date) obj);
		} else {
			return obj.toString();
		}
	}

	/**
	 * 
	 * @param date
	 * @return
	 */

	static String formatDateW3C(Date date) {
		Instant instant = date.toInstant();
		LocalDateTime time = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
		return time.toString();
	}

	private static Map<String, String> getFieldNameMap(Class cls) {
		return null;
	}

	public static Object getObjectById(Object service, Object id) {
		return null;
	}
	/**
	 * 删除操作的字段变更记录
	 * @param oldObj
	 * @return
	 */
	public static List<ChangeItem> getDeleteChangeItems(Object oldObj) {
		ChangeItem changeItem = new ChangeItem();
		changeItem.setOldValue(JSON.toJSONString(oldObj));
		changeItem.setNewValue("");
		return null;
	}

}

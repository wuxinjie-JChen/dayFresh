package com.yc.util;

import java.util.Random;

public class StringUtil {

	/**
	 * �ַ����ǿ��ж�
	 * @param str
	 * @return
	 */
	public static boolean isNotNull(String str){
		if(null==str||"".equals(str)){
			return false;
		}
		return true;
	}
	
	/**
	 * ����ת�ַ���
	 * @param obj
	 * @return
	 */
	public static String objToString(Object obj){
		if(null==obj){
			return null;
		}
		return obj.toString();
		
	}
	
	/**
	 * �����������
	 * @return
	 */
	public  static String genOrderId(){
	    return System.currentTimeMillis()+""+new Random().nextInt(1000);
	}
	
}

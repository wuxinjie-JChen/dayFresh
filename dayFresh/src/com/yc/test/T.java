package com.yc.test;

public class T {

	public static void main(String[] args) {
		String classPath = T.class.getResource("").getPath();
		System.out.println(classPath);
	}
}

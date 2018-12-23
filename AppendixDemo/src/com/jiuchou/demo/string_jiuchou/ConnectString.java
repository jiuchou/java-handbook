/**
 * Copyright (c) 2018 jiuchou. All rights reserved worldwise.
 */
package com.jiuchou.demo.string_jiuchou;

public class Practice {
	// 第一种方法：使用plus
	public static String mergedString1(String string1, String string2) {
		return string1 + string2;
	}

	// 第二种：使用concat()；
	public static String mergedString2(String string1, String string2) {
		return string1.concat(string2);
	}

	// 第三种：使用append()；
	public static StringBuffer mergedString3(String string1, String string2) {
		StringBuffer sb = new StringBuffer(string1);
		return sb.append(string2);

	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("请输入字符串1:");
		String string1 = input.nextLine();
		System.out.print("请输入字符串2:");
		String string2 = input.nextLine();
		
		System.out.println("第一种方法输出的字符串是：" + mergedString1(string1, string2));
		System.out.println("第二种方法输出的字符串是:" + mergedString2(string1, string2));
		System.out.println("第三种方法输出的字符串是:" + mergedString3(string1, string2));	
}

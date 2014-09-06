package com.idu.util;

import java.sql.Date;
import java.util.Random;

public class Support {
	public static Date getCurrentDate() {
		return new Date((new java.util.Date()).getTime());
	}

	public static String randomCode(int size) {
		String str01 = "abcdefghijklmnopqrstuvwxyz";
		String str02 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String str03 = "0123456789";
		String strValid = str01 + str02 + str03;
		Random random = new Random();
		String result = "";
		for (int i = 0; i < size; i++) {
			int randnum = random.nextInt(strValid.length());
			result += strValid.charAt(randnum);
		}
		return result;
	}
}

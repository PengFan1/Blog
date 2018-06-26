package com.stx.ty3.util;

import java.util.regex.Pattern;

public class StringToUtil {
	
	public static boolean verifyEmpty(String str) {
		if(str != null) {
			str = str.trim();
		}
		if(str == null || str.equals("")) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean checkEmail(String email) {
		String regex = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
		return Pattern.matches(regex, email);
	}

	public static boolean checkTel(String tel) {
		String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
		return Pattern.matches(regex, tel);
	}

	public static void main(String[] args) {
		boolean b = checkTel("  ");
		System.out.println(b);
	}
}

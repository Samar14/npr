package com.fourstay.utilities;

import java.util.Random;

public class StringUtilities {
	
	private static String generateRandomString(int length) {
		 Random random = new Random();
		 String string = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
		 char[] text = new char[length];
		 for (int i = 0; i < text.length; i++) {
		 text[i] = string.charAt(random.nextInt(string.length() - 1));
		 }
		 return new String(text);
		 }
		 
		 public static String generateGmailUsername(String str) {
		 Random random = new Random();
		 int randomNumber = random.nextInt(9999) + 1000;
		 return str + randomNumber + "@gmail.com";
		 
		}    

}

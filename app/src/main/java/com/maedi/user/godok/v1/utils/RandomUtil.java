package com.maedi.user.godok.v1.utils;

import java.util.Random;

public class RandomUtil {
	
	public static String random() {
	    Random generator = new Random();
	    StringBuilder randomStringBuilder = new StringBuilder();
	    int randomLength = generator.nextInt(8);
	    char tempChar;
	    for (int i = 0; i < randomLength; i++){
	        tempChar = (char) (generator.nextInt(96) + 32);
	        randomStringBuilder.append(tempChar);
	    }
	    return randomStringBuilder.toString();
	}	
}

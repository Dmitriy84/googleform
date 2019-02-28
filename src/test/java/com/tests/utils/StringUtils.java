package com.tests.utils;

public class StringUtils {
	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	public static String randomAlphaNumeric(int count, String chacarters) {
		if (chacarters == null)
			chacarters = ALPHA_NUMERIC_STRING;

		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * chacarters.length());
			builder.append(chacarters.charAt(character));
		}
		return builder.toString();
	}
}
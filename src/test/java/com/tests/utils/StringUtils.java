package com.tests.utils;

public class StringUtils {
	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	/**
	 * Generate random string
	 * @param count Number of characters
	 * @param chacarters expected characters pool in result string
	 * @return random string
	 */
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
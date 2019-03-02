package com.tests.data;

import com.tests.TestNgTestBase;

public enum Sex {
	Man, Woman;
	Sex() {
		value = TestNgTestBase.messages.getString("Sex." + name());
	}

	public String toString() {
		return value;
	}

	private String value;
}
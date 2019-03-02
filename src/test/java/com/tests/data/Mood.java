package com.tests.data;

import com.tests.TestNgTestBase;

public enum Mood {
	Super, Good, Normal, Satisfactorily, Bad, Other;
	Mood() {
		value = TestNgTestBase.messages.getString("Mood." + name());
	}

	public String toString() {
		return value;
	}

	private String value;
}
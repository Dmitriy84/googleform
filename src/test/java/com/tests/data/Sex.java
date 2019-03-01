package com.tests.data;

public enum Sex {
	Man("Мужской"), Woman("Женский");
	Sex(String name) {
		value = name;
	}

	public String toString() {
		return value;
	}

	private String value;
}
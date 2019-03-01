package com.tests.data;

public enum Mood {
	Super("Супер"), Good("Хорошо"), Normal("Нормально"), Satisfactorily("Удовлетворительно"), Bad("Плохо"),
	Other("Інше:");
	Mood(String name) {
		value = name;
	}

	public String toString() {
		return value;
	}

	private String value;
}
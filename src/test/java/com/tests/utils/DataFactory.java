package com.tests.utils;

import com.tests.data.FormData;
import com.tests.data.Sex;

public class DataFactory {
	public static FormData getCommon() {
		return new FormData().setDate(12031984).setEmail("test@gmail.com").setName("Vasya Pupkin").setSex(Sex.Man);
	}

	public static FormData getEmpty() {
		return new FormData();
	}
}
package com.tests.data;

public class FormData {
	private String email = "";
	private int date;
	private String name = "";
	private Sex sex;
	private boolean isMoodSuper;
	private boolean isMoodGood;
	private boolean isMoodNormal;
	private boolean isMoodSatisfactorily;
	private boolean isMoodBad;
	private String moodOther = "";

	public String getEmail() {
		return email;
	}

	public FormData setEmail(String email) {
		this.email = email;
		return this;
	}

	public int getDate() {
		return date;
	}

	public FormData setDate(int date) {
		this.date = date;
		return this;
	}

	public String getName() {
		return name;
	}

	public FormData setName(String name) {
		this.name = name;
		return this;
	}

	public Sex getSex() {
		return sex;
	}

	public FormData setSex(Sex sex) {
		this.sex = sex;
		return this;
	}

	public boolean isMoodSuper() {
		return isMoodSuper;
	}

	public FormData setMoodSuper(boolean isMoodSuper) {
		this.isMoodSuper = isMoodSuper;
		return this;
	}

	public boolean isMoodGood() {
		return isMoodGood;
	}

	public FormData setMoodGood(boolean isMoodGood) {
		this.isMoodGood = isMoodGood;
		return this;
	}

	public boolean isMoodNormal() {
		return isMoodNormal;
	}

	public FormData setMoodNormal(boolean isMoodNormal) {
		this.isMoodNormal = isMoodNormal;
		return this;
	}

	public boolean isMoodSatisfactorily() {
		return isMoodSatisfactorily;
	}

	public FormData setMoodSatisfactorily(boolean isMoodSatisfactorily) {
		this.isMoodSatisfactorily = isMoodSatisfactorily;
		return this;
	}

	public boolean isMoodBad() {
		return isMoodBad;
	}

	public FormData setMoodBad(boolean isMoodBad) {
		this.isMoodBad = isMoodBad;
		return this;
	}

	public String getMoodOther() {
		return moodOther;
	}

	public FormData setMoodOther(String moodOther) {
		this.moodOther = moodOther;
		return this;
	}
}
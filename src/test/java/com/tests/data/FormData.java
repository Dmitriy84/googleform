package com.tests.data;

public class FormData {
	private String email;
	private int date;
	private String name;
	private Sex sex;
	private boolean isMoodSuper;
	private boolean isMoodGood;
	private boolean isMoodNormal;
	private boolean isMoodSatisfactorily;
	private boolean isMoodBad;
	private String moodOther;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public boolean isMoodSuper() {
		return isMoodSuper;
	}

	public void setMoodSuper(boolean isMoodSuper) {
		this.isMoodSuper = isMoodSuper;
	}

	public boolean isMoodGood() {
		return isMoodGood;
	}

	public void setMoodGood(boolean isMoodGood) {
		this.isMoodGood = isMoodGood;
	}

	public boolean isMoodNormal() {
		return isMoodNormal;
	}

	public void setMoodNormal(boolean isMoodNormal) {
		this.isMoodNormal = isMoodNormal;
	}

	public boolean isMoodSatisfactorily() {
		return isMoodSatisfactorily;
	}

	public void setMoodSatisfactorily(boolean isMoodSatisfactorily) {
		this.isMoodSatisfactorily = isMoodSatisfactorily;
	}

	public boolean isMoodBad() {
		return isMoodBad;
	}

	public void setMoodBad(boolean isMoodBad) {
		this.isMoodBad = isMoodBad;
	}

	public String getMoodOther() {
		return moodOther;
	}

	public void setMoodOther(String moodOther) {
		this.moodOther = moodOther;
	}
}
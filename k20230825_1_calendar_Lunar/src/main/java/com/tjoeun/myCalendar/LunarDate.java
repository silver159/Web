package com.tjoeun.myCalendar;

// 양력 날짜와 양력 날짜에 해당되는 음력 날짜를 기억하는 클래스
public class LunarDate {
	
	private int year; // 양력 년도
	private int month; // 양력 월
	private int day; // 양력 일
	private int yearLunar; // 음력 년도
	private int monthLunar; // 음력 월
	private int dayLunar; // 음력 일
	private boolean lunarFlag; // 윤달 여부를 기억하는 변수
	private String holiday = ""; // 공휴일을 기억하는 변수
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getYearLunar() {
		return yearLunar;
	}

	public void setYearLunar(int yearLunar) {
		this.yearLunar = yearLunar;
	}

	public int getMonthLunar() {
		return monthLunar;
	}

	public void setMonthLunar(int monthLunar) {
		this.monthLunar = monthLunar;
	}

	public int getDayLunar() {
		return dayLunar;
	}

	public void setDayLunar(int dayLunar) {
		this.dayLunar = dayLunar;
	}

	public boolean isLunarFlag() {
		return lunarFlag;
	}

	public void setLunarFlag(boolean lunarFlag) {
		this.lunarFlag = lunarFlag;
	}

	public String getHoliday() {
		return holiday;
	}

	public void setHoliday(String holiday) {
		this.holiday = holiday;
	}

	@Override
	public String toString() {
		return String.format("양력 %4d년 %2d월 %2d일은 음력으로 %s %4d년 %2d월 %2d일 입니다.",
				year,month,day, lunarFlag ? "윤" : "",yearLunar,monthLunar,dayLunar);
	}


}

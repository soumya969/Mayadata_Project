package com.md;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.sql.Time;

public class Pojo {
	private int serial;
	private String name;
	private int attendee;
	private Date date;
	private Time start;
	private Time end;
	
	
	public void setSerial(int x) {
		this.serial=x;
	}
	public void setAttendee(int x) {
		this.attendee=x;
	}
	public void setName(String x) {
		this.name=x;
	}
	public void setDate(String x) throws ParseException {
		if(x=="" || x==null) {
			x="0000-00-00 00:00:00";
		
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = sdf.parse(x);
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		this.date = sqlDate;
	}
	public void setStart(Time x) throws ParseException {
		this.start=x;
	}
	public void setEnd(Time x) throws ParseException {
		this.end=x;
	}
	
	public int getSerial() {
		return this.serial;
	}
	public int getAttendee() {
		return this.attendee;
	}
	public String getName() {
		return this.name;
	}
	public Time getStart() {
		return this.start;
	}
	public Time getEnd() {
		return this.end;
	}
	
	public Date getDate() {
		return this.date;
	}
}

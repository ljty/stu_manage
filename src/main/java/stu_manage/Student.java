package stu_manage;

import java.util.Date;

public class Student {

	private int student_id;
	private String student_name;
	private Date brithday;
	private String note;
	private int avgscore;
	
	public String getStudent_name() {
		return student_name;
	}
	
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	
	public int getStudent_id() {
		return student_id;
	}
	
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	
	public Date getBrithday() {
		return brithday;
	}
	
	public void setBrithday(Date brithday) {
		this.brithday = brithday;
	}
	
	public String getNote() {
		return note;
	}
	
	public void setNote(String note) {
		this.note = note;
	}
	
	public int getAvgscore() {
		return avgscore;
	}
	
	public void setAvgscore(int avgscore) {
		this.avgscore = avgscore;
	}
	
}

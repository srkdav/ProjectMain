package com.cdac.irp.pojos;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table()
public class TimeTable {

	public String day;

	public String periodA;
	public String periodB;

	public String periodC;
	
	public TimeTable() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Id //primary key
	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}
	
	public String getPeriodA() {
		return periodA;
	}
	public void setPeriodA(String periodA) {
		this.periodA = periodA;
	}
	public String getPeriodB() {
		return periodB;
	}
	public void setPeriodB(String periodB) {
		this.periodB = periodB;
	}
	public String getPeriodC() {
		return periodC;
	}

	public void setPeriodC(String periodC) {
		this.periodC = periodC;
	}


	public TimeTable(String day, String periodA, String periodB, String periodC) {
		super();
		this.day = day;
		this.periodA = periodA;
		this.periodB = periodB;
		this.periodC = periodC;
	}

	@Override
	public String toString() {
		return "TimeTable [day=" + day + ", periodA=" + periodA + ", periodB=" + periodB + ", periodC=" + periodC + "]";
	}	
	
	
}

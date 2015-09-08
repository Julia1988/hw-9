package com.example.tests;

import org.openqa.selenium.By;

public class GroupContact implements Comparable<GroupContact>{
	
	private String firstname;
	private String lastname;
	private String address;
	private String home;
	private String mobile;
	private String work;
	private String email1;
	private String email2;
	private String day;
	private String month;
	private String year;
	private String secondaryaddress;
	private String secondaryhome;

	public GroupContact() {
	}
	public GroupContact(String firstname, String lastname, String address, String home, String mobile, String work,
			String email1, String email2, String day, String month, String year, String secondaryaddress,
			String secondaryhome) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.home = home;
		this.mobile = mobile;
		this.work = work;
		this.email1 = email1;
		this.email2 = email2;
		this.day = day;
		this.month = month;
		this.year = year;
		this.secondaryaddress = secondaryaddress;
		this.secondaryhome = secondaryhome;
	}
	
	@Override
	public String toString() {
		return "GroupContact [home=" + home + "]";
	}
	
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((home == null) ? 0 : home.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GroupContact other = (GroupContact) obj;
		if (home == null) {
			if (other.home != null)
				return false;
		} else if (!home.equals(other.home))
			return false;
		return true;
	}

	@Override
	public int compareTo(GroupContact other) {
		return this.home.toLowerCase().compareTo(other.home.toLowerCase());
		
	}
	public GroupContact withFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}
	public GroupContact withLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}
	public GroupContact withAddress(String address) {
		this.address = address;
		return this;
	}
	public GroupContact withHome(String home) {
		this.home = home;
		return this;
	}
	public GroupContact withMobile(String mobile) {
		this.mobile = mobile;
		return this;
	}
	public GroupContact withWork(String mobile) {
		this.mobile = mobile;
		return this;
	}
	public GroupContact withEmail1(String email1) {
		this.email1 = email1;
		return this;
	}
	public GroupContact withEmail2(String email2) {
		this.email2 = email2;
		return this;
	}
	public GroupContact withDay(String day) {
		this.day = day;
		return this;
	}
	public GroupContact withMonth(String month) {
		this.month = month;
		return this;
	}
	public GroupContact withYear(String year) {
		this.year = year;
		return this;
	}
	public GroupContact withSecondaryaddress(String secondaryaddress) {
		this.secondaryaddress = secondaryaddress;
		return this;
	}
	public GroupContact withSecondaryhome(String secondaryhome) {
		this.secondaryhome = secondaryhome;
		return this;
	}
	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public String getAddress() {
		return address;
	}
	public String getHome() {
		return home;
	}
	public String getMobile() {
		return mobile;
	}
	public String getWork() {
		return work;
	}
	public String getEmail1() {
		return email1;
	}
	public String getEmail2() {
		return email2;
	}
	public String getDay() {
		return day;
	}
	public String getMonth() {
		return month;
	}
	public String getYear() {
		return year;
	}
	public String getSecondaryaddress() {
		return secondaryaddress;
	}
	public String getSecondaryhome() {
		return secondaryhome;
	}
	
		
}
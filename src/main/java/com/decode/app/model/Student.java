package com.decode.app.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "student")
@TypeAlias(value ="student")
public class Student {
	@Id
	String id;
	String name;
	Date dob;
	String email;
	String phoneNo;
	String occupation;
	String address;
	String panAccNo;
	@DBRef
	List<Batch> batchIds;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPanAccNo() {
		return panAccNo;
	}
	public void setPanAccNo(String panAccNo) {
		this.panAccNo = panAccNo;
	}
	public List<Batch> getBatchIds() {
		return batchIds;
	}
	public void setBatchIds(List<Batch> batchIds) {
		this.batchIds = batchIds;
	}
	
	
}

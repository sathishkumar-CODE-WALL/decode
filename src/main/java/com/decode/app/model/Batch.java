package com.decode.app.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Document(collection="batch")
@JsonInclude(JsonInclude.Include.NON_NULL)
@TypeAlias(value = "batch")
public class Batch {
	@Id
	String id;
	@DBRef
	Course courseId;
	Date startDate;
	Date endDate;
	boolean status;
	int durationInHrs;
	@DBRef
	Facilitator facilitatorId;
	@DBRef(lazy=true)
	List<Student> enrolledStudentList;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Course getCourseId() {
		return courseId;
	}
	public void setCourseId(Course courseId) {
		this.courseId = courseId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getDurationInHrs() {
		return durationInHrs;
	}
	public void setDurationInHrs(int durationInHrs) {
		this.durationInHrs = durationInHrs;
	}
	public Facilitator getFacilitatorId() {
		return facilitatorId;
	}
	public void setFacilitatorId(Facilitator facilitatorId) {
		this.facilitatorId = facilitatorId;
	}
	public List<Student> getEnrolledStudentList() {
		return enrolledStudentList;
	}
	public void setEnrolledStudentList(List<Student> enrolledStudentList) {
		this.enrolledStudentList = enrolledStudentList;
	}
	
}

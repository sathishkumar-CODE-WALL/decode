package com.decode.app.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@Document(collection="course")
@JsonInclude(JsonInclude.Include.NON_NULL)
@TypeAlias(value ="course")
public class Course {
	@Id
    String id;
    String name;
    String desc;
    double fee;
    boolean status;
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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public List<Batch> getBatchIds() {
		return batchIds;
	}
	public void setBatchIds(List<Batch> batchIds) {
		this.batchIds = batchIds;
	}
    
    
}

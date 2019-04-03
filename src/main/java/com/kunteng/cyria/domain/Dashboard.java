package com.kunteng.cyria.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("dashboards")
public class Dashboard implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String user;
	private String name;
	private String hash;
	private String timestamp;
	private String status;
	private String description;
	//private Int v;
	private String config;
	
	public Dashboard(){
	}

	public void setId(String id){
		this.id = id;
	}
	public String getId(){
		return this.id;
	}
	public void setUser(String user){
		this.user = user;
	}
	public String getUser(){
		return this.user;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void setTimestamp(String timestamp){
		this.timestamp = timestamp;
	}
	public String getTimestamp(){
		return this.timestamp;
	}
	public void setStatus(String status){
		this.status = status;
	}
	public String getStatus(){
		return this.status;
	}
	public void setDescription(String description){
		this.description = description;
	}
	public String getDescription(){
		return this.description;
	}
	public void setConfig(String config){
		this.config = config;
	}
	public String getConfig(){
		return this.config;
	}
	@Override
	public String toString() {
		return "";
	}

}

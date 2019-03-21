package com.kunteng.cyria.domain;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("dashboard")
public class Dashboard implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	public String toString() {
		return "";
	}

}

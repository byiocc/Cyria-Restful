package com.kunteng.cyria.domain;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("users")
public class Users {
	  @Id
	  private ObjectId _id;
	  private String username;
	  private String password;
	  private List<String> roles;
	  
	  public Users() {}
	  public Users(ObjectId _id, String username, String password, List<String> roles) {
	    this._id = _id;
	    this.username = username;
	    this.password = password;
	    this.roles = roles;
	  }
	  
	  public void set_id(ObjectId _id) { this._id = _id; }
	  public String get_id() { return this._id.toHexString(); }
	  
	  public void setPassword(String password) { this.password = password; }
	  public String getPassword() { return password; }
	  
	  public void setUsername(String username) { this.username = username; }
	  public String getUsername() { return username; }
	  
	  public List<String> getRoles() {
	        return roles;
	    }

	    public void setRoles(List<String> roles) {
	        this.roles = roles;
	    }
	}

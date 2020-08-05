package com.tts.AdventureApp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="USER")
public class User {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id")
	private long id;
	
	@NotEmpty(message="Please provide a username")
	@Length(min = 3, message = "Your username must have at least 3 characters")
	@Length(max = 15, message = "Your username cannot have more than 15 characters")
	@Pattern(regexp="[^\\s]+", message="Your username cannot contain spaces")
	private String username;
	
	@Length(min=5, message="Your password must have at least 5 characters")
	@NotEmpty
	@JsonProperty(access=Access.WRITE_ONLY)
	private String password;

	// @Email
	// private String email;

	@CreationTimestamp
	private Date createdAt;

    public User() {

	}

	//if email is implement, add arg 'String email'
    public User(long id, String username, String password, Date createdAt) {
		this.id = id;
		this.setUsername(username);
		this.password = password;
		this.createdAt = createdAt;
      //this.setEmail(email);
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// public String getEmail() {
	// 	return email;
	// }

	// public void setEmail(String email) {
	// 	this.email = email;
	// }
}
package com.tts.AdventureApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import org.hibernate.validator.constraints.Length;
  
@Entity      
@Table(name="USER")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="user_id")
    private Long id;

    @NotEmpty(message="Please provide a username")
    private String username;

    @Length(min=5, message="Your password must have at least 5 characters")
    @NotEmpty
    @JsonProperty(access=Access.WRITE_ONLY)
	private String password;
	
	@Email
	private String email;

	public User() {

	}

	public User(String username, String email) {
		this.setUsername(username);

		this.setEmail(email);
    }
    
    @Override
	public String toString() {
		return "User [id=" + id + ", name=" + username + ", email=" + email + "]";
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
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
package com.dongazul.myapp.domain;

import lombok.Data;

@Data
public class LoginDTO {

	private String email;
	private String passwd;
	private boolean rememberme;
} // end class

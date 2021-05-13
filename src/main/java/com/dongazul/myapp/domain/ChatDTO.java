package com.dongazul.myapp.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ChatDTO {
	
	private String email;
	private String roomid;
	private String roomname;
	private Timestamp insert_ts;
} // end class

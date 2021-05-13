package com.dongazul.myapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDTO {
	
	private String email;
	private String nickname;
	private Integer age;
	private String gender;
	private String zone;
	private String introduce;
	
	private String imageRoot;
	private String imgThumbImg;
	
	private String hobby1;
	private String hobby2;
	private String hobby3;

} // end class 

package com.dongazul.myapp.domain;

import lombok.Data;

@Data
public class EmailDTO {

	private String subject;
    private String content;
    private String receiver;
} // end class

package com.example.demo.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Member {
	private String username;		// 10 기본키
	private String password;		// 60
	private String email;			// 30
}

/*
	create table member (
		username varchar2(10 char) primary key,
		password varchar2(60 char),
		email varchar2(30 char)
	);
*/
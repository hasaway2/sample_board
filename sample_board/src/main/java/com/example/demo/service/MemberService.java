package com.example.demo.service;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.example.demo.dao.*;

@Service
public class MemberService {
	@Autowired
	private MemberDao memberDao;
	
	public boolean 아이디사용여부확인(String username) {
		return memberDao.countByUsername(username)==0;
	}
}

package com.example.demo.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import com.example.demo.entity.*;
import com.example.demo.service.*;

@Controller
public class MemberController {
	@Autowired
	private MemberService service;
	
	// 회원정보를 CSR로 검색
	@GetMapping("/sample1")
	public @ResponseBody Member sample1() {
		return new Member("spring", "1234", "spring@naver.com");
	}
	
	@GetMapping("/member/username/check")
	public ResponseEntity<?> 아이디사용여부확인(@RequestParam String username) {
		boolean result = service.아이디사용여부확인(username);
		if(result) {
			return ResponseEntity.status(200).body("사용가능합니다");
		} else {
			return ResponseEntity.status(500).body("사용중입니다");
		}
	}
	
	@GetMapping("/member/join")
	public ModelAndView join() {
		return new ModelAndView("member/join");
	}
}

























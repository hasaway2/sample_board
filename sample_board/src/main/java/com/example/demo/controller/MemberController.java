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
	
	// JS에서 if문 사용하지 않고 try~catch~로 처리하려면 바람직않은 결과인 경우 오류로 출력해야 한다
	// 상태코드는 200은 서버에서 결과가 출력되었다는 의미(내가 원하는 결과인가? 하고는 상관 없음)
	// 따라서 아이디가 사용가능한 경우도 200, 사용불가능한 경우도 200 -> 이렇게 되면 js에서 if문이 필요 -> 가급적 사용하지 말자
	// 그래서 바람직하지 않은 결과일 때 에러상태코드를 출력하자 -> 그런데 400, 500같은 거 사용하면 진짜 에러랑 구별이 어려워
	//      -> 서버에서 거의 발생하지 않는 409를 사용하는 경우가 흔하다
	@GetMapping("/member/username/check")
	public ResponseEntity<?> 아이디사용여부확인(@RequestParam String username) {
		if(username==null)
			return ResponseEntity.status(HttpStatus.CONFLICT).body("아이디를 입력하세요");
		boolean result = service.아이디사용여부확인(username);
		if(result) {
			return ResponseEntity.status(HttpStatus.OK).body("사용가능합니다");
		} else {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("사용중입니다");
		}
	}
	
	@GetMapping("/member/join")
	public ModelAndView join() {
		return new ModelAndView("member/join");
	}
}

package com.example.demo;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.*;

// 회원등급이 NORMAL, SILVER, GOLD-> 상수 처리

// 인터페이스로 처리하자
interface Levels {
	public static final int NORMAL = 1;
	public static final int SILVER = 2;
	public static final int GOLD = 3;
}

enum Level {
	NORMAL, SILVER, GOLD;
}

@SpringBootTest
public class EnumTest {
	public void test1() {
		// 문자열로 처리? 오타의 위험
		String 회원등급 = "NORMAL";
		String 회원등급1 = "Normal";
	}
	
	@Test
	public void test2() {
		// 인터페이스를 이용한 상수 처리
		int level1 = Levels.NORMAL;
		int level2 = Levels.SILVER;
		
		// 개발자가 착각해서
		int result = level1 + level2;
		System.out.println(result == Levels.GOLD);
	}
	
	@Test
	public void test3() {
		// enum은 상수를 담는 클래스 짝퉁 -> 상수로 사용자 정의 타입을 만들었다
		Level level1 = Level.NORMAL;
		Level level2 = Level.SILVER;
	
		//Level result = level1 + level2;
		
		int newLevel = 4;
		//Level newLevel2 = 4;
		System.out.println(level1.name());
	}
}









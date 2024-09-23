package com.example.demo.dao;

import org.apache.ibatis.annotations.*;

// 스프링의 DAO 어노테이션은 @Repository
//		@Repository를 만나면 스프링이 bean을 생성해 ApplicationContext에 등록
// 마이바티스 인터페이스를 사용할 경우 객체를 마이바티스가 생성
//		인터페이스와 sql을 이용해서 객체를 생성해야 하는데 스프링은 그게 뭔지 몰라
//		@Mapper를 이용해 마이바티스가 객체를 생성한 다음 등록하라고 지정

@Mapper
public interface MemberDao {
	@Select("select count(username) from member where username=#{username}")
	public int countByUsername(String username);
}

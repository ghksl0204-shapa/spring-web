package com.kh.spring.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring.member.model.dto.MemberDto;

@Repository
public class MemberDao {

	public MemberDto login(SqlSessionTemplate sqlSession, MemberDto member) {
		return sqlSession.selectOne("memberMapper.login", member);
	}

	public void signup(SqlSessionTemplate sqlSession, MemberDto member) {
		sqlSession.insert("memberMapper.signup", member);
	}

	
	
}

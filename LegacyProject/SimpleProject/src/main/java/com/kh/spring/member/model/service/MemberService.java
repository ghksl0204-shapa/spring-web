package com.kh.spring.member.model.service;

import com.kh.spring.member.model.dto.MemberDto;

// 현업에서 많이 사용되는 안티패턴
public interface MemberService {

	void login(MemberDto member);
	
}

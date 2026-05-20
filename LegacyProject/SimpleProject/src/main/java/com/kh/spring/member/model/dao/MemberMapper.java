package com.kh.spring.member.model.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.kh.spring.member.model.dto.MemberDto;
import com.kh.spring.member.model.vo.Member;


@Mapper
public interface MemberMapper {

	@Select("SELECT USER_ID, USER_PWD, USER_NAME, EMAIL, ENROLL_DATE FROM MEMBER WHERE USER_ID = #{userId} AND STATUS = 'Y'")
	MemberDto login(MemberDto member);
	
	@Insert("INSERT INTO MEMBER(USER_ID, USER_PWD, USER_NAME, EMAIL) VALUES(#{userId}, #{userPwd}, #{userName}, #{email})")
	void signup(Member member);

	@Update("UPDATE MEMBER SET USER_NAME = #{userName}, EMAIL = #{email} WHERE USER_ID = #{userId} AND STATUS = 'Y'")
	int update(MemberDto member);
	
	@Delete("DELETE FROM MEMBER WHERE USER_ID = #{userId} AND STATUS = 'Y'")
	int delete(String userId);
	
	
}

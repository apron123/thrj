package com.thrj.Mapper;

import org.apache.ibatis.annotations.Mapper;

import com.thrj.Entity.Members;

@Mapper
public interface MemberMapper {
	
	public Members idCheck(String mb_id); // 사용자 아이디 체크
	public void createMember(Members vo);   // 유저등록
	public void updateMember(Members vo);   // 사용자수정
	public void deleteMember(String mb_id); // 사용자삭제
	public boolean logincheck(String mb_id, String mb_pw); //로그인체크
}

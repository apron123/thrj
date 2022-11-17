package com.thrj.Entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;


@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Data // getter setter
@ToString
public class Members {
	 @NonNull
    private String mb_id; // 회원 아이디 
	 
	 @NonNull
    private String mb_pw; // 회원 비밀번호 

	 @NonNull
    private String mb_name; // 회원 이름 
	 
	@NonNull
	private String mb_genre; // 회원 선호장르 
    private String mb_profile; // 회원 프로필 
    private Date mb_joindate;  // 회원 가입일자 
    private String mb_type;   // 회원 유형 
}

package com.thrj.vod.Entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Members {
	 // 회원 아이디 
    private String mb_id;

    // 회원 비밀번호 
    private String mb_pw;

    // 회원 이름 
    private String mb_name;

    // 회원 프로필 
    private String mb_profile;

    // 회원 선호장르 
    private String mb_genre;

    // 회원 가입일자 
    private Date mb_joindate;

    // 회원 유형 
    private String mb_type;
}

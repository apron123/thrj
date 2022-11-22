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
public class Comments {
	@NonNull private int cmt_seq;   // 댓글순번
	@NonNull private String mb_id; // 회원 아이디 
	         private int movie_seq; // 영화순번
	 		 private String mb_name; // 회원 이름 
			 private String mb_profile; // 회원 프로필 
			 private String cmt_date; // 작성날짜
			 private String cmt_content; //게시물내용
}
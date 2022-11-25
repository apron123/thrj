package com.thrj.Entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data // getter setter
@ToString
public class History {
	
	private String mb_id;
	private int movie_seq;
	private Date date;
	
}

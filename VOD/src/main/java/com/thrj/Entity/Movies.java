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
public class Movies {
	
	private String admin_id;
	private String movie_actor;
	private String movie_age;
	private String movie_content;
	private String movie_country;
	private String movie_director;
	private String movie_img;
	private Date movie_open_date;
	private int movie_rating;
	private String movie_runtime;
	private int movie_seq;
	private String movie_title;
	private String movie_type_;
	
}

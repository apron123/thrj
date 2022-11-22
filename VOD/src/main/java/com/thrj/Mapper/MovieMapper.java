package com.thrj.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.thrj.Entity.Members;
import com.thrj.Entity.Movies;

@Mapper
public interface MovieMapper {
	public List<Movies> movieList(); //영화기록
	public Movies animeDetails(int movie_seq); //박스오피스에서 번호값을 받았을경우
	public void raiseLookupCount(int movie_seq);//게시물을 볼경우 count
}

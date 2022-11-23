package com.thrj.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.thrj.Entity.Members;
import com.thrj.Entity.Movies;
import com.thrj.Entity.Paging;

@Mapper
public interface MovieMapper {
	public List<Movies> movieList(); //영화기록
	public Movies animeDetails(int movie_seq); //박스오피스에서 번호값을 받았을경우
	public void raiseLookupCount(int movie_seq);//게시물을 볼경우 count
	public List<Movies> bannerList();
	
	public int getTotalRowCount(Paging paging);
	public List<Paging> getPageList(Paging paging);
}

package com.thrj.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.thrj.Entity.Members;
import com.thrj.Entity.Movies;

@Mapper
public interface MovieMapper {
	
    //test
	public Members idCheck(String mb_id);

	public List<Movies> movieList();
}

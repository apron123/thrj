package com.thrj.Mapper;

import org.apache.ibatis.annotations.Mapper;

import com.thrj.Entity.Members;

@Mapper
public interface MovieMapper {
	
    //test
	public Members idCheck(String mb_id);
}

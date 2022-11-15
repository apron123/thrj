package com.thrj.vod.Mapper;

import org.apache.ibatis.annotations.Mapper;

import com.thrj.vod.Entity.Members;

@Mapper
public interface MovieMapper {

	public int countAll();

	public Members idCheck(String mb_id);
	
}

package com.system.mapper;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageRowBounds;
import com.system.entity.dto.CrwlResultDto;
import com.system.entity.pojo.CrwlResult;
import com.system.util.MyMapper;

public interface CrwlResultMapper extends MyMapper<CrwlResult> {

	List<CrwlResult> selectBySelective(CrwlResult crwlResult, PageRowBounds pageRowBounds);

	List<CrwlResultDto> getStaticsCrwlResultList(CrwlResultDto crwlResultDto, PageRowBounds pageRowBounds);
	
	List<CrwlResult> selectAll(CrwlResult crwlResult);
}
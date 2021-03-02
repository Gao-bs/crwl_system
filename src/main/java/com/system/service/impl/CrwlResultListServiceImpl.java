package com.system.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageRowBounds;
import com.system.entity.dto.CrwlResultDto;
import com.system.entity.dto.PageDto;
import com.system.entity.pojo.CrwlResult;
import com.system.entity.pojo.User;
import com.system.mapper.CrwlCategoryMapper;
import com.system.mapper.CrwlResultMapper;
import com.system.service.CrwlResultListService;

@Service
public class CrwlResultListServiceImpl implements CrwlResultListService{

	@Autowired
	private  CrwlResultMapper crwlResultMapper;
	
	
	@Override
	public int deleteCrwlResult(CrwlResult crwlResult) {
		// TODO Auto-generated method stub
		return crwlResultMapper.deleteByPrimaryKey(crwlResult);
	}

	@Override
	public int saveOrUpdateCrwlResult(CrwlResult crwlResult) {
		if(StringUtils.isNotEmpty(crwlResult.getId())){
			return crwlResultMapper.updateByPrimaryKeySelective(crwlResult);
		}else{
			crwlResult.setCreateTime(new Date());
			crwlResultMapper.insertSelective(crwlResult);
			return 1;
		    
		}
	}
	public List<CrwlResult> selectAll(CrwlResult crwlResult){
		List<CrwlResult> selectAll = crwlResultMapper.selectAll(crwlResult);
		return selectAll;
	}
	@Override
	public PageDto<CrwlResult> getCrwlResultList(CrwlResult crwlResult, PageDto<CrwlResult> pageDto) {
		PageRowBounds pageRowBounds = new PageRowBounds(pageDto.getPageNum(), pageDto.getPageSize());
		List<CrwlResult> data = crwlResultMapper.selectBySelective(crwlResult, pageRowBounds);
		for(CrwlResult cr:data){
			if(cr.getContents()!=null){
			cr.setContent( new String (cr.getContents()));
			}
		}
		pageDto.setTotal(pageRowBounds.getTotal());
		pageDto.setResult(data);
		return pageDto;
	}

	@Override
	public PageDto<CrwlResultDto> getStaticsCrwlResultList(CrwlResultDto crwlResultDto,
			PageDto<CrwlResultDto> pageDto) {
		// TODO Auto-generated method stub
		PageRowBounds pageRowBounds = new PageRowBounds(pageDto.getPageNum(), pageDto.getPageSize());
		List<CrwlResultDto> data = crwlResultMapper.getStaticsCrwlResultList(crwlResultDto, pageRowBounds);
		
		pageDto.setTotal(pageRowBounds.getTotal());
		pageDto.setResult(data);
		return pageDto;
	}

}

package com.system.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageRowBounds;
import com.system.entity.dto.PageDto;
import com.system.entity.pojo.CrwlCategory;
import com.system.mapper.CrwlCategoryMapper;
import com.system.service.CrwlCategoryService;

import tk.mybatis.mapper.entity.Example;

@Service
public class CrwlCategoryServiceImpl implements CrwlCategoryService{

	@Autowired
	private  CrwlCategoryMapper CrwlCategoryMapper;
	
	@Override
	public PageDto<CrwlCategory> getCrwlCategoryList(CrwlCategory CrwlCategory, PageDto<CrwlCategory> pageDto) {
		PageRowBounds pageRowBounds = new PageRowBounds(pageDto.getPageNum(), pageDto.getPageSize());
		List<CrwlCategory> data = CrwlCategoryMapper.selectBySelective(CrwlCategory, pageRowBounds);
		pageDto.setTotal(pageRowBounds.getTotal());
		pageDto.setResult(data);
		return pageDto;
	}

	@Override
	public int saveOrUpdateCrwlCategory(CrwlCategory CrwlCategory) {
		if(StringUtils.isNotEmpty(CrwlCategory.getId())){
			return CrwlCategoryMapper.updateByPrimaryKeySelective(CrwlCategory);
		}else{
			CrwlCategory.setCreateTime(new Date());
			CrwlCategoryMapper.insertSelective(CrwlCategory);
			return 1;
		    
		}
	}

	@Override
	public int deleteCrwlCategory(CrwlCategory CrwlCategory) {
		// TODO Auto-generated method stub
		return 	CrwlCategoryMapper.deleteByPrimaryKey(CrwlCategory);
	}

	@Override
	public List<CrwlCategory> getAllCrwlCategoryList(CrwlCategory CrwlCategory) {
		Example example=new Example(CrwlCategory.class);
		example.setOrderByClause("create_time asc");
		List<CrwlCategory>  list=CrwlCategoryMapper.selectByExample(example);
		return list;
	}

}

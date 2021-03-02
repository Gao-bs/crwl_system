package com.system.mapper;

import java.util.List;

import com.github.pagehelper.PageRowBounds;
import com.system.entity.pojo.CrwlCategory;
import com.system.util.MyMapper;

public interface CrwlCategoryMapper extends MyMapper<CrwlCategory> {

	List<com.system.entity.pojo.CrwlCategory> selectBySelective(CrwlCategory crwlCategory, PageRowBounds pageRowBounds);
}
package com.system.service;

import java.util.List;

import com.system.entity.dto.PageDto;
import com.system.entity.pojo.CrwlCategory;

public interface CrwlCategoryService {

	PageDto<CrwlCategory> getCrwlCategoryList(CrwlCategory CrwlCategory, PageDto<CrwlCategory> cpsPageDto);

	int saveOrUpdateCrwlCategory(CrwlCategory CrwlCategory);

	int deleteCrwlCategory(CrwlCategory CrwlCategory);

	List<CrwlCategory> getAllCrwlCategoryList(CrwlCategory CrwlCategory);

}

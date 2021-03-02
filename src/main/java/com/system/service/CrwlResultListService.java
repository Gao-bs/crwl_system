package com.system.service;

import java.util.List;

import com.system.entity.dto.CrwlResultDto;
import com.system.entity.dto.PageDto;
import com.system.entity.pojo.CrwlResult;

public interface CrwlResultListService {

	int deleteCrwlResult(CrwlResult crwlResult);

	int saveOrUpdateCrwlResult(CrwlResult crwlResult);
	 List<CrwlResult> selectAll(CrwlResult crwlResult);

	PageDto<com.system.entity.pojo.CrwlResult> getCrwlResultList(CrwlResult crwlResult, PageDto<CrwlResult> cpsPageDto);

	PageDto<com.system.entity.dto.CrwlResultDto> getStaticsCrwlResultList(CrwlResultDto crwlResultDto,
			PageDto<CrwlResultDto> cpsPageDto);


}

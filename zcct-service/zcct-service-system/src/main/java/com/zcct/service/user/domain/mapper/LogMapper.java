package com.zcct.service.user.domain.mapper;

import com.zcct.service.user.api.dto.LogDto;
import com.zcct.service.user.domain.Log;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LogMapper extends BaseMapper<LogDto, Log>{

}

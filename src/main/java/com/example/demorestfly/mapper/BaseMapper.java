package com.example.demorestfly.mapper;

import com.example.demorestfly.dto.BaseDto;
import com.example.demorestfly.entities.BaseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BaseMapper {

    BaseDto convertToDto(BaseEntity baseEntity);
}

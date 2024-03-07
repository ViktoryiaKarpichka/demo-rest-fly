package com.example.demorestfly.mapper;

import com.example.demorestfly.dto.UserDto;
import com.example.demorestfly.dto.UserRegistrationDto;
import com.example.demorestfly.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = BaseMapper.class)
public interface UserMapper {

    @Mapping(target = "role", source = "user.role.name")
    UserDto convertToDto(User user);

    User convertToEntity(UserRegistrationDto userRegistrationDto);
}

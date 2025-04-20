package com.laqqueta.healthcare.user;

import com.laqqueta.healthcare.biodata.BiodataMapper;
import com.laqqueta.healthcare.properties.BasePropertiesMapperConfig;
import com.laqqueta.healthcare.role.RoleMapper;
import com.laqqueta.healthcare.user.dto.UserDTO;
import com.laqqueta.healthcare.user.dto.UserDetailsDTO;
import com.laqqueta.healthcare.util.mapper.BasicMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        config = BasePropertiesMapperConfig.class,
        uses = {BiodataMapper.class, RoleMapper.class},
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserMapper extends BasicMapper<UserModel, UserDTO, UserDetailsDTO> {
    @Mapping(target = "baseProperties", source = "user")
    UserDetailsDTO mapDetails(UserModel user);

    @Mapping(target = "password", ignore = true)
    @Mapping(target = "locked", ignore = true)
    @Mapping(target = "lastLogin", ignore = true)
    UserModel mapModel(UserDTO userDTO);
}

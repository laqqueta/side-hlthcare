package com.laqqueta.healthcare.role;

import com.laqqueta.healthcare.properties.BasePropertiesMapperConfig;
import com.laqqueta.healthcare.role.dto.RoleDTO;
import com.laqqueta.healthcare.role.dto.RoleDetailsDTO;
import com.laqqueta.healthcare.util.mapper.BasicMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        config = BasePropertiesMapperConfig.class,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface RoleMapper extends BasicMapper<RoleModel, RoleDTO, RoleDetailsDTO> {
    @Mapping(target = "baseProperties", source = "role")
    RoleDetailsDTO mapDetails(RoleModel role);
}

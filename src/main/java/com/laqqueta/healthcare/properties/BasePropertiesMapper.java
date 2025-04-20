package com.laqqueta.healthcare.properties;

import com.laqqueta.healthcare.user.UserMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = UserMapper.class,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface BasePropertiesMapper {
    @Mapping(target = "deleted", source = "deleted")
    @Mapping(target = "createdBy", source = "createdBy")
    @Mapping(target = "createdOn", source = "createdOn")
    @Mapping(target = "modifiedBy", source = "modifiedBy")
    @Mapping(target = "modifiedOn", source = "modifiedOn")
    @Mapping(target = "deletedBy", source = "deletedBy" )
    @Mapping(target = "deletedOn", source = "deletedOn")
    BasePropertiesDTO map(BaseProperties baseProperties);
}

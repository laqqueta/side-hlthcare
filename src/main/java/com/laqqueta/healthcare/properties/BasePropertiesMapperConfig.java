package com.laqqueta.healthcare.properties;

import org.mapstruct.*;

@MapperConfig(
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG
)
public interface BasePropertiesMapperConfig {
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdOn", ignore = true)
    @Mapping(target = "modifiedBy", ignore = true)
    @Mapping(target = "modifiedOn", ignore = true)
    @Mapping(target = "deletedBy", ignore = true)
    @Mapping(target = "deletedOn", ignore = true)
    BaseProperties map(Object dto);
}

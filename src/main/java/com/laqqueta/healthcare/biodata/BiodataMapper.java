package com.laqqueta.healthcare.biodata;


import com.laqqueta.healthcare.biodata.dto.BiodataDTO;
import com.laqqueta.healthcare.biodata.dto.BiodataDetailsDTO;
import com.laqqueta.healthcare.properties.BasePropertiesMapperConfig;
import com.laqqueta.healthcare.util.mapper.BasicMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        config = BasePropertiesMapperConfig.class,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface BiodataMapper extends BasicMapper<BiodataModel, BiodataDTO, BiodataDetailsDTO> {
    @Mapping(target = "baseProperties", source = "model")
    BiodataDetailsDTO mapDetails(BiodataModel model);
}

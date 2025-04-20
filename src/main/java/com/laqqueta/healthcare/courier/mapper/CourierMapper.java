package com.laqqueta.healthcare.courier.mapper;

import com.laqqueta.healthcare.courier.CourierModel;
import com.laqqueta.healthcare.courier.dto.CourierDTO;
import com.laqqueta.healthcare.courier.dto.CourierDetailDTO;
import com.laqqueta.healthcare.courier.dto.CourierRequestDTO;
import com.laqqueta.healthcare.properties.BasePropertiesMapperConfig;
import com.laqqueta.healthcare.util.mapper.BasicMapper;
import com.laqqueta.healthcare.util.mapper.RequestMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        config = BasePropertiesMapperConfig.class,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface CourierMapper extends
        BasicMapper<CourierModel, CourierDTO, CourierDetailDTO>,
        RequestMapper<CourierModel, CourierRequestDTO> {
    @Mapping(target = "baseProperties", source = "model")
    CourierDetailDTO mapDetails(CourierModel model);
}

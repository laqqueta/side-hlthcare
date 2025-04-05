package com.laqqueta.healthcare.courier.mapper;

import com.laqqueta.healthcare.courier.CourierModel;
import com.laqqueta.healthcare.properties.mapper.BasePropertiesMapper;

public record CourierDetailMapper(Long id, String name, BasePropertiesMapper baseProperties) {

    public static CourierDetailMapper map(CourierModel courier) {
        if (courier == null) return null;

        return new CourierDetailMapper(
                courier.getId(), courier.getName(), BasePropertiesMapper.map(courier)
        );
    }

}

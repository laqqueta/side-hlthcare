package com.laqqueta.healthcare.courier.mapper;

import com.laqqueta.healthcare.courier.CourierModel;

public record CourierRequest(Long id, String name, Long createBy, Long modifiedBy, Long deletedBy) {

    public static CourierModel toModel(CourierRequest courier) {
        return new CourierModel(courier.id(), courier.name());
    }

}

package com.laqqueta.healthcare.courier.mapper;

import com.laqqueta.healthcare.courier.CourierModel;

public record CourierMapper(Long id, String name) {

    public static CourierMapper map(CourierModel model) {
        if (model == null) return null;

        return new CourierMapper(
                model.getId(),
                model.getName()
        );
    }

}


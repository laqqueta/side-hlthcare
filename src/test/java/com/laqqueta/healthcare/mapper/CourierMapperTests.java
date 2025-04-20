package com.laqqueta.healthcare.mapper;

import com.laqqueta.healthcare.courier.CourierModel;
import com.laqqueta.healthcare.courier.dto.CourierDTO;
import com.laqqueta.healthcare.courier.dto.CourierDetailDTO;
import com.laqqueta.healthcare.courier.mapper.CourierMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CourierMapperTests {

    private CourierMapper courierMapper;
    private CourierModel courierModel;
    private CourierDTO expectedCourierDto;
    private CourierDetailDTO expectedCourierDetailDTO;

    @BeforeEach
    void setUp() {
        courierMapper = Mappers.getMapper(CourierMapper.class);
        courierModel = new CourierModel();
        SetupBasePropertiesDtoData data = new SetupBasePropertiesDtoData();

        courierModel.setId(99L);
        courierModel.setName("Courier");
        courierModel.setCreatedOn(data.getDate());
        courierModel.setModifiedOn(data.getDate());
        courierModel.setCreatedBy(data.getCreatedBy());
        courierModel.setModifiedBy(data.getCreatedBy());
        courierModel.setDeleted(false);
    }

    @Test void map_ShouldMapCourierModelToCourierDto() {

    }

    @Test void map_ShouldReturnsNullOnFieldsWhenCourierHaveNullsFields() {

    }

    @Test void map_ShouldReturnNullsWhenCourierModelIsNull() {

    }

    @Test void mapDetails_ShouldMapCourierModelToCourierDto() {

    }

    @Test void mapDetails_ShouldReturnsNullOnFieldsWhenCourierHaveNullsFields() {

    }

    @Test void mapDetails_ShouldReturnNullsWhenCourierModelIsNull() {

    }



}

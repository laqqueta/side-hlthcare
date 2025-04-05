package com.laqqueta.healthcare.mapper;

import com.laqqueta.healthcare.courier.CourierModel;
import com.laqqueta.healthcare.courier.mapper.CourierMapper;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CourierMapperTests {

    @Test
    public void map_WhenCourierModelExists_ReturnsCourierMapper() {
        CourierModel courier = new CourierModel(1L, "Map User");
        CourierMapper mockMappedCourier = new CourierMapper(1L, "Map User");

        CourierMapper courierMapper = CourierMapper.map(courier);

        SoftAssertions.assertSoftly(s -> {
            s.assertThat(courierMapper).isEqualTo(mockMappedCourier);
            s.assertThat(courierMapper)
                    .usingRecursiveComparison()
                    .comparingOnlyFields("id", "name")
                    .isEqualTo(courier);
        });
    }

    @Test
    public void map_WhenCourierModelIsNull_ReturnsNullOnCourierMapper() {
        CourierModel actualCourier = null;
        CourierMapper mockNullMapper = null;

        CourierMapper mappedModel = CourierMapper.map(actualCourier);

        SoftAssertions.assertSoftly(s -> {
            s.assertThat(mappedModel).isNull();
            s.assertThat(mappedModel).isEqualTo(mockNullMapper);
        });
    }

    @Test
    public void map_WhenCourierModelIsEmptyObject_ReturnsEmptyObjectOnCourierMapper() {
        CourierModel actualCourier = new CourierModel(null, null);
        CourierMapper mockEmptyMapper = new CourierMapper(null, null);

        CourierMapper mappedModel = CourierMapper.map(actualCourier);

        SoftAssertions.assertSoftly(s -> {
            s.assertThat(mappedModel).isEqualTo(mockEmptyMapper);
            s.assertThat(mappedModel).usingRecursiveComparison()
                    .isEqualTo(actualCourier);
        });
    }

    @Test
    public void map_WhenCourierModelHaveNullFields_ReturnsNullOnCourierMapperNullFields() {
        CourierModel actualCourier = new CourierModel(1L, null);
        CourierMapper mockNullFields = new CourierMapper(1L, null);

        CourierMapper mappedModel = CourierMapper.map(actualCourier);

        SoftAssertions.assertSoftly(s -> {
            s.assertThat(mappedModel).isEqualTo(mockNullFields);
            s.assertThat(mappedModel).usingRecursiveComparison()
                    .isEqualTo(actualCourier);
            s.assertThat(mappedModel.name()).isNull();
        });
    }

}

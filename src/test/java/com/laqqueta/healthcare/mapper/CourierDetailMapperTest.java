package com.laqqueta.healthcare.mapper;

import com.laqqueta.healthcare.courier.CourierModel;
import com.laqqueta.healthcare.courier.mapper.CourierDetailMapper;
import com.laqqueta.healthcare.properties.mapper.BasePropertiesMapper;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CourierDetailMapperTest {

    @Test
    public void map_WhenCourierModelExists_ReturnsCourierDetailMapper() {
        CourierModel actualCourier = new CourierModel(1L, "NAME");
        CourierDetailMapper mockCourierMapper = new CourierDetailMapper(1L, "NAME", BasePropertiesMapper.initNull());

        CourierDetailMapper mappedModel = CourierDetailMapper.map(actualCourier);

        SoftAssertions.assertSoftly(s -> {
            s.assertThat(mappedModel).isEqualTo(mockCourierMapper);
            s.assertThat(mappedModel).usingRecursiveComparison()
                    .comparingOnlyFields("id", "name")
                    .isEqualTo(actualCourier);
        });
    }

    @Test
    public void map_WhenCourierModelIsNull_ReturnsNullOnCourierDetailMapper() {
        CourierModel actualCourier = null;
        CourierDetailMapper mockNullCourierMapper = null;

        CourierDetailMapper mappedModel = CourierDetailMapper.map(actualCourier);

        SoftAssertions.assertSoftly(s -> {
            s.assertThat(mappedModel).isNull();
            s.assertThat(mappedModel).isEqualTo(mockNullCourierMapper);
        });
    }

    @Test
    public void map_WhenCourierModelIsEmptyObject_ReturnsEmptyObjectOnCourierDetailMapper() {
        CourierModel actualCourier = new CourierModel();
        CourierDetailMapper mockEmptyCourierMapper =
                new CourierDetailMapper(null, null, BasePropertiesMapper.initNull());

        CourierDetailMapper mappedModel = CourierDetailMapper.map(actualCourier);

        SoftAssertions.assertSoftly(s -> {
            s.assertThat(mappedModel).isEqualTo(mockEmptyCourierMapper);
            s.assertThat(mappedModel).usingRecursiveComparison()
                    .ignoringFields("baseProperties")
                    .isEqualTo(actualCourier);
        });
    }

}

package com.laqqueta.healthcare.mapper;

import com.laqqueta.healthcare.biodata.BiodataModel;
import com.laqqueta.healthcare.biodata.mapper.BiodataDetailsMapper;
import com.laqqueta.healthcare.properties.mapper.BasePropertiesMapper;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BiodataDetailMapperTests {

    @Test
    public void map_WhenBiodataModelExists_ReturnsBiodataDetailMapper() {
        // Arrange
        byte[] arrImage = new byte[]{99, 99, 99};
        BiodataModel actualBiodataModel = new BiodataModel(1L, "TEST ACTUAL BIODATA", "999999999",
                arrImage, "Actual Image Path");
        BiodataDetailsMapper mockMappedModel = new BiodataDetailsMapper(1L, "TEST ACTUAL BIODATA", "999999999",
                arrImage, "Actual Image Path", BasePropertiesMapper.initNull());
        // Act
        BiodataDetailsMapper mappedBiodata = BiodataDetailsMapper.map(actualBiodataModel);
        // Assertions
        SoftAssertions.assertSoftly(s -> {
            s.assertThat(mappedBiodata)
                    .usingRecursiveComparison()
                    .comparingOnlyFields("id", "fullName", "mobilePhone", "image", "imagePath")
                    .isEqualTo(actualBiodataModel);

            s.assertThat(mappedBiodata)
                    .isEqualTo(mockMappedModel);
        });
    }

    @Test
    public void map_WhenBiodataModelIsNull_ReturnsNullOnBiodataDetailMapper() {
        // Arrange
        BiodataModel mockNullBiodataModel = null;
        BiodataDetailsMapper mockNullMapper = null;
        // Act
        BiodataDetailsMapper mappedBiodata = BiodataDetailsMapper.map(mockNullBiodataModel);
        // Assertions
        SoftAssertions.assertSoftly(s -> {
            s.assertThat(mappedBiodata).isEqualTo(mockNullMapper);
            s.assertThat(mappedBiodata).isNull();
        });

    }

    @Test
    public void map_WhenBiodataModelIsEmptyObject_ReturnsEmptyObjectOnBiodataDetailMapper() {
        // Arrange
        BiodataModel actualBiodataModel = new BiodataModel();
        BiodataDetailsMapper mockEmptyMapped = new BiodataDetailsMapper(null, null, null, null,
                null, BasePropertiesMapper.initNull());
        // Act
        BiodataDetailsMapper mappedBiodata = BiodataDetailsMapper.map(actualBiodataModel);
        // Assertions
        SoftAssertions.assertSoftly(s -> {
            s.assertThat(mappedBiodata)
                    .usingRecursiveComparison()
                    .ignoringFields("baseProperties")
                    .isEqualTo(actualBiodataModel);

            s.assertThat(mappedBiodata)
                    .isEqualTo(mockEmptyMapped);
        });
    }

}

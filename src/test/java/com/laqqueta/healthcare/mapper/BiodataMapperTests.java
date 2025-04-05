package com.laqqueta.healthcare.mapper;

import com.laqqueta.healthcare.biodata.BiodataModel;
import com.laqqueta.healthcare.biodata.mapper.BiodataMapper;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class BiodataMapperTests {

    @Test
    public void map_WhenBiodataModelExists_ReturnBiodataMapper() {
        byte[] arrImage = new byte[]{11, 22, 33};
        BiodataModel model = new BiodataModel(
                1L, "TEST BIDOATA", "0811111",
                arrImage, "Image Path");
        BiodataMapper mockMappedModel = new BiodataMapper(1L, "TEST BIDOATA", "0811111",
                arrImage, "Image Path");


        BiodataMapper mappedModel = BiodataMapper.map(model);

        SoftAssertions.assertSoftly(s -> {
            s.assertThat(mappedModel)
                    .usingRecursiveComparison()
                    .comparingOnlyFields("fullName", "id", "mobilePhone", "imagePath", "image")
                    .isEqualTo(model);

            s.assertThat(mappedModel)
                    .isEqualTo(mockMappedModel);
        });
    }

    @Test
    public void map_WhenBiodataModelIsNull_ReturnsNullOnBiodataMapper() {
        // Arrange
        BiodataModel mockNullModel = null;
        BiodataMapper mockNullMapper = null;
        // Act
        BiodataMapper mappedModel = BiodataMapper.map(mockNullModel);
        // Assertions
        assertThat(mappedModel)
                .isEqualTo(mockNullMapper);
    }

    @Test
    public void map_WhenBiodataModelIsEmpty_ReturnsEmptyObjectOnBiodataMapper() {
        // Arrange
        BiodataModel actualEmptyModel = new BiodataModel(null, null, null, null, null);
        BiodataMapper mockEmptyMappedModel = new BiodataMapper(null, null, null, null, null);
        // Act
        BiodataMapper mappedModel = BiodataMapper.map(actualEmptyModel);
        // Assertions
        SoftAssertions.assertSoftly(s -> {
            s.assertThat(mappedModel)
                    .isEqualTo(mockEmptyMappedModel);

            s.assertThat(mappedModel)
                    .usingRecursiveComparison()
                    .isEqualTo(actualEmptyModel);
        });
    }

    @Test
    public void map_WhenBiodataModelHaveNullFields_ReturnNullOnBiodataMapperFields() {
        BiodataModel actualBiodata = new BiodataModel(1L, null, "0111111", null, "Image Path");
        BiodataMapper mockEmptyFields = new BiodataMapper(1L, null, "0111111", null, "Image Path");

        BiodataMapper mappedModel = BiodataMapper.map(actualBiodata);

        SoftAssertions.assertSoftly(s -> {
            s.assertThat(mappedModel)
                    .usingRecursiveComparison()
                    .isEqualTo(actualBiodata);

            s.assertThat(mappedModel)
                    .isEqualTo(mockEmptyFields);

            s.assertThat(mappedModel)
                    .hasFieldOrPropertyWithValue("fullName", null)
                    .hasFieldOrPropertyWithValue("image", null);
        });
    }

}

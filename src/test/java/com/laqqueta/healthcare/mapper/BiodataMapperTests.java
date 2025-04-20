package com.laqqueta.healthcare.mapper;

import com.laqqueta.healthcare.biodata.BiodataMapper;
import com.laqqueta.healthcare.biodata.BiodataModel;
import com.laqqueta.healthcare.biodata.dto.BiodataDTO;
import com.laqqueta.healthcare.biodata.dto.BiodataDetailsDTO;
import com.laqqueta.healthcare.properties.BasePropertiesDTO;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class BiodataMapperTests {

    private BiodataMapper biodataMapper;
    private BiodataModel biodataModel;
    private BiodataDTO expectedDTO;
    private BiodataDetailsDTO expectedDetailDTO;
    private byte[] image = new byte[] {11, 22, 33};

    @BeforeEach
    public void setUp() {
        biodataMapper = Mappers.getMapper(BiodataMapper.class);
        SetupBasePropertiesDtoData data = new SetupBasePropertiesDtoData();
        biodataModel = new BiodataModel();

        biodataModel.setId(99L);
        biodataModel.setFullName("Full Name");
        biodataModel.setMobilePhone("1111-2222-3333");
        biodataModel.setImage(image);
        biodataModel.setImagePath("/path/iamge.png");
        biodataModel.setDeleted(false);
        biodataModel.setCreatedBy(data.getCreatedBy());
        biodataModel.setCreatedOn(data.getDate());
        biodataModel.setModifiedBy(data.getModifiedBy());
        biodataModel.setModifiedOn(data.getDate());

        expectedDTO = new BiodataDTO(99L, "Full Name", "1111-2222-3333", image, "/path/iamge.png");
        expectedDetailDTO = new BiodataDetailsDTO(99L, "Full Name", "1111-2222-3333", image, "/path/iamge.png",
                data.getBasePropertiesDTO());

    }

    @Test
    public void map_ShouldMapBiodataModelToBiodataDTO() {
        BiodataDTO result = biodataMapper.map(biodataModel);

        SoftAssertions.assertSoftly(s -> {
            s.assertThat(result)
                    .usingRecursiveComparison()
                    .withStrictTypeChecking()
                    .ignoringFields("image")
                    .isEqualTo(expectedDTO);

            s.assertThat(result)
                    .extracting(BiodataDTO::image)
                    .isEqualTo(image);
        });
    }

    @Test
    public void map_ShouldReturnsNullOnFieldsWhenBiodataHaveNullsFields() {
        biodataModel.setFullName(null);
        biodataModel.setMobilePhone(null);

        BiodataDTO result = biodataMapper.map(biodataModel);

        SoftAssertions.assertSoftly(s -> {
            s.assertThat(result)
                    .extracting(BiodataDTO::fullName)
                    .isNull();

            s.assertThat(result)
                    .extracting(BiodataDTO::mobilePhone)
                    .isNull();
        });
    }

    @Test
    public void map_ShouldReturnsNullWhenBiodataIsNull() {
        BiodataModel biodataModel1 = null;
        BiodataDTO mockNullBiodataDto = null;

        BiodataDTO result = biodataMapper.map(biodataModel1);

        assertThat(result)
                .isEqualTo(mockNullBiodataDto);
    }

    @Test void mapDetails_ShouldMapBiodataModelToBiodataDetailsDTO() {
        BiodataDetailsDTO result = biodataMapper.mapDetails(biodataModel);

        SoftAssertions.assertSoftly(s -> {
            s.assertThat(result)
                    .usingRecursiveComparison()
                    .withStrictTypeChecking()
                    .ignoringFields("image")
                    .isEqualTo(expectedDetailDTO);

            s.assertThat(result)
                    .extracting(BiodataDetailsDTO::image)
                    .isEqualTo(image);
        });
    }

    @Test void mapDetails_ShouldReturnsNullOnFieldsWhenBiodataHaveNullsFields() {
        biodataModel.setFullName(null);
        biodataModel.setMobilePhone(null);

        BiodataDetailsDTO result = biodataMapper.mapDetails(biodataModel);

        SoftAssertions.assertSoftly(s -> {
            s.assertThat(result)
                    .extracting(BiodataDetailsDTO::baseProperties)
                    .extracting(BasePropertiesDTO::deletedBy)
                    .isNull();

            s.assertThat(result)
                    .extracting(BiodataDetailsDTO::baseProperties)
                    .extracting(BasePropertiesDTO::deletedOn)
                    .isNull();

            s.assertThat(result)
                    .extracting(BiodataDetailsDTO::fullName)
                    .isNull();

            s.assertThat(result)
                    .extracting(BiodataDetailsDTO::mobilePhone)
                    .isNull();
        });
    }

    @Test void mapDetails_ShouldReturnsNullWhenBiodataIsNull() {
        BiodataModel biodataModel1 = null;
        BiodataDetailsDTO mockNullBiodataDetailsDto = null;

        BiodataDetailsDTO result = biodataMapper.mapDetails(biodataModel1);

        assertThat(result)
                .isEqualTo(mockNullBiodataDetailsDto);
    }



}

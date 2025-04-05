package com.laqqueta.healthcare.mapper;

import com.laqqueta.healthcare.properties.mapper.BasePropertiesMapper;
import com.laqqueta.healthcare.role.RoleModel;
import com.laqqueta.healthcare.role.mapper.RoleDetailsMapper;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class RoleDetailMapperTests {

    @Test
    public void map_WhenRoleModelExists_ReturnsRoleDetailMapper() {
        // Arrange
        RoleModel actualRoleModel = new RoleModel(1L, "TEST ACTUAL ROLE", "TESTACTUALROLE");
        RoleDetailsMapper mockMappedModel =
                new RoleDetailsMapper(1L, "TEST ACTUAL ROLE", "TESTACTUALROLE", BasePropertiesMapper.initNull());

        // Act
        RoleDetailsMapper mappedRole = RoleDetailsMapper.map(actualRoleModel);

        // Assertions
        SoftAssertions.assertSoftly(s -> {
            s.assertThat(mappedRole)
                    .usingRecursiveComparison()
                    .comparingOnlyFields("id", "name", "code")
                    .isEqualTo(actualRoleModel);

            s.assertThat(mappedRole)
                    .isEqualTo(mockMappedModel);
        });
    }

    @Test
    public void map_WhenRoleModelIsNull_ReturnsNullOnRoleDetailMapper() {
        // Arrange
        RoleModel mockNullRoleModel = null;
        RoleDetailsMapper mockNullMapper = null;
        // Act
        RoleDetailsMapper mappedRole = RoleDetailsMapper.map(mockNullRoleModel);

        // Assertions
        Assertions.assertThat(mappedRole)
                .isEqualTo(mockNullMapper);


    }

    @Test
    public void map_WhenRoleModelIsEmptyObject_ReturnsEmptyObjectOnRoleDetailMapper() {
        RoleModel actualRoleModel = new RoleModel(null, null, null);
        RoleDetailsMapper mockEmptyObject = new RoleDetailsMapper(null, null, null, BasePropertiesMapper.initNull());

        RoleDetailsMapper mappedModel = RoleDetailsMapper.map(actualRoleModel);

        SoftAssertions.assertSoftly(s -> {
            s.assertThat(mappedModel)
                    .isEqualTo(mockEmptyObject);

            s.assertThat(mappedModel)
                    .usingRecursiveComparison()
                    .ignoringFields("baseProperties")
                    .isEqualTo(actualRoleModel);
        });
    }

}

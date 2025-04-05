package com.laqqueta.healthcare.mapper;

import com.laqqueta.healthcare.role.RoleModel;
import com.laqqueta.healthcare.role.mapper.RoleMapper;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class RoleMapperTests {

    @Test
    public void map_WhenRoleModelExists_ReturnsRoleMapper() {

        RoleModel actualModel = new RoleModel(1L, "ROLE TEST", "ROLETEST001");
        RoleMapper mockMappedModel = new RoleMapper(1L, "ROLE TEST", "ROLETEST001");

        RoleMapper mappedModel = RoleMapper.map(actualModel);

        SoftAssertions.assertSoftly(s -> {
            s.assertThat(mappedModel)
                    .usingRecursiveComparison()
                    .comparingOnlyFields("id", "name", "code")
                    .isEqualTo(actualModel);

            s.assertThat(mappedModel)
                    .isEqualTo(mockMappedModel);
        });
    }

    @Test
    public void map_WhenRoleModelNull_ReturnsNullOnCourierMapper() {
        // Arrange
        RoleModel actualRoleModel = null;
        // Act
        RoleMapper roleMapper = RoleMapper.map(actualRoleModel);
        // Assertions
        SoftAssertions.assertSoftly(s -> {
            s.assertThat(roleMapper).isNull();
            s.assertThat(roleMapper).usingRecursiveComparison()
                    .isEqualTo(actualRoleModel);
        });
    }

    @Test
    public void map_WhenRoleModelIsEmptyObject_ReturnsEmptyObjectOnCourierMapper() {
        RoleModel actualRoleModel = new RoleModel(null, null, null);
        RoleMapper mockEmptyMapper = new RoleMapper(null, null, null);

        RoleMapper mappedModel = RoleMapper.map(actualRoleModel);

        SoftAssertions.assertSoftly(s -> {
            s.assertThat(mappedModel).isEqualTo(mockEmptyMapper);
            s.assertThat(mappedModel).usingRecursiveComparison()
                    .isEqualTo(actualRoleModel);
        });
    }

    @Test
    public void map_WhenRoleModelHaveNullFields_ReturnNullOnCourierMapperNullFields() {
        RoleModel actualRoleModel = new RoleModel(1L, null, "ROLECODE");
        RoleMapper mockNullFields = new RoleMapper(1L, null, "ROLECODE");

        RoleMapper mappedModel = RoleMapper.map(actualRoleModel);

        SoftAssertions.assertSoftly(s -> {
            s.assertThat(mappedModel)
                    .isEqualTo(mockNullFields);

            s.assertThat(mappedModel)
                    .usingRecursiveComparison()
                    .isEqualTo(actualRoleModel);

            s.assertThat(mappedModel.name())
                    .isNull();
        });
    }

}

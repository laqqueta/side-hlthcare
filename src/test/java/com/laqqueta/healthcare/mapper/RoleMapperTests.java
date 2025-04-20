package com.laqqueta.healthcare.mapper;

import com.laqqueta.healthcare.role.RoleMapper;
import com.laqqueta.healthcare.role.RoleModel;
import com.laqqueta.healthcare.role.dto.RoleDTO;
import com.laqqueta.healthcare.role.dto.RoleDetailsDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class RoleMapperTests {

    private RoleMapper roleMapper;
    private RoleModel roleModel;
    private RoleDTO expectedDTO;
    private RoleDetailsDTO expectedDetailDTO;

    @BeforeEach
    void setUp() {
        roleMapper = Mappers.getMapper(RoleMapper.class);
        SetupBasePropertiesDtoData data = new SetupBasePropertiesDtoData();
        roleModel = new RoleModel();

        roleModel.setId(1L);
        roleModel.setName("Role Name");
        roleModel.setCode("ROLECODE");
        roleModel.setDeleted(false);
        roleModel.setCreatedBy(data.getCreatedBy());
        roleModel.setCreatedOn(data.getDate());
        roleModel.setModifiedBy(data.getModifiedBy());
        roleModel.setModifiedOn(data.getDate());

        expectedDTO = new RoleDTO(1L, "Role Name", "ROLECODE");
        expectedDetailDTO = new RoleDetailsDTO(1L, "Role Name", "ROLECODE", data.getBasePropertiesDTO());
    }

    @Test void map_ShouldMapRoleModelToRoleDTO() {

    }

    @Test void map_ShouldReturnsNullOnFieldsWhenRoleHaveNullsFields() {

    }

    @Test void map_ShouldReturnNullsWhenRoleModelIsNull() {

    }

    @Test void mapDetails_ShouldMapRoleModelToRoleDetailsDTO() {

    }

    @Test void mapDetails_ShouldReturnsNullOnFieldsWhenRoleHaveNullsFields() {

    }

    @Test void mapDetails_ShouldReturnsNullsWhenRoleModelIsNull() {

    }



}

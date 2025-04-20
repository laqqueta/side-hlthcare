package com.laqqueta.healthcare.mapper;

import com.laqqueta.healthcare.biodata.BiodataMapper;
import com.laqqueta.healthcare.biodata.BiodataModel;
import com.laqqueta.healthcare.role.RoleMapper;
import com.laqqueta.healthcare.role.RoleModel;
import com.laqqueta.healthcare.role.dto.RoleDTO;
import com.laqqueta.healthcare.user.UserMapper;
import com.laqqueta.healthcare.user.UserModel;
import com.laqqueta.healthcare.user.dto.UserDTO;
import com.laqqueta.healthcare.user.dto.UserDetailsDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

@ExtendWith(MockitoExtension.class)
public class UserMapperTests {

    private UserMapper userMapper;
    private UserModel userModel;
    private UserDTO expectedUserDTO;
    private UserDetailsDTO expectedUserDetailsDTO;

    @BeforeEach
    void setUp() {
        userMapper = Mappers.getMapper(UserMapper.class);
        userModel = new UserModel();
        SetupBasePropertiesDtoData data = new SetupBasePropertiesDtoData();

        RoleMapper roleMapper = Mappers.getMapper(RoleMapper.class);
        RoleModel role = new RoleModel();
        role.setId(99L);
        role.setName("User Role");
        role.setCode("USERROLECODE");

        BiodataMapper biodataMapper = Mappers.getMapper(BiodataMapper.class);
        BiodataModel biodata = new BiodataModel();
        biodata.setId(99L);
        biodata.setFullName("User");
        biodata.setMobilePhone("9999-9999-9999");
        biodata.setImage(new byte[] {9, 9, 9});
        biodata.setImagePath("user/path/image");

        userModel.setId(1L);
        userModel.setEmail("user@email.com");
        userModel.setRole(role);
        userModel.setBiodata(biodata);
        userModel.setDeleted(false);
        userModel.setCreatedBy(data.getCreatedBy());
        userModel.setCreatedOn(data.getDate());
        userModel.setModifiedBy(data.getModifiedBy());
        userModel.setModifiedOn(data.getDate());

        expectedUserDTO = new UserDTO(1L, "user@email.com", biodataMapper.map(biodata), roleMapper.map(role));
        expectedUserDetailsDTO = new UserDetailsDTO(1L, "user@email.com" ,false, LocalDateTime.now(), biodataMapper.map(biodata), roleMapper.map(role), data.getBasePropertiesDTO());
    }

    @Test void map_ShouldMapUserModelToUserDto() {
        
    }
    
    @Test void map_ShouldReturnsNullOnFieldsWhenUserHaveNullsFields() {

    }

    @Test void map_ShouldReturnNullsWhenUserModelIsNull() {

    }

    @Test void mapDetails_ShouldMapUserModelToUserDetailsDto() {

    }

    @Test void mapDetails_ShouldReturnsNullOnFieldsWhenUserHaveNullsFields() {

    }

    @Test void mapDetails_ShouldReturnsNullWhenUserModelIsNull() {

    }

}

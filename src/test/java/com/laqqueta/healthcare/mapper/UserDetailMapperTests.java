package com.laqqueta.healthcare.mapper;

import com.laqqueta.healthcare.biodata.BiodataModel;
import com.laqqueta.healthcare.biodata.mapper.BiodataMapper;
import com.laqqueta.healthcare.properties.mapper.BasePropertiesMapper;
import com.laqqueta.healthcare.role.RoleModel;
import com.laqqueta.healthcare.role.mapper.RoleMapper;
import com.laqqueta.healthcare.user.UserModel;
import com.laqqueta.healthcare.user.mapper.UserDetailMapper;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserDetailMapperTests {

    @Test
    public void map_WhenUserExists_ReturnsMappedUserDetail() {
        BiodataModel biodata = new BiodataModel(
                1L, "TEST BIDOATA", "0811111",
                new byte[]{11, 22, 33}, "Image Path");
        RoleModel role = new RoleModel(1L, "ROLE TEST", "ROLETEST001");
        UserModel actualUser = new UserModel(1L, "useremail@test.com", biodata, role);
        UserDetailMapper mockMappedUser = new UserDetailMapper(1L, "useremail@test.com",
                BiodataMapper.map(biodata), RoleMapper.map(role), BasePropertiesMapper.initNull());

        UserDetailMapper userDetailMapper = UserDetailMapper.map(actualUser);

        SoftAssertions.assertSoftly(s -> {
            s.assertThat(userDetailMapper)
                    .isEqualTo(mockMappedUser);

            s.assertThat(userDetailMapper)
                    .usingRecursiveComparison()
                    .comparingOnlyFields("id", "email")
                    .isEqualTo(actualUser);

            s.assertThat(userDetailMapper.biodata())
                    .usingRecursiveComparison()
                    .withStrictTypeChecking()
                    .isEqualTo(BiodataMapper.map(actualUser.getBiodata()));

            s.assertThat(userDetailMapper.role())
                    .usingRecursiveComparison()
                    .withStrictTypeChecking()
                    .isEqualTo(RoleMapper.map(actualUser.getRole()));
        });
    }

    @Test
    public void map_WhenUserIsNull_ReturnsNull() {
        UserModel actualUser = null;
        UserDetailMapper mockNullUser = null;

        UserDetailMapper mappedUser = UserDetailMapper.map(actualUser);

        Assertions.assertThat(mappedUser)
                .isEqualTo(mockNullUser);
    }

    @Test
    public void map_WhenUserIsEmptyObject_ReturnsEmptyObject() {
        UserModel actualUser = new UserModel();
        UserDetailMapper mockEmptyMappedUser = new UserDetailMapper(null, null, null, null,
                BasePropertiesMapper.initNull());

        UserDetailMapper mappedUser = UserDetailMapper.map(actualUser);

        SoftAssertions.assertSoftly(s -> {
            s.assertThat(mappedUser).isEqualTo(mockEmptyMappedUser);
            s.assertThat(mappedUser).usingRecursiveComparison()
                    .ignoringFields("baseProperties")
                    .isEqualTo(actualUser);
        });

    }

}

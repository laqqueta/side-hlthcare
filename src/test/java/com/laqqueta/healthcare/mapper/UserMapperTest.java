package com.laqqueta.healthcare.mapper;

import com.laqqueta.healthcare.biodata.BiodataModel;
import com.laqqueta.healthcare.biodata.mapper.BiodataMapper;
import com.laqqueta.healthcare.role.RoleModel;
import com.laqqueta.healthcare.role.mapper.RoleMapper;
import com.laqqueta.healthcare.user.UserModel;
import com.laqqueta.healthcare.user.mapper.UserMapper;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserMapperTest {

    @Test
    public void map_WhenUserModelExists_ReturnsUserMapper() {
        BiodataModel biodata = new BiodataModel(
                1L, "TEST BIDOATA", "0811111",
                new byte[]{11, 22, 33}, "Image Path");
        RoleModel role = new RoleModel(1L, "ROLE TEST", "ROLETEST001");
        UserModel actualUserModel = new UserModel(1L, "useremail@test.com", biodata, role);
        UserMapper mockMappedUser = new UserMapper(1L, "useremail@test.com", BiodataMapper.map(biodata), RoleMapper.map(role));

        UserMapper mappedUserModel = UserMapper.map(actualUserModel);

        SoftAssertions.assertSoftly(s -> {
            s.assertThat(mappedUserModel)
                    .usingRecursiveComparison()
                    .comparingOnlyFields("id", "email", "role", "biodata")
                    .isEqualTo(actualUserModel);

            s.assertThat(mappedUserModel)
                    .isEqualTo(mockMappedUser);
        });
    }

    @Test
    public void map_WhenUserModelIsNull_ReturnsNullOnUserMapper() {
        UserModel actualUserModel = null;
        UserMapper expectedMappedUser = null;

        UserMapper mappedUser = UserMapper.map(actualUserModel);

        Assertions.assertThat(mappedUser)
                .isEqualTo(expectedMappedUser);
    }

    @Test
    public void map_WhenUserModelIsEmpty_ReturnsEmptyObjectOnUserMapper() {
        UserModel actualUserModel = new UserModel(null, null, null, null);
        UserMapper expectedMappedUser = new UserMapper(null, null, null, null);

        UserMapper mappedUser = UserMapper.map(actualUserModel);

        SoftAssertions.assertSoftly(s -> {
            s.assertThat(mappedUser)
                    .isEqualTo(expectedMappedUser);

            s.assertThat(mappedUser)
                    .usingRecursiveComparison()
                    .isEqualTo(actualUserModel);
        });
    }

    @Test
    public void map_WhenUserModelHaveNullFields_ReturnsNullOnUserMapperFields() {
        UserModel actualUserModel = new UserModel(1L, "email", null, null);
        UserMapper expectedMappedUser = new UserMapper(1L, "email", null, null);

        UserMapper mappedUser = UserMapper.map(actualUserModel);

        SoftAssertions.assertSoftly(s -> {
            s.assertThat(mappedUser)
                    .isEqualTo(expectedMappedUser);

            s.assertThat(mappedUser)
                    .usingRecursiveComparison()
                    .isEqualTo(actualUserModel);

            s.assertThat(mappedUser)
                    .hasFieldOrPropertyWithValue("role", null)
                    .hasFieldOrPropertyWithValue("biodata", null);
        });
    }

}

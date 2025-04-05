package com.laqqueta.healthcare.mapper;

import com.laqqueta.healthcare.biodata.BiodataModel;
import com.laqqueta.healthcare.biodata.mapper.BiodataDetailsMapper;
import com.laqqueta.healthcare.properties.mapper.BasePropertiesMapper;
import com.laqqueta.healthcare.role.RoleModel;
import com.laqqueta.healthcare.role.mapper.RoleDetailsMapper;
import com.laqqueta.healthcare.user.UserModel;
import com.laqqueta.healthcare.user.mapper.UserDetailMapper;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

/**
 * Test only related components to BaseProperties
 * since most of models will extends BaseProperties class
 * <p>
 * Model will be use for test:
 * <ol>
 *     <li>User</li>
 *     <li>Biodata</li>
 *     <li>Role</li>
 * </ol>
 */
@ExtendWith(MockitoExtension.class)
public class BasePropertiesMapperTests {

    @Test
    public void map_WhenBasePropertiesExists_ReturnsBasePropertiesMapper() {
        RoleModel roleSuperAdmin = new RoleModel(1L, "Super Admin", "SUPADMIN");
        RoleModel roleAdmin = new RoleModel(2L, "Admin", "ADMIN");
        BiodataModel biodataSuperAdmin = new BiodataModel(1L, "Supa Admin", "9999",
                new byte[]{9, 9, 9}, "Image Path Supa Admin");
        BiodataModel biodataAdmin = new BiodataModel(1L, "Admin", "1111",
                new byte[]{1, 1, 1}, "Image Path Admin");
        UserModel createdBy = new UserModel(1L, "createduser@email.com", biodataSuperAdmin, roleSuperAdmin);
        UserModel modifiedBy = new UserModel(2L, "modifieduser@email.com", biodataAdmin, roleAdmin);
        UserModel deletedBy = new UserModel(3L, "deleteduser@email.com", biodataSuperAdmin, roleSuperAdmin);
        LocalDateTime now = LocalDateTime.now();

        UserModel actualUser = new UserModel();
        actualUser.setCreatedBy(createdBy);
        actualUser.setCreatedOn(now);
        actualUser.setModifiedBy(modifiedBy);
        actualUser.setModifiedOn(now);
        actualUser.setDeletedBy(deletedBy);
        actualUser.setDeletedOn(now);
        actualUser.setDeleted(false);

        RoleModel actualRole = new RoleModel();
        actualRole.setCreatedBy(createdBy);
        actualRole.setCreatedOn(now);
        actualRole.setModifiedBy(modifiedBy);
        actualRole.setModifiedOn(now);
        actualRole.setDeletedBy(deletedBy);
        actualRole.setDeletedOn(now);
        actualRole.setDeleted(false);

        BiodataModel actualBiodata = new BiodataModel();
        actualBiodata.setCreatedBy(createdBy);
        actualBiodata.setCreatedOn(now);
        actualBiodata.setModifiedBy(modifiedBy);
        actualBiodata.setModifiedOn(now);
        actualBiodata.setDeletedBy(deletedBy);
        actualBiodata.setDeletedOn(now);
        actualBiodata.setDeleted(false);

        UserDetailMapper actualMappedUserDetail = UserDetailMapper.map(actualUser);
        RoleDetailsMapper actualMappedRoleDetail = RoleDetailsMapper.map(actualRole);
        BiodataDetailsMapper actualMappedBiodataDetail = BiodataDetailsMapper.map(actualBiodata);

        BasePropertiesMapper mappedUserBaseProperties = BasePropertiesMapper.map(actualUser);
        BasePropertiesMapper mappedRoleBaseProperties = BasePropertiesMapper.map(actualRole);
        BasePropertiesMapper mappedBiodataBaseProperties = BasePropertiesMapper.map(actualBiodata);

        SoftAssertions.assertSoftly(s -> {
            s.assertThat(mappedUserBaseProperties)
                    .usingRecursiveComparison()
                    .comparingOnlyFieldsOfTypes(BasePropertiesMapper.class)
                    .withStrictTypeChecking()
                    .isEqualTo(actualMappedUserDetail.baseProperties());

            s.assertThat(mappedRoleBaseProperties)
                    .usingRecursiveComparison()
                    .comparingOnlyFieldsOfTypes(BasePropertiesMapper.class)
                    .withStrictTypeChecking()
                    .isEqualTo(actualMappedRoleDetail.baseProperties());

            s.assertThat(mappedBiodataBaseProperties)
                    .usingRecursiveComparison()
                    .comparingOnlyFieldsOfTypes(BasePropertiesMapper.class)
                    .withStrictTypeChecking()
                    .isEqualTo(actualMappedBiodataDetail.baseProperties());
        });
    }

    @Test
    public void map_WhenBasePropertiesIsNull_ReturnsNullOnBasePropertiesMapper() {
        UserModel actualUser = null;
        RoleModel actualRole = null;
        BiodataModel actualBiodata = null;

        BasePropertiesMapper mappedUserBaseProperties = BasePropertiesMapper.map(actualUser);
        BasePropertiesMapper mappedRoleBaseProperties = BasePropertiesMapper.map(actualRole);
        BasePropertiesMapper mappedBiodataBaseProperties = BasePropertiesMapper.map(actualBiodata);

        SoftAssertions.assertSoftly(s -> {
            s.assertThat(mappedUserBaseProperties).isNull();
            s.assertThat(mappedRoleBaseProperties).isNull();
            s.assertThat(mappedBiodataBaseProperties).isNull();
        });
    }

    @Test
    public void map_WhenBasePropertiesIsEmptyObject_ReturnsEmptyObjectOnBasePropertiesMapper() {
        // Arrange
        UserModel actualUser = new UserModel();
        RoleModel actualRole = new RoleModel();
        BiodataModel actualBiodata = new BiodataModel();
        BasePropertiesMapper mockNullBaseProperties = BasePropertiesMapper.initNull();

        // Arrange
        BasePropertiesMapper mappedUserBaseProperties = BasePropertiesMapper.map(actualUser);
        BasePropertiesMapper mappedRoleBaseProperties = BasePropertiesMapper.map(actualRole);
        BasePropertiesMapper mappedBiodataBaseProperties = BasePropertiesMapper.map(actualBiodata);

        // Assertions
        SoftAssertions.assertSoftly(s -> {
            s.assertThat(mappedUserBaseProperties)
                    .usingRecursiveComparison()
                    .comparingOnlyFieldsOfTypes(BasePropertiesMapper.class)
                    .withStrictTypeChecking()
                    .isEqualTo(mockNullBaseProperties);

            s.assertThat(mappedRoleBaseProperties)
                    .usingRecursiveComparison()
                    .comparingOnlyFieldsOfTypes(BasePropertiesMapper.class)
                    .withStrictTypeChecking()
                    .isEqualTo(mockNullBaseProperties);

            s.assertThat(mappedBiodataBaseProperties)
                    .usingRecursiveComparison()
                    .comparingOnlyFieldsOfTypes(BasePropertiesMapper.class)
                    .withStrictTypeChecking()
                    .isEqualTo(mockNullBaseProperties);
        });
    }

    @Test
    public void map_WhenBasePropertiesHaveNullFields_ReturnNullOnBasePropertiesMapperFields() {
        // Arrange
        RoleModel roleSuperAdmin = new RoleModel(1L, "Super Admin", "SUPADMIN");
        RoleModel roleAdmin = new RoleModel(2L, "Admin", "ADMIN");
        BiodataModel biodataSuperAdmin = new BiodataModel(1L, "Supa Admin", "9999",
                new byte[]{9, 9, 9}, "Image Path Supa Admin");
        BiodataModel biodataAdmin = new BiodataModel(1L, "Admin", "1111",
                new byte[]{1, 1, 1}, "Image Path Admin");
        UserModel createdBy = new UserModel(1L, "createduser@email.com", biodataSuperAdmin, roleSuperAdmin);
        UserModel modifiedBy = new UserModel(2L, "modifieduser@email.com", biodataAdmin, roleAdmin);
        UserModel deletedBy = new UserModel(3L, "deleteduser@email.com", biodataSuperAdmin, roleSuperAdmin);
        LocalDateTime now = LocalDateTime.now();

        UserModel actualUser = new UserModel();
        actualUser.setCreatedBy(createdBy);
        actualUser.setCreatedOn(now);
        actualUser.setModifiedBy(modifiedBy);
        actualUser.setModifiedOn(now);
        actualUser.setDeletedBy(null);
        actualUser.setDeletedOn(null);
        actualUser.setDeleted(false);

        RoleModel actualRole = new RoleModel();
        actualRole.setCreatedBy(createdBy);
        actualRole.setCreatedOn(now);
        actualRole.setModifiedBy(null);
        actualRole.setModifiedOn(null);
        actualRole.setDeletedBy(deletedBy);
        actualRole.setDeletedOn(now);
        actualRole.setDeleted(false);

        BiodataModel actualBiodata = new BiodataModel();
        actualBiodata.setCreatedBy(null);
        actualBiodata.setCreatedOn(null);
        actualBiodata.setModifiedBy(modifiedBy);
        actualBiodata.setModifiedOn(now);
        actualBiodata.setDeletedBy(deletedBy);
        actualBiodata.setDeletedOn(now);
        actualBiodata.setDeleted(false);

        UserDetailMapper actualMappedUserDetail = UserDetailMapper.map(actualUser);
        RoleDetailsMapper actualMappedRoleDetail = RoleDetailsMapper.map(actualRole);
        BiodataDetailsMapper actualMappedBiodataDetail = BiodataDetailsMapper.map(actualBiodata);

        // Act
        BasePropertiesMapper mappedUserBaseProperties = BasePropertiesMapper.map(actualUser);
        BasePropertiesMapper mappedRoleBaseProperties = BasePropertiesMapper.map(actualRole);
        BasePropertiesMapper mappedBiodataBaseProperties = BasePropertiesMapper.map(actualBiodata);

        // Assertions
        SoftAssertions.assertSoftly(s -> {

            s.assertThat(mappedUserBaseProperties)
                    .usingRecursiveComparison()
                    .withStrictTypeChecking()
                    .isEqualTo(actualMappedUserDetail.baseProperties());

            s.assertThat(mappedUserBaseProperties)
                    .hasFieldOrPropertyWithValue("deletedBy", null)
                    .hasFieldOrPropertyWithValue("deletedOn", null);

            s.assertThat(mappedRoleBaseProperties)
                    .usingRecursiveComparison()
                    .withStrictTypeChecking()
                    .isEqualTo(actualMappedRoleDetail.baseProperties());

            s.assertThat(mappedRoleBaseProperties)
                    .hasFieldOrPropertyWithValue("modifiedBy", null)
                    .hasFieldOrPropertyWithValue("modifiedOn", null);

            s.assertThat(mappedBiodataBaseProperties)
                    .usingRecursiveComparison()
                    .withStrictTypeChecking()
                    .isEqualTo(actualMappedBiodataDetail.baseProperties());

            s.assertThat(mappedBiodataBaseProperties)
                    .hasFieldOrPropertyWithValue("createdBy", null)
                    .hasFieldOrPropertyWithValue("createdOn", null);

        });
    }

}

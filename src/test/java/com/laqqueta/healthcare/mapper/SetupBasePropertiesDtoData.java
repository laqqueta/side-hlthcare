package com.laqqueta.healthcare.mapper;

import com.laqqueta.healthcare.biodata.BiodataModel;
import com.laqqueta.healthcare.biodata.dto.BiodataDTO;
import com.laqqueta.healthcare.properties.BasePropertiesDTO;
import com.laqqueta.healthcare.role.RoleModel;
import com.laqqueta.healthcare.role.dto.RoleDTO;
import com.laqqueta.healthcare.user.UserModel;
import com.laqqueta.healthcare.user.dto.UserDTO;

import java.time.LocalDateTime;
import java.util.Locale;

public class SetupBasePropertiesDtoData {
    private BasePropertiesDTO basePropertiesDTO;
    private UserModel createdBy;
    private UserModel modifiedBy;
    private LocalDateTime date;

    private byte[] imageCreate = new byte[] {1,2,3};
    private byte[] imageModify = new byte[] {2,3,4};

    public SetupBasePropertiesDtoData() {
        this.date = LocalDateTime.now();
        var created = userDto(1L, "Super Admin", "9999-9999-9999", imageCreate);
        var modified = userDto(2L, "Admin", "1111-1111-1111", imageModify);

        this.basePropertiesDTO = new BasePropertiesDTO(false,
                created, date,
                modified, date,
                null, null);

        this.createdBy = userModel(1L, "Super Admin", "9999-9999-9999", imageCreate);
        this.modifiedBy = userModel(2L, "Admin", "1111-1111-1111", imageModify);
    }

    public BasePropertiesDTO getBasePropertiesDTO() {
        return basePropertiesDTO;
    }

    public UserModel getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserModel createdBy) {
        this.createdBy = createdBy;
    }

    public UserModel getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(UserModel modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    private UserDTO userDto(Long id, String name, String phone, byte[] image) {
        RoleDTO role = new RoleDTO(id, name, name.replaceAll(" ", "").toUpperCase(Locale.ROOT));
        BiodataDTO biodata = new BiodataDTO(id, name, phone,
                image, name.replaceAll(" ", "").toLowerCase(Locale.ROOT)+"/image/path");
        return new UserDTO(id, name.replaceAll(" ", "")+"@email.com", biodata, role);
    }

    private UserModel userModel(Long id, String name, String phone, byte[] image) {
        RoleModel role = new RoleModel();
        role.setId(id);
        role.setName(name);
        role.setCode(name.replaceAll(" ", "").toUpperCase(Locale.ROOT));

        BiodataModel biodata = new BiodataModel();
        biodata.setId(id);
        biodata.setFullName(name);
        biodata.setMobilePhone(phone);
        biodata.setImage(image);
        biodata.setImagePath(name.replaceAll(" ", "").toLowerCase(Locale.ROOT)+"/image/path");

        UserModel user = new UserModel();
        user.setId(id);
        user.setEmail(name.replaceAll(" ", "")+"@email.com");
        user.setRole(role);
        user.setBiodata(biodata);

        return user;
    }
}

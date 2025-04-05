package com.laqqueta.healthcare.user.mapper;

import com.laqqueta.healthcare.biodata.mapper.BiodataMapper;
import com.laqqueta.healthcare.properties.mapper.BasePropertiesMapper;
import com.laqqueta.healthcare.role.mapper.RoleMapper;
import com.laqqueta.healthcare.user.UserModel;

public record UserDetailMapper(Long id, String email, BiodataMapper biodata, RoleMapper role,
                               BasePropertiesMapper baseProperties) {

    public static UserDetailMapper map(UserModel userModel) {
        if (userModel == null) return null;

        return new UserDetailMapper(
                userModel.getId(), userModel.getEmail(),
                BiodataMapper.map(userModel.getBiodata()), RoleMapper.map(userModel.getRole()),
                BasePropertiesMapper.map(userModel));
    }

}

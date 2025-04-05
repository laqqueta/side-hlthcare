package com.laqqueta.healthcare.user.mapper;

import com.laqqueta.healthcare.biodata.mapper.BiodataMapper;
import com.laqqueta.healthcare.role.mapper.RoleMapper;
import com.laqqueta.healthcare.user.UserModel;

public record UserMapper(Long id, String email, BiodataMapper biodata, RoleMapper role) {

    public static UserMapper map(UserModel user) {
        if (user == null) return null;

        return new UserMapper(
                user.getId(), user.getEmail(),
                BiodataMapper.map(user.getBiodata()),
                RoleMapper.map(user.getRole())
        );
    }

}

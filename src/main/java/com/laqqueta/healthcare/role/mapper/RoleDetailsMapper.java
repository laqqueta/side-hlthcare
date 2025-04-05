package com.laqqueta.healthcare.role.mapper;

import com.laqqueta.healthcare.properties.mapper.BasePropertiesMapper;
import com.laqqueta.healthcare.role.RoleModel;

public record RoleDetailsMapper(Long id, String name, String code, BasePropertiesMapper baseProperties) {

    public static RoleDetailsMapper map(RoleModel roleModel) {
        if (roleModel == null) return null;

        return new RoleDetailsMapper(
                roleModel.getId(), roleModel.getName(), roleModel.getCode(),
                BasePropertiesMapper.map(roleModel));
    }

}

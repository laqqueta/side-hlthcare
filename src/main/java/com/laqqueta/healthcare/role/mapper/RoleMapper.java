package com.laqqueta.healthcare.role.mapper;

import com.laqqueta.healthcare.role.RoleModel;

public record RoleMapper(Long id, String name, String code) {

    public static RoleMapper map(RoleModel role) {
        if (role == null) return null;

        return new RoleMapper(
                role.getId(), role.getName(), role.getCode()
        );
    }

}

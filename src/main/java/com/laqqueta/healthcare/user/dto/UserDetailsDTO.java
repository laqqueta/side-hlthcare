package com.laqqueta.healthcare.user.dto;

import com.laqqueta.healthcare.biodata.dto.BiodataDTO;
import com.laqqueta.healthcare.properties.BasePropertiesDTO;
import com.laqqueta.healthcare.role.dto.RoleDTO;

import java.time.LocalDateTime;

public record UserDetailsDTO(
        Long id, String email, Boolean locked, LocalDateTime lastLogin,
        BiodataDTO biodata, RoleDTO role, BasePropertiesDTO baseProperties) { }

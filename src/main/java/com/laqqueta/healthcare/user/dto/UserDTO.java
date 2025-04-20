package com.laqqueta.healthcare.user.dto;

import com.laqqueta.healthcare.biodata.dto.BiodataDTO;
import com.laqqueta.healthcare.role.dto.RoleDTO;

public record UserDTO(Long id, String email, BiodataDTO biodata, RoleDTO role) {
}

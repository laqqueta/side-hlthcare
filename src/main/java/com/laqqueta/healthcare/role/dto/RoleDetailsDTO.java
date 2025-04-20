package com.laqqueta.healthcare.role.dto;

import com.laqqueta.healthcare.properties.BaseProperties;
import com.laqqueta.healthcare.properties.BasePropertiesDTO;

public record RoleDetailsDTO(Long id, String name, String code, BasePropertiesDTO baseProperties) {
}

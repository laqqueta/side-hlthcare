package com.laqqueta.healthcare.biodata.dto;

import com.laqqueta.healthcare.properties.BasePropertiesDTO;

public record BiodataDetailsDTO(Long id, String fullName, String mobilePhone, byte[] image, String imagePath,
                                BasePropertiesDTO baseProperties) {
}

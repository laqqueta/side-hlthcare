package com.laqqueta.healthcare.biodata.dto;

public record BiodataDTO(Long id, String fullName, String mobilePhone, byte[] image, String imagePath) {
}

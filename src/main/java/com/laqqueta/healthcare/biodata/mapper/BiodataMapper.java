package com.laqqueta.healthcare.biodata.mapper;

import com.laqqueta.healthcare.biodata.BiodataModel;

public record BiodataMapper(
        Long id, String fullName, String mobilePhone,
        byte[] image, String imagePath
) {

    public static BiodataMapper map(BiodataModel biodata) {
        if (biodata == null) return null;

        return new BiodataMapper(
                biodata.getId(), biodata.getFullName(), biodata.getMobilePhone(),
                biodata.getImage(), biodata.getImagePath()
        );
    }

}

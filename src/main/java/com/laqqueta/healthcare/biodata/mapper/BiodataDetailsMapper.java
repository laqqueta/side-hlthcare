package com.laqqueta.healthcare.biodata.mapper;

import com.laqqueta.healthcare.biodata.BiodataModel;
import com.laqqueta.healthcare.properties.mapper.BasePropertiesMapper;

public record BiodataDetailsMapper(Long id, String fullName, String mobilePhone,
                                   byte[] image, String imagePath, BasePropertiesMapper baseProperties) {

    public static BiodataDetailsMapper map(BiodataModel biodataModel) {
        if (biodataModel == null) return null;

        return new BiodataDetailsMapper(
                biodataModel.getId(), biodataModel.getFullName(), biodataModel.getMobilePhone(),
                biodataModel.getImage(), biodataModel.getImagePath(), BasePropertiesMapper.map(biodataModel));
    }

}

package com.laqqueta.healthcare.properties.mapper;

import com.laqqueta.healthcare.properties.BaseProperties;
import com.laqqueta.healthcare.properties.BasePropertyDateType;
import com.laqqueta.healthcare.user.mapper.UserMapper;

import java.time.LocalDateTime;

public record BasePropertiesMapper(Boolean deleted,
                                   UserMapper createdBy, LocalDateTime createdOn,
                                   UserMapper modifiedBy, LocalDateTime modifiedOn,
                                   UserMapper deletedBy, LocalDateTime deletedOn) {

    public static <T extends BaseProperties> BasePropertiesMapper map(T baseProps) {
        if (baseProps == null) return null;

        return new BasePropertiesMapper(baseProps.isDeleted(),
                UserMapper.map(baseProps.getCreatedBy()), date(baseProps, BasePropertyDateType.CREATED_ON),
                UserMapper.map(baseProps.getModifiedBy()), date(baseProps, BasePropertyDateType.MODIFIED_ON),
                UserMapper.map(baseProps.getDeletedBy()), date(baseProps, BasePropertyDateType.DELETED_ON));
    }

    private static <T extends BaseProperties> LocalDateTime date(T model, BasePropertyDateType type) {
        if (model == null) return null;

        return switch (type) {
            case CREATED_ON -> model.getCreatedOn();
            case MODIFIED_ON -> model.getModifiedOn();
            case DELETED_ON -> model.getDeletedOn();
        };
    }

    /**
     * Method helper for test that require BaseProperties 
     */
    public static BasePropertiesMapper initNull() {
        return new BasePropertiesMapper(null,
                null, null,
                null, null,
                null, null);
    }

}

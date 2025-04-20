package com.laqqueta.healthcare.properties;

import com.laqqueta.healthcare.user.dto.UserDTO;

import java.time.LocalDateTime;

public record BasePropertiesDTO(Boolean deleted,
                                UserDTO createdBy, LocalDateTime createdOn,
                                UserDTO modifiedBy, LocalDateTime modifiedOn,
                                UserDTO deletedBy, LocalDateTime deletedOn) {
}

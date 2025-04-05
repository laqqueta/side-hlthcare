package com.laqqueta.healthcare.util.error;

import java.time.LocalDateTime;

public record ErrorMessage(String message, String exception, LocalDateTime timestamp) {
}

package com.laqqueta.healthcare.util.mapper;

public interface RequestMapper<M, R> {
    M mapRequest(R requestPayload);
}

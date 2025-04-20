package com.laqqueta.healthcare.util.mapper;

public interface BasicMapper<M, DTO, DDTO> {
    DTO map(M model);
    DDTO mapDetails(M model);
    M mapModel(DTO dto);
}

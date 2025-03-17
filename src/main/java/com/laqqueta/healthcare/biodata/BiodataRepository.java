package com.laqqueta.healthcare.biodata;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BiodataRepository extends JpaRepository<BiodataModel, Long> {
    Optional<BiodataModel> findByIdAndDeletedIsFalse(Long id);
}

package com.laqqueta.healthcare.courier;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourierRepository extends JpaRepository<CourierModel, Long> {

    Optional<CourierModel> findByIdAndDeleted(Long id, boolean deleted);

    Page<CourierModel> findAllByDeleted(boolean deleted, Pageable pageable);

}

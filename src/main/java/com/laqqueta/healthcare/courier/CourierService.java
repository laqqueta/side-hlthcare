package com.laqqueta.healthcare.courier;

import com.laqqueta.healthcare.courier.dto.CourierDTO;
import com.laqqueta.healthcare.courier.dto.CourierDetailDTO;
import com.laqqueta.healthcare.courier.dto.CourierRequestDTO;
import com.laqqueta.healthcare.courier.mapper.CourierMapper;
import com.laqqueta.healthcare.user.UserModel;
import com.laqqueta.healthcare.user.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CourierService {

    private final CourierRepository courierRepository;
    private final UserRepository userRepository;
    private final CourierMapper mapper;

    @Autowired
    public CourierService(CourierRepository courierRepository, UserRepository userRepository, CourierMapper mapper) {
        this.courierRepository = courierRepository;
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    public CourierDTO getById(Long id) {
        Optional<CourierModel> courier = courierRepository.findByIdAndDeleted(id, false);

        if (courier.isEmpty())
            throw new EntityNotFoundException("Courier with id %s doesn't exists".formatted(id));

        return mapper.map(courier.get());
    }

    public CourierDetailDTO getDetailedById(Long id) {
        Optional<CourierModel> courier = courierRepository.findByIdAndDeleted(id, false);

        if (courier.isEmpty())
            throw new EntityNotFoundException("Courier with id %s doesn't exists".formatted(id));

        return mapper.mapDetails(courier.get());
    }

    @Transactional
    public CourierDTO createCourier(CourierRequestDTO courier) {
        Optional<UserModel> user = userRepository.findByIdAndDeleted(courier.createBy(), false);

        if (user.isEmpty())
            throw new EntityNotFoundException("User with id %s doesn't exists".formatted(courier.createBy()));

        CourierModel model = mapper.mapRequest(courier);

        model.setCreatedBy(user.get());
        model.setCreatedOn(LocalDateTime.now());
        model.setDeleted(false);

        return mapper.map(
                courierRepository.save(model));
    }

    @Transactional
    public CourierDTO updateCourier(CourierRequestDTO courierPayload) {
        Optional<UserModel> user = userRepository.findByIdAndDeleted(courierPayload.modifiedBy(), false);

        if (user.isEmpty())
            throw new EntityNotFoundException("User with id %s doesn't exists".formatted(courierPayload.modifiedBy()));

        Optional<CourierModel> courier = courierRepository.findByIdAndDeleted(courierPayload.id(), false);

        if (courier.isEmpty())
            throw new EntityNotFoundException("Courier with id %s doesn't exists".formatted(courierPayload.id()));

        CourierModel model = courier.get();

        model.setName(courierPayload.name());
        model.setModifiedBy(user.get());
        model.setModifiedOn(LocalDateTime.now());

        return mapper.map(
                courierRepository.save(model));
    }

    @Transactional
    public void deleteCourier(CourierRequestDTO courierPayload) {
        Optional<UserModel> user = userRepository.findByIdAndDeleted(courierPayload.deletedBy(), false);

        if (user.isEmpty())
            throw new EntityNotFoundException("User with id %s doesn't exists".formatted(courierPayload.deletedBy()));

        Optional<CourierModel> courier = courierRepository.findByIdAndDeleted(courierPayload.id(), false);

        if (courier.isEmpty())
            throw new EntityNotFoundException("Courier with id %s doesn't exists".formatted(courierPayload.id()));

        CourierModel model = courier.get();

        model.setDeletedBy(user.get());
        model.setDeletedOn(LocalDateTime.now());
        model.setDeleted(true);

        courierRepository.save(model);
    }

    public Page<CourierDTO> getAllCourier(Pageable pageable) {
        Page<CourierModel> couriers = courierRepository.findAllByDeleted(false, pageable);
        return couriers.map(mapper::map);
    }
}

package com.laqqueta.healthcare.courier;

import com.laqqueta.healthcare.courier.mapper.CourierDetailMapper;
import com.laqqueta.healthcare.courier.mapper.CourierMapper;
import com.laqqueta.healthcare.courier.mapper.CourierRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/courier")
public class CourierController {

    private final CourierService courierService;

    public CourierController(CourierService courierService) {
        this.courierService = courierService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCourierById(@PathVariable Long id) {
        CourierMapper courier = courierService.getById(id);

        return new ResponseEntity<>(
                courier, HttpStatus.OK);
    }

    @GetMapping("/{id}/detail")
    public ResponseEntity<?> getDetailCourierById(@PathVariable Long id) {
        CourierDetailMapper courier = courierService.getDetailedById(id);

        return new ResponseEntity<>(
                courier, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveCourier(@RequestBody CourierRequest courierRequest) {
        CourierMapper savedCourier = courierService.createCourier(courierRequest);

        return new ResponseEntity<>(
                savedCourier, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> updateCourier(@RequestBody CourierRequest courierRequest) {
        CourierMapper updatedCourier = courierService.updateCourier(courierRequest);

        return new ResponseEntity<>(
                updatedCourier, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteCourier(@RequestBody CourierRequest courierRequest) {
        courierService.deleteCourier(courierRequest);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}

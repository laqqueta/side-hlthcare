package com.laqqueta.healthcare.courier;

import com.laqqueta.healthcare.courier.dto.CourierDTO;
import com.laqqueta.healthcare.courier.dto.CourierDetailDTO;
import com.laqqueta.healthcare.courier.dto.CourierRequestDTO;
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
        CourierDTO courier = courierService.getById(id);

        return new ResponseEntity<>(
                courier, HttpStatus.OK);
    }

    @GetMapping("/{id}/detail")
    public ResponseEntity<?> getDetailCourierById(@PathVariable Long id) {
        CourierDetailDTO courier = courierService.getDetailedById(id);

        return new ResponseEntity<>(
                courier, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveCourier(@RequestBody CourierRequestDTO courierRequest) {
        CourierDTO savedCourier = courierService.createCourier(courierRequest);

        return new ResponseEntity<>(
                savedCourier, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> updateCourier(@RequestBody CourierRequestDTO courierRequest) {
        CourierDTO updatedCourier = courierService.updateCourier(courierRequest);

        return new ResponseEntity<>(
                updatedCourier, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteCourier(@RequestBody CourierRequestDTO courierRequest) {
        courierService.deleteCourier(courierRequest);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}

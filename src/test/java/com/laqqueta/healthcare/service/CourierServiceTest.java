package com.laqqueta.healthcare.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CourierServiceTest {

//    private final long ID = 1;
//    private final boolean DELETED_STATUS = false;
//    @Mock
//    private CourierRepository courierRepository;
//    @InjectMocks
//    private CourierService courierService;
//
//    @Test
//    public void getCourierById_WhenExists_ReturnsCourier() {
//        CourierModel expectedCourier = new CourierModel(ID, "TEST COURIER");
//        given(courierRepository.findByIdAndDeleted(ID, DELETED_STATUS))
//                .willReturn(Optional.of(expectedCourier));
//
//        CourierMapper courier = courierService.getById(ID);
//
//        assertThat(courier)
//                .usingRecursiveComparison()
//                .comparingOnlyFields("id", "name")
//                .isEqualTo(expectedCourier);
//
//        then(courierRepository).should()
//                .findByIdAndDeleted(ID, DELETED_STATUS);
//    }
//
//    @Test
//    public void getCourierById_WhenDoesntExists_ThrowError() {
//        long nonExistsCourier = -1;
//        given(courierRepository.findByIdAndDeleted(nonExistsCourier, DELETED_STATUS))
//                .willReturn(Optional.empty());
//
//        assertThatThrownBy(() -> courierService.getById(nonExistsCourier))
//                .isInstanceOf(EntityNotFoundException.class)
//                .hasMessage("Courier with id %s doesn't exists".formatted(nonExistsCourier));
//
//        then(courierRepository).should().findByIdAndDeleted(nonExistsCourier, DELETED_STATUS);
//    }
//
//    @Test
//    public void getCourierDetailById_WhenCourierExists_ReturnsDetailedResponse() {
//        RoleModel roleSuperAdmin = new RoleModel(1L, "Super Admin", "SUPADMIN");
//        BiodataModel biodataSuperAdmin = new BiodataModel(1L, "Supa Admin", "9999",
//                new byte[]{9, 9, 9}, "Image Path Supa Admin");
//        UserModel createdBy = new UserModel(1L, "createduser@email.com", biodataSuperAdmin, roleSuperAdmin);
//        UserModel modifiedBy = new UserModel(2L, "modifieduser@email.com", biodataSuperAdmin, roleSuperAdmin);
//        UserModel deletedBy = new UserModel(3L, "deleteduser@email.com", biodataSuperAdmin, roleSuperAdmin);
//        LocalDateTime now = LocalDateTime.now();
//        CourierModel mockActualCourier = new CourierModel(1L, "courier 1");
//        mockActualCourier.setDeleted(false);
//        mockActualCourier.setCreatedBy(createdBy);
//        mockActualCourier.setCreatedOn(now);
//        mockActualCourier.setModifiedBy(modifiedBy);
//        mockActualCourier.setModifiedOn(now);
//        mockActualCourier.setDeletedBy(deletedBy);
//        mockActualCourier.setDeletedOn(now);
//
//        BasePropertiesMapper mockBaseProperties = new BasePropertiesMapper(false,
//                UserMapper.map(mockActualCourier.getCreatedBy()), now,
//                UserMapper.map(mockActualCourier.getModifiedBy()), now,
//                UserMapper.map(mockActualCourier.getDeletedBy()), now);
//
//        given(courierRepository.findByIdAndDeleted(ID, DELETED_STATUS))
//                .willReturn(Optional.of(mockActualCourier));
//
//        CourierDetailMapper mappedUser = courierService.getDetailedById(ID);
//
//        SoftAssertions.assertSoftly(s -> {
//            s.assertThat(mappedUser).usingRecursiveComparison()
//                    .comparingOnlyFields("id", "name")
//                    .isEqualTo(mockActualCourier);
//
//            s.assertThat(mappedUser.baseProperties())
//                    .usingRecursiveComparison()
//                    .comparingOnlyFieldsOfTypes(BasePropertiesMapper.class)
//                    .withStrictTypeChecking()
//                    .isEqualTo(mockBaseProperties);
//        });
//
//        then(courierRepository).should()
//                .findByIdAndDeleted(ID, DELETED_STATUS);
//    }
//
//    @Test
//    public void getAllCourier_ReturnsPaginatedResponse() {
//        List<CourierModel> mockCourier = List.of(
//                new CourierModel(1L, "Courier 1"),
//                new CourierModel(2L, "Courier 2"),
//                new CourierModel(3L, "Courier 3")
//        );
//        Pageable pageable = PageRequest.of(0, 10);
//        Page<CourierModel> mockPage = new PageImpl<>(mockCourier, pageable, mockCourier.size());
//
//        given(courierRepository.findAllByDeleted(DELETED_STATUS, pageable))
//                .willReturn(mockPage);
//
//        Page<CourierMapper> actualPage = courierService.getAllCourier(pageable);
//
//        SoftAssertions.assertSoftly(s -> {
//            s.assertThat(actualPage.getTotalElements()).isEqualTo(mockCourier.size());
//            s.assertThat(actualPage.getTotalPages()).isEqualTo(1);
//            s.assertThat(actualPage.getNumber()).isEqualTo(0);
//            s.assertThat(actualPage.getContent())
//                    .hasSize(mockCourier.size())
//                    .containsExactlyElementsOf(mockCourier.stream()
//                            .map(CourierMapper::map)
//                            .toList());
//        });
//
//        then(courierRepository).should().findAllByDeleted(DELETED_STATUS, pageable);
//    }
//
//    @Test
//    public void getAllCourier_WithSorting_ReturnsSortedPagination() {
//        List<CourierModel> mockCourier = List.of(
//                new CourierModel(3L, "Courier 3"),
//                new CourierModel(1L, "Courier 1"),
//                new CourierModel(2L, "Courier 2")
//        );
//        Pageable pageable = PageRequest.of(0, 10, Sort.by("id").ascending());
//        Page<CourierModel> mockPage = new PageImpl<>(mockCourier, pageable, mockCourier.size());
//
//        given(courierRepository.findAllByDeleted(DELETED_STATUS, pageable))
//                .willReturn(mockPage);
//
//        Page<CourierMapper> actualPage = courierService.getAllCourier(pageable);
//
//        SoftAssertions.assertSoftly(s -> {
//            s.assertThat(actualPage.getSort().isSorted()).isTrue();
//            s.assertThat(actualPage.getContent())
//                    .containsExactlyInAnyOrderElementsOf(mockCourier.stream()
//                            .map(CourierMapper::map)
//                            .toList());
//        });
//
//        then(courierRepository).should().findAllByDeleted(DELETED_STATUS, pageable);
//    }
//
//    @Test
//    public void getAllCourier_WhenEmpty_ReturnsEmptyPagination() {
//        Pageable pageable = PageRequest.of(0, 10);
//        Page<CourierModel> mockPage = new PageImpl<>(List.of(), pageable, 0);
//
//        given(courierRepository.findAllByDeleted(DELETED_STATUS, pageable))
//                .willReturn(mockPage);
//
//        Page<CourierMapper> actualPage = courierService.getAllCourier(pageable);
//
//        SoftAssertions.assertSoftly(s -> {
//            s.assertThat(actualPage.getTotalElements()).isEqualTo(0);
//            s.assertThat(actualPage.getTotalPages()).isEqualTo(0);
//            s.assertThat(actualPage.getNumber()).isEqualTo(0);
//            s.assertThat(actualPage.getContent()).isEmpty();
//        });
//
//        then(courierRepository).should().findAllByDeleted(DELETED_STATUS, pageable);
//    }

}

package com.laqqueta.healthcare.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@Transactional
public class CourierControllerTests {

    private final long COURIER_ID = 1;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

//    @Test
//    public void testGetCourierById() throws Exception {
//        mvc.perform(get("/api/courier/{id}", COURIER_ID))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.id").value(COURIER_ID))
//                .andExpect(jsonPath("$.name").value("test"))
//                .andDo(print());
//    }
//
//    @Test
//    public void testGetDetailCourierById() throws Exception {
//        mvc.perform(get("/api/courier/{id}/detail", COURIER_ID))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.id").value(COURIER_ID))
//                .andExpect(jsonPath("$.name").value("test"))
//                .andExpect(jsonPath("$.isDeleted").value(false))
//                .andExpect(jsonPath("$.createdBy").exists())
//                .andExpect(jsonPath("$.createdOn").exists())
//                .andExpect(jsonPath("$.modifiedBy").exists())
//                .andExpect(jsonPath("$.modifiedOn").exists())
//                .andExpect(jsonPath("$.deletedBy").exists())
//                .andExpect(jsonPath("$.deletedOn").exists());
//    }
//
//    @Test
//    public void testPostCourier() throws Exception {
//        CourierRequest request = new CourierRequest(null, "TESTING POST", 1L, null, null);
//
//        mvc.perform(post("/api/courier")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(request)))
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("$.name").value("TESTING POST"))
//                .andDo(print());
//    }

}

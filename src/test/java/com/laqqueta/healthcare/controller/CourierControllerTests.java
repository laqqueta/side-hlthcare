package com.laqqueta.healthcare.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@Transactional
public class CourierControllerTests {

    private final long COURIER_ID = 10;

    @Autowired
    private MockMvc mvc;

    @Test
    public void testGetCourierById() throws Exception {
        mvc.perform(get("/api/courier/{id}", COURIER_ID))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(COURIER_ID))
                .andExpect(jsonPath("$.name").value("TEST DATA"));
    }

    @Test
    public void testGetDetailCourierById() throws Exception {
        mvc.perform(get("/api/courier/{id}/detail", COURIER_ID))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(COURIER_ID))
                .andExpect(jsonPath("$.name").value("TEST DATA"))
                .andExpect(jsonPath("$.baseProperties.deleted").value(false))
                .andExpect(jsonPath("$.baseProperties.createdBy").exists())
                .andExpect(jsonPath("$.baseProperties.createdOn").exists())
                .andExpect(jsonPath("$.baseProperties.modifiedBy").exists())
                .andExpect(jsonPath("$.baseProperties.modifiedOn").exists())
                .andExpect(jsonPath("$.baseProperties.deletedBy").doesNotExist())
                .andExpect(jsonPath("$.baseProperties.deletedOn").doesNotExist());
    }
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

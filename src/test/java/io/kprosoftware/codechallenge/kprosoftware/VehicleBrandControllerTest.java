package io.kprosoftware.codechallenge.kprosoftware;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.kprosoftware.codechallenge.entity.VehicleBrand;
import io.kprosoftware.codechallenge.enum_.PriceSegment;

@SpringBootTest
public class VehicleBrandControllerTest {

  @Autowired
  private WebApplicationContext wac;
  MockMvc mockMvc;

  @BeforeEach
  public void setup() {
    mockMvc = MockMvcBuilders
        .webAppContextSetup(wac)
        .build();
  }

  @Test
  public void addVehicleBrandShouldReturnStatusCodeCeated() throws Exception {
    VehicleBrand toyota = new VehicleBrand();
    toyota.setId(1L);
    toyota.setName("Toyota");
    toyota.setPriceSegment(PriceSegment.Low);

    mockMvc.perform(post("/VehicleBrand")
        .content(asJsonString(toyota))
        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated())
        .andExpect(content().contentType("application/json"));
  }

  public static String asJsonString(final Object obj) {
    try {
      return new ObjectMapper().writeValueAsString(obj);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

}

package io.kprosoftware.codechallenge.kprosoftware;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import io.kprosoftware.codechallenge.controller.ModelController;
import io.kprosoftware.codechallenge.controller.VehicleBrandController;

@SpringBootTest
class KprosoftwareApplicationTests {

	@Autowired
	private VehicleBrandController vehicleBrandController;
	@Autowired
	private ModelController modelController;

	@Test
	void contextLoads() {
		assertThat(vehicleBrandController).isNotNull();
		assertThat(modelController).isNotNull();
	}

}

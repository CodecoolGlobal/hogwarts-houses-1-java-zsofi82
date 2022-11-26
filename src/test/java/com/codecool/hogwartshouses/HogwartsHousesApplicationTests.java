package com.codecool.hogwartshouses;

import com.codecool.hogwartshouses.controller.GreetingController;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HogwartsHousesApplicationTests {
	@Autowired
	private GreetingController controller;
	@Test
	public void contextLoads() throws Exception{
		assertThat(controller).isNotNull();
	}

}

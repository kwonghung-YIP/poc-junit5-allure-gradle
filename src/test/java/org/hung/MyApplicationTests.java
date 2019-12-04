package org.hung;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;

import io.qameta.allure.Allure;

@SpringBootTest
class MyApplicationTests {

	@Test
	void contextLoads() {
	}

	@RepeatedTest(value = 10)
	void repeatedTest(RepetitionInfo testInfo) {		
		assertEquals(0,testInfo.getCurrentRepetition()%2);
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"John","Peter","Mary"})
	@DisplayName("Parameter test")
	@Description("Parameter test [desc] for Allure")
	void parameterTest(String name) {
		Allure.attachment("name", name);
		assertEquals("John", name);		
	}
}

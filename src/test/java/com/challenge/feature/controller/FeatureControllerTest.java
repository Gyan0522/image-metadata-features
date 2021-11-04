package com.challenge.feature.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.challenge.feature.dto.FeatureResponseDTO;
import com.challenge.feature.test.AbstractTest;

/**
 * Test Class for FeatureController and endpoints.
 */
public class FeatureControllerTest extends AbstractTest {

	/**
	 * Test for the "/features" endpoint.
	 * 
	 * @throws Exception
	 */
	@Test
	public void listAllFeaturesTest() throws Exception {
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/features")).andReturn();
		assertEquals(result.getResponse().getStatus(), HttpStatus.OK.value());

		FeatureResponseDTO[] responseArray = jsonMapper.readValue(result.getResponse().getContentAsString(),
				FeatureResponseDTO[].class);
		assertEquals(responseArray.length, 14);
	}

	/**
	 * Test for the "/features/{id}" endpoint.
	 * 
	 * @throws Exception
	 */
	@Test
	public void getFeatureTestSucces() throws Exception {
		String featureId = "aeaa71d6-c549-4620-99ce-f8cae750b8d5";
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/features/" + featureId + "/")).andReturn();
		assertEquals(result.getResponse().getStatus(), HttpStatus.OK.value());

		FeatureResponseDTO response = jsonMapper.readValue(result.getResponse().getContentAsString(),
				FeatureResponseDTO.class);

		assertNotNull(response);
		assertEquals(response.getId(), featureId);
	}

	/**
	 * Failure test for the "/features/{id}" endpoint which checks for a HTTP 404 status response
	 * 
	 * @throws Exception
	 */
	@Test
	public void getFeatureTestFailure() throws Exception {
		String featureId = "1234567890";
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/features/" + featureId + "/")).andReturn();
		assertEquals(result.getResponse().getStatus(), HttpStatus.NOT_FOUND.value());
	}

	/**
	 * Test for the "/features/{id}/quicklook" endpoint.
	 * 
	 * @throws Exception
	 */
	@Test
	public void getImageTest() throws Exception {
		String featureId = "6df9b09a-3a93-4064-bf9f-47e5809b0ffe";

		MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/features/" + featureId + "/quicklook")).andReturn();
		assertEquals(result.getResponse().getStatus(), HttpStatus.OK.value());

		assertNotNull(result.getResponse().getContentAsByteArray());
	}
}

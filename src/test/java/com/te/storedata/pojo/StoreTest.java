package com.te.storedata.pojo;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class StoreTest {
	
	String json = "{\"storeId\":\"12\",\"postCode\":\"563322\",\"city\":\"bangalore\",\"address\":\"krt\",\"openedDate\":944937000000}";

	ObjectMapper mapper = new ObjectMapper();

	@Test
	void SerializationTest() throws JsonProcessingException, ParseException {
		Store store = new Store();
		store.setAddress("krt");
		store.setCity("bangalore");
		store.setOpenedDate(new SimpleDateFormat("dd-MM-yyyy").parse("12-12-1999"));
		store.setPostCode("563322");
		store.setStoreId("12");

//		System.out.println(mapper.writeValueAsString(store));

		Store readValue = mapper.readValue(json, Store.class);

		assertEquals(json, mapper.writeValueAsString(readValue));
	}
	
	
	@Test
	public void deserializationTest() throws JsonMappingException, JsonProcessingException {
		
		Store readValue = mapper.readValue(json, Store.class);

		assertEquals(json, mapper.writeValueAsString(readValue));
	}

}

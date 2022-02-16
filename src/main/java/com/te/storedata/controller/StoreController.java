package com.te.storedata.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.storedata.model.ResponseModel;
import com.te.storedata.pojo.Store;
import com.te.storedata.service.StoreService;

@RestController
@RequestMapping("api/v1")
public class StoreController {

	@Autowired
	private StoreService service;

	@GetMapping("/store/{storeId}")
	public ResponseEntity<ResponseModel> getStoreById(@PathVariable String storeId) {
		Store storeById = service.getStoreById(storeId);
		if (storeById != null)
			return new ResponseEntity<ResponseModel>(new ResponseModel(false, "data found", storeById), HttpStatus.OK);
		else
			return new ResponseEntity<>(new ResponseModel(true, "data not found", null), HttpStatus.NOT_FOUND);
	}

	@GetMapping("/stores/{field}")
	public ResponseEntity<ResponseModel> getStoresByField(@PathVariable String field) {
		List<Store> storesByCity = service.getStoresByCity(field);
		if (!storesByCity.isEmpty()) {
			return new ResponseEntity<ResponseModel>(new ResponseModel(false, "data found", storesByCity),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new ResponseModel(true, "please provide proper city", null),
					HttpStatus.NOT_FOUND);
		}
	}

}

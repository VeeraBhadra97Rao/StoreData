package com.te.storedata.service;

import java.util.List;

import com.te.storedata.pojo.Store;

public interface StoreService {

	public Store getStoreById(String id);
	
	public List<Store> getStoresByCity(String city);
	
}

package com.te.storedata.service;

import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.opencsv.CSVReader;
import com.te.storedata.exceptions.CustomException;
import com.te.storedata.pojo.Store;

@Service
public class StoreServiceImplementation implements StoreService {

	public Store getStoreById(String storeId) {
		int count = 0;
		Store store = new Store();
		List<String> list = new ArrayList<>();
		try (CSVReader csvReader = new CSVReader(new FileReader("src/main/resources/task.csv"));) {
			String[] values = null;
			while ((values = csvReader.readNext()) != null) {
				list = Arrays.asList(values);
				if (list.get(0).equals(storeId)) {
					Date date = new SimpleDateFormat("dd-MM-yyyy").parse(list.get(4));
					store.setStoreId(list.get(0));
					store.setPostCode(list.get(1));
					store.setCity(list.get(2));
					store.setAddress(list.get(3));
					store.setOpenedDate(date);
					count++;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (count > 0)
			return store;
		else
			throw new CustomException("Please provide proper Store Id!!");

	}

	@Override
	public List<Store> getStoresByCity(String field) {
		List<Store> list = new ArrayList<>();
		List<String> list1 = new ArrayList<>();
		try (CSVReader csvReader = new CSVReader(new FileReader("src/main/resources/task.csv"));) {
			String[] values = null;
			while ((values = csvReader.readNext()) != null) {
				list1 = Arrays.asList(values);
				Store store = new Store();
				Date date = new SimpleDateFormat("dd-MM-yyyy").parse(list1.get(4));
				store.setStoreId(list1.get(0));
				store.setPostCode(list1.get(1));
				store.setCity(list1.get(2));
				store.setAddress(list1.get(3));
				store.setOpenedDate(date);
				list.add(store);
			}
			Comparator<Store> sort = null;
			if (field.equalsIgnoreCase("city")) {
				sort = (a, b) -> a.getCity().compareTo(b.getCity());
			} else if (field.equalsIgnoreCase("date")) {
				sort = (a, b) -> a.getOpenedDate().compareTo(b.getOpenedDate());
			}else {
				throw new CustomException("Provide proper field!!!");
			}
			Collections.sort(list, sort);
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new CustomException("Provide proper field!!!");

	}

}

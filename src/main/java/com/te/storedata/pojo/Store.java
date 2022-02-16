package com.te.storedata.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Store implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String storeId;
	private String postCode;
	private String city;
	private String address;
	private Date openedDate;

}

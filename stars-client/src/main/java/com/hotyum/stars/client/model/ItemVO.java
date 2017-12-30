package com.hotyum.stars.client.model;

import java.io.Serializable;

public class ItemVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 187630552965215709L;
	
	private long id;
	
	private String barcode;
	
	private String name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

package com.hotyum.stars.web.vo;

import java.io.Serializable;
import java.util.ArrayList;

public class ResetVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3376650108419914786L;

	private long id;
	
	private String name;
	
	private ArrayList<String> aliais = null;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<String> getAliais() {
		return aliais;
	}

	public void setAliais(ArrayList<String> aliais) {
		this.aliais = aliais;
	}
	
	
}

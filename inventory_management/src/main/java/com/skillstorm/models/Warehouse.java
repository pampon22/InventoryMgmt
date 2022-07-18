package com.skillstorm.models;


/**
 * 
 * @author Philip AMpong
 *
 */
public class Warehouse {
	
	private int id;
	private String state;
	
	
	public Warehouse() {
		super();
	}

	public Warehouse(String state) {
		super();
		this.state = state;
	}

	public Warehouse(int id, String state) {
		super();
		this.id = id;
		this.state = state;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	@Override
	public String toString() {
		return "Warehouse [id=" + id + ", state=" + state + "]";
	}

}

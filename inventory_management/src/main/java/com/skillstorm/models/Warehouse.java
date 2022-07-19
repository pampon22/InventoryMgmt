package com.skillstorm.models;


/**
 * 
 * @author Philip AMpong
 *
 */
public class Warehouse {
	
	private int id;
	private String state;
//	private final int MAX_CAPACITY;
	private int capacity;
	
	
	public Warehouse() {
		super();
//		this.MAX_CAPACITY = 1;
	}


	/**
	 * use this for auto-increment column
	 * @param state
	 */
	public Warehouse(String state) {
		super();
		this.state = state;
	}

	public Warehouse(int id, String state, int capacity) {
		super();
		this.id = id;
		this.state = state;
		this.capacity = capacity;
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
	

	public int getCapacity() {
		return capacity;
	}
	
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	
	@Override
	public String toString() {
		return "Warehouse [id=" + id + ", state=" + state + ", capacity=" + capacity + "]";
	}

}

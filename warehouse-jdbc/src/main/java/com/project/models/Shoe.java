package com.project.models;


/**
 * Shoe class that represents the shoe entity we want from the database
 * @author Philip Ampong
 *
 */
public class Shoe {
	
	private int id;
	private String name;
//	private enum Gender {
//		male, female, unisex
//	};
	private int size;
	private String color;
	private String brand;
	private int quantity;
	
	/**
	 * no arg constructor
	 */
	public Shoe() {
		super();
	}

	
	/**
	 * 
	 * @param id: the shoe's id in the database 
	 * @param name: name of the shoe
	 * @param brand: brand name of the shoe
	 */
	public Shoe(int id, String name, String brand) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
	}
	
	
	/**
	 * use this constructor for shoe with auto-increment id
	 * @param id
	 */
	public Shoe(int id) {
		super();
		this.id = id;
	}
	
	
//	public Shoe(int id, String name) {
//		super();
//		this.id = id;
//		this.name = name;
//	}

	
	/**
	 * 
	 * @return the shoe's id
	 */
	public int getId() {
		return this.id;
	}

	
	public void setId(int id) {
		this.id = id;
	}

	
	public String getName() {
		return this.name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	
	public int getSize() {
		return this.size;
	}

	
	public void setSize(int size) {
		this.size = size;
	}

	
	/**
	 * 
	 * @return returns the shoe's color
	 */
	public String getColor() {
		return this.color;
	}

	
	/**
	 * 
	 * @param color: : set the shoe's color
	 */
	public void setColor(String color) {
		this.color = color;
	}

	
	/**
	 * 
	 * @return the shoe brand
	 */
	public String getBrand() {
		return this.brand;
	}

	
	/**
	 * 
	 * @param brand: set the shoe's brand
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	
	public int getQuantity() {
		return this.quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}

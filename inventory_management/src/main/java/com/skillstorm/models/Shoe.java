package com.skillstorm.models;

/**
 * 
 * Field, Type, Null, Key, Default, Extra
 * 
 */

/**
 * Shoe class that represents the shoe entity we want from the database
 * @author Philip Ampong
 *
 */
public class Shoe {
	
	private int id;
	private String name;
	private double size;
	private String color;
	private String brand;
	private int location;
	private Gender gender;
	 
	
	/**
	 * no arg constructor
	 */
	public Shoe() {
		super();
	}


	/**
	 * auto-incremented so no passing in id
	 * 
	 * @param id
	 * @param name
	 * @param size
	 * @param color
	 * @param brand
	 * @param location
	 */
	public Shoe(String name, double size, String color, String brand, int location) {
		super();
		this.name = name;
		this.size = size;
		this.color = color;
		this.brand = brand;
		this.location = location;
	}

	
	
	public Shoe(int id, String name, double size, String color, String brand, int location) {
		super();
		this.id = id;
		this.name = name;
		this.size = size;
		this.color = color;
		this.brand = brand;
		this.location = location;
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

	
	public double getSize() {
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
	

	public int getLocation() {
		return location;
	}


	public void setLocation(int location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Shoe [id=" + id + ", name=" + name + ", size=" + size + ", color=" + color + ", brand=" + brand
				+ ", location=" + location + "]";
	}

//	public static void main(String[] args) {
//		Shoe shoe = new Shoe(1, "lebron soldier", "nike");
//		System.out.println(shoe);
//	}
}
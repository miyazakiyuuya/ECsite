package com.internousdev.ecsite3.dto;

public class CartDTO {

	private int userId;

	private int productId;

	private int count;

	private int id;

	private String item_name;

	private int item_price;

	private int item_stock;

	private String image_file_path;

	private String image_file_name;

	// getterを設定するだけ
	//	public CartDTO(int userId, int productId, int count, int id, String item_name, int item_price, int item_stock) {
	//		this.userId = userId;
	//		this.productId = productId;
	//		this.count = count;
	//		this.id = id;
	//		this.item_name = item_name;
	//		this.item_price = item_price;
	//		this.item_stock = item_stock;
	//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItem_name() {

		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public int getItem_price() {
		return item_price;
	}

	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}

	public int getItem_stock() {
		return item_stock;
	}

	public void setItem_stock(int item_stock) {
		this.item_stock = item_stock;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getImage_file_path() {
		return image_file_path;
	}

	public void setImage_file_path(String image_file_path) {
		this.image_file_path = image_file_path;
	}

	public String getImage_file_name() {
		return image_file_name;
	}

	public void setImage_file_name(String image_file_name) {
		this.image_file_name = image_file_name;
	}



}

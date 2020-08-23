package com.hackathon.OrderHack.dto;

import com.hackathon.OrderHack.entity.CartEntity;


public class CartDto {
	private int itemId;
	private String itemName;
	private String category;
	private String image;
	private float price;
	private int rating;
	private int sellerId;
	private int stock;
	private int quantity;
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	 public  CartEntity  createEntity() {
         CartEntity cart=new CartEntity();
         cart.setItemName(this.getItemName());
         cart.setQuantity(this.getQuantity());
         cart.setCategory(this.getCategory());
         cart.setImage(this.getImage());
 		 cart.setItemId(this.getItemId());
 		 cart.setPrice(this.getPrice());
 		 cart.setRating(this.getRating());
 		 cart.setSellerId(this.getSellerId());
 		 cart.setStock(this.getStock());
         return cart;
 }
	
	

}

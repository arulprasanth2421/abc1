package com.hackathon.OrderHack.dto;

import java.util.Date;

import com.hackathon.OrderHack.entity.AddressEntity;
import com.hackathon.OrderHack.entity.CartEntity;
import com.hackathon.OrderHack.entity.OrderEntity;




public class OrderDto {
	private int orderId;
	private int buyerId;
	private int itemId;
	private int sellerId;
	private float amount;
	private int quantity;
	private Date date;
	private AddressEntity address;
	private String status;
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	public AddressEntity getAddress() {
		return address;
	}
	public void setAddress(AddressEntity address) {
		this.address = address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public static OrderDto valueof(OrderEntity orders) {
		OrderDto order=new OrderDto();
		order.setAddress(orders.getAddress());
		order.setAmount(orders.getAmount());
		order.setBuyerId(orders.getBuyerId());
		order.setDate(orders.getDate());
		order.setItemId(orders.getItemId());
		order.setOrderId(orders.getOrderId());
		order.setSellerId(orders.getSellerId());
		order.setStatus(orders.getStatus());
		return order;
		
}
	public static CartDto valueof(CartEntity oe) {
		CartDto cartDTO=new CartDto();
        cartDTO.setCategory(oe.getCategory());
        cartDTO.setImage(oe.getImage());
        cartDTO.setItemId(oe.getItemId());
        cartDTO.setItemName(oe.getItemName());
        cartDTO.setPrice(oe.getPrice());
        cartDTO.setQuantity(oe.getQuantity());
        cartDTO.setRating(oe.getRating());
        cartDTO.setSellerId(oe.getSellerId());
        cartDTO.setStock(oe.getStock());
        return cartDTO;
	}
	public OrderEntity createEntity(OrderDto orderDTO) {
		OrderEntity order=new OrderEntity();
		order.setItemId(orderDTO.getItemId());
		order.setAddress(orderDTO.getAddress());
		order.setAmount(orderDTO.getAmount());
		order.setBuyerId(orderDTO.getBuyerId());
		order.setDate(orderDTO.getDate());
		order.setOrderId(orderDTO.getOrderId());
		order.setSellerId(orderDTO.getSellerId());
		order.setStatus(orderDTO.getStatus());
		return order;
		
	}
}

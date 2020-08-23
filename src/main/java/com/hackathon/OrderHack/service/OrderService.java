package com.hackathon.OrderHack.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.OrderHack.dto.CuisineDto;
import com.hackathon.OrderHack.dto.OrderDto;
import com.hackathon.OrderHack.entity.OrderEntity;
import com.hackathon.OrderHack.repository.OrderRepository;




@Service
public class OrderService {
	
	@Autowired
	OrderRepository order;
	

	
	public List<OrderDto> getorders() {
		List<OrderDto> l=new ArrayList<OrderDto>();
		List<OrderEntity> oe=order.findAll();
		for(OrderEntity O: oe) {
		OrderDto dto=OrderDto.valueof(O);
		l.add(dto);
		}
		return l;
	}
	
	public OrderDto getordersbyid(Integer itemid) {
		OrderEntity oe=order.getOne(itemid);
		OrderDto O=OrderDto.valueof(oe);
		return O;
	}
	
//	public OrderDto getordersbyname(String itemname) {
//		OrderEntity oe=order.getOneTwo(itemname);
//		OrderDto O=OrderDto.valueof(oe);
//		return O;
//	}
	
	public void removeorder(Integer itemid) {
		OrderEntity oe=order.findByitemId(itemid);
		order.delete(oe);
	}
	
	public void addToOrder(CuisineDto cusDTO,Integer quantity) {
		System.out.println("in service");
		OrderDto orderDTO= new OrderDto();
		orderDTO.setItemId(cusDTO.getItemid());
		orderDTO.setQuantity(quantity);
		
		System.out.println("after Dto");
		
		OrderEntity orderent=orderDTO.createEntity(orderDTO);
		System.out.println("after entity");
		order.save(orderent);
		}}
		




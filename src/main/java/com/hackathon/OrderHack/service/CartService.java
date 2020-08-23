package com.hackathon.OrderHack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.OrderHack.dto.CartDto;
import com.hackathon.OrderHack.dto.OrderDto;
import com.hackathon.OrderHack.entity.CartEntity;
import com.hackathon.OrderHack.entity.OrderEntity;
import com.hackathon.OrderHack.repository.CartRepository;



@Service
public class CartService {
	
	@Autowired
	CartRepository cartRepo;
	
	
	public CartDto getorderbyid(Integer itemid) {
		CartEntity oe=cartRepo.getOne(itemid);
		CartDto O=OrderDto.valueof(oe);
		return O;
	}
	
	public void addtocart(CartDto cartDTO) {
		System.out.println("in service");
		CartDto cart1=new CartDto();
		cart1.setItemName(cartDTO.getItemName());
		cart1.setQuantity(cartDTO.getQuantity());
		cart1.setCategory(cartDTO.getCategory());
		cart1.setImage(cartDTO.getImage());
		cart1.setItemId(cartDTO.getItemId());
		cart1.setPrice(cartDTO.getPrice());
		cart1.setRating(cartDTO.getRating());
		cart1.setSellerId(cartDTO.getSellerId());
		cart1.setStock(cartDTO.getStock());
		CartEntity cart2= cart1.createEntity();
		cartRepo.save(cart2);
		
	}
	
	public void removecartitem(Integer itemid) {
		CartEntity oe=cartRepo.findByitemId(itemid);
		cartRepo.delete(oe);
	}


}

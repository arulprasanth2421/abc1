package com.hackathon.OrderHack.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hackathon.OrderHack.dto.CartDto;
import com.hackathon.OrderHack.dto.CuisineDto;
import com.hackathon.OrderHack.dto.OrderDto;
import com.hackathon.OrderHack.service.CartService;
import com.hackathon.OrderHack.service.OrderService;



@RestController
@CrossOrigin
public class orderHackController {
	 
		@Autowired
		OrderService orderService;
		
		@Autowired 
		CartService cartService;
		
//		@Autowired
//		RestTemplate template;
		
		Logger logger = LoggerFactory.getLogger(this.getClass());
		@GetMapping(value="/view", produces= MediaType.APPLICATION_JSON_VALUE)
		public List<OrderDto> getorders(){
			System.out.println("start");
			List<OrderDto> orderDto=orderService.getorders();
			return orderDto;
			}
		
		@GetMapping(value="/view/{orderid}", produces= MediaType.APPLICATION_JSON_VALUE)
		public OrderDto getordersbyid(@PathVariable Integer orderid){
			logger.info("Request for Order view by Buyer {}", orderid);
			OrderDto orderDto=orderService.getordersbyid(orderid);
			return orderDto;
			}
		
		@GetMapping(value="/show/{itemid}", produces= MediaType.APPLICATION_JSON_VALUE)
		public CartDto getcartbyid(@PathVariable Integer itemid){
			logger.info("Request for Order view by Buyer {}", itemid);
			CartDto cartDto=cartService.getorderbyid(itemid);
			return cartDto;
			}
		
		@DeleteMapping(value="/remove/{itemid}", consumes= MediaType.APPLICATION_JSON_VALUE)
		public String removeorder(@PathVariable Integer itemid) {
			logger.info("Request for order removal by buyer {}", itemid);
			orderService.removeorder(itemid);
			return "Deleted successfully";
		}
		@DeleteMapping(value="/delete/{itemid}", consumes= MediaType.APPLICATION_JSON_VALUE)
		public String removecartitem(@PathVariable Integer itemid) {
			logger.info("Request for order removal by buyer {}", itemid);
			cartService.removecartitem(itemid);
			return "Deleted successfully";
		}
//		@PostMapping(value="/add/cart/{itemname}/{quantity}",  consumes = MediaType.APPLICATION_JSON_VALUE)
//		public String addtocart(@PathVariable String itemname, @PathVariable Integer quantity) {
//			try {
//				logger.info("Add item to cart request {}", itemname);
//				CuisineDto cusDTO=template.getForObject("http://PROJECT"+"/products/productid/"+itemname,CuisineDto.class);
//				CartDto cart=new CartDto();
//				cart.setItemName(itemname);
//				cart.setQuantity(quantity);
//				cartService.addtocart(cart);
//				return "Added successfully";
//			
//			}catch(Exception e) {
//				return "Unable to add";
//			}
//			}
		
//		@PostMapping(value="/add/item/{itemid}/{quantity}")
//		public String addToOrder(@PathVariable Integer itemid,@PathVariable Integer quantity) {
//			try {
//				logger.info("Add products to Order request {}", itemid);
//				CuisineDto cusDTO=template.getForObject("http://PROJECT"+"/products/productid/"+itemid,CuisineDto.class);
//				System.out.println("before service");
//				orderService.addToOrder(cusDTO,quantity);
//				System.out.println("after service");
//				return "Added to order successfully";
//			}catch(Exception e) {
//				return "Unable to add";
//			}
//		}
        
		
		

	}



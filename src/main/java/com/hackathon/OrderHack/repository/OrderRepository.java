package com.hackathon.OrderHack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.OrderHack.entity.OrderEntity;



@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer>{
	OrderEntity getOne(Integer orderId);
	
	

	OrderEntity findByitemId(Integer itemid);

//	OrderEntity getOneTwo(String itemname);
	

}

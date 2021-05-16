package kosta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kosta.model.Order;
import kosta.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	private OrderService service;
	
	@RequestMapping("/orderForm")
	public String orderForm(){
		return "transaction/orderForm";
	}
	
	@RequestMapping("/orderAction")
	public String orderAction(Order order){
		String view = "transaction/orderOk";
		
		try {
			service.orderAction(order);
		} catch (Exception e) {
			view = "transaction/orderForm";
		}
		
		return view;
	}
	
}











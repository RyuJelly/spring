package kosta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kosta.model.ItemDao;
import kosta.model.Order;
import kosta.model.OrderDao;

@Service
public class OrderService {
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private ItemDao itemDao;
	
	//주문서비스 구현 메서드
	@Transactional(propagation=Propagation.REQUIRED,
			rollbackFor={Exception.class})
	public void orderAction(Order order)throws Exception{
		//주문등록
		orderDao.addOrder(order);
		
		//재고수량체크 => 재고부족 => 예외
		if(itemDao.findItem(order.getNo()).getAmount() < order.getAmount()){
			throw new Exception("재고 부족");
		}
		
		//재고 조정
		itemDao.updateItem(order);
	}

}

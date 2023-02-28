package day24.workshop.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import day24.workshop.exception.OrderException;
import day24.workshop.models.Order;
import day24.workshop.repo.OrderDetailsRepo;
import day24.workshop.repo.OrderRepo;

@Service
public class OrderService {

    @Autowired
    OrderRepo oRepo;

    @Autowired
    OrderDetailsRepo odRepo;

    @Transactional(rollbackFor = OrderException.class)
    // If there are any OrderException errors, all actions in this method will be rolled back
    // unchecked exceptions will be rolled back
    public void createPurchaseOrder(Order ord) throws OrderException {

        // Remove auto-increment for order if any
        // String orderId = UUID.randomUUID().toString().substring(0, 8);
        // ord.setOrderId(orderId);
        oRepo.insertIntoOrder(ord);
        //check order, if > 5 throw exception
        // This is placed here to demonstrate that if anything after the if statement has errors,
        // the line above will be rolled back as well
        if(ord.getOrderList().size() > 3) {
            throw new OrderException();
        }
        odRepo.insertMultiple(ord.getOrderList());

        // Can make it return boolean after querying the 
        // order list and checking if there are <= 3 items
        // TODO
        
    }
    
}

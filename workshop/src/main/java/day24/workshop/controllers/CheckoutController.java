package day24.workshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import day24.workshop.exception.OrderException;
import day24.workshop.models.Order;
import day24.workshop.models.OrderDetails;
import day24.workshop.repo.OrderDetailsRepo;
import day24.workshop.repo.OrderRepo;
import day24.workshop.services.OrderService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {

    @Autowired
    OrderService oSrc;

    @Autowired
    OrderDetailsRepo odRepo;

    @PostMapping
    public String confirmCheckout(Model model, HttpSession sessions) throws OrderException {

        List<OrderDetails> orderList = (List<OrderDetails>) sessions.getAttribute("cart");
        Order order = (Order) sessions.getAttribute("checkout");

        oSrc.createPurchaseOrder(order);

        model.addAttribute("size", orderList.size());
        model.addAttribute("confirmation", orderList);

        // Should check if the insertion is correct/successful first before invalidating the session
        // if(orderList.size() <= 3) {
            
        // }
        sessions.invalidate();

        return "checkoutpage";
        
    }
    
}

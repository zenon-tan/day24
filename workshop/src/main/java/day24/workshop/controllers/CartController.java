package day24.workshop.controllers;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import day24.workshop.models.Order;
import day24.workshop.models.OrderDetails;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/cart")
public class CartController {

    @PostMapping
    public String postCart(@RequestBody MultiValueMap<String, String> form,
    Model model, HttpSession sessions) {

        List<OrderDetails> orderDetails = 
        (List<day24.workshop.models.OrderDetails>) sessions.getAttribute("cart");

        if(orderDetails == null) {
            orderDetails = new LinkedList<>();
            sessions.setAttribute("cart", orderDetails);
        }
        String item = form.getFirst("item");
        int quantity = Integer.parseInt(form.getFirst("quantity"));
        orderDetails.add(new OrderDetails(item, quantity));
        Order ord = new Order();
        ord.setCustomerName(form.getFirst("customerName"));
        ord.setOrderList(orderDetails);
        
        // Create a sessions object so that it can be moved to the checkout page
        sessions.setAttribute("checkout", ord);
        // Add the items into the list of items below the page
        model.addAttribute("orderDetails", orderDetails);
        return "cart";
    }
    
}


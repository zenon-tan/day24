package day24.workshop.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import day24.workshop.models.Order;

@Repository
public class OrderRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Boolean insertIntoOrder(Order order) {

        return jdbcTemplate.update(Queries.ORDER_INSERT_SQL, 
        order.getCustomerName(), 
        order.getShipAddress(), order.getTax(), order.getNotes()) > 0;
        
    }
    
}

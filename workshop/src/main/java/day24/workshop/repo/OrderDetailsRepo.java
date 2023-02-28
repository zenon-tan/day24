package day24.workshop.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import day24.workshop.models.OrderDetails;

@Repository
public class OrderDetailsRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Boolean insertIntoDetails(OrderDetails order) {

        return jdbcTemplate.update(Queries.DETAILS_INSERT_SQL, 
        order.getItemId(), order.getProduct(), order.getUnitPrice(),
        order.getOrderId(), order.getDiscount(), order.getQuantity()) > 0;
        
    }

    // Batch update using an Object class to store the values
    public void insertMultiple(List<OrderDetails> orderList) {

        List<Object[]> arrData = orderList.stream()
        .map(li -> {
            
            Object[] i = new Object[5];
            i[0] = li.getItemId();
            i[1] = li.getProduct();
            i[2] = li.getUnitPrice();
            i[3] = li.getDiscount();
            i[4] = li.getQuantity();

            return i;

        })
        .toList();

        jdbcTemplate.batchUpdate(Queries.DETAILS_INSERT_SQL, arrData);

    }

    public int getLineItemsCount(String orderId) {
        return jdbcTemplate.queryForObject(Queries.COUNT_DETAIL_SQL, 
        BeanPropertyRowMapper.newInstance(Integer.class), orderId);
    }

    
    
}

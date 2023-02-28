package day24.workshop.models;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private String orderId;
    private Date orderDate;
    private String customerName;
    private String shipAddress;
    // TODO: does BigDecimal work??
    private BigDecimal tax;
    private String notes;

    private List<OrderDetails> orderList = new LinkedList<>();

    public void addOrderDetails(OrderDetails od) {
        this.orderList.add(od);
    }
    
}

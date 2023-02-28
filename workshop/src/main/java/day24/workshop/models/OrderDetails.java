package day24.workshop.models;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetails {

    private int itemId;
    private String product;
    private BigDecimal unitPrice;
    private int orderId;
    private BigDecimal discount;
    private int quantity;

    public OrderDetails(String product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
    
}

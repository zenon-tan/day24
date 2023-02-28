package day24.workshop.repo;

public class Queries {

    public static final String ORDER_INSERT_SQL = """
            insert into order
            (customer_name, ship_address, tax, notes)
            values(?, ?, ?, ?)
            """;

    public static final String DETAILS_INSERT_SQL = """
            insert into order_details
            (item_id, product, unit_price, order_id, discount, quantity)
            values(?, ?, ?, ?, ?)
            """;

        public static final String COUNT_DETAIL_SQL = """
                select count(*) from order_details where order_id = ?
                """;
    

}

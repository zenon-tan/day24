create table purchase_order (
	order_id varchar(8) not null,
    order_name varchar(128) not null,
    order_date Date not null,
    primary key(order_id)
);

create table line_item(
	id int not null,
    description text not null,
    quantity int not null,
    order_id int not null,
    primary key(item_id),
    foreign key(order_id) references purchase_order(order_id)
);


CREATE TABLE `order_details` (
  `id` int NOT NULL,
  `product` text NOT NULL,
  `unit_price` decimal(3,2) DEFAULT '0.00',
  `order_id` char(8) NOT NULL,
  `discount` decimal(3,2) DEFAULT '1.00',
  `quantity` int DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



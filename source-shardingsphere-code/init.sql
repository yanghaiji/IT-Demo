CREATE TABLE `t_order_0` (
  `order_id` bigint(11) NOT NULL DEFAULT '0',
  `user_id` bigint(1) DEFAULT NULL,
  `amount` decimal(18,2) DEFAULT NULL,
  `discount` decimal(10,2) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_order_item_0` (
  `order_id` bigint(11) NOT NULL DEFAULT '0',
  `product_id` bigint(11) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `discount` decimal(10,2) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

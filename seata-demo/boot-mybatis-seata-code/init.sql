
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for undo_log
-- ----------------------------
DROP TABLE IF EXISTS `undo_log`;
CREATE TABLE `undo_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `branch_id` bigint(20) NOT NULL,
  `xid` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `context` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `rollback_info` longblob NOT NULL,
  `log_status` int(11) NOT NULL,
  `log_created` datetime(0) NULL,
  `log_modified` datetime(0) NULL,
  `ext` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `ux_undo_log`(`xid`, `branch_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;


SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for surplus_goods_info
-- ----------------------------
DROP TABLE IF EXISTS `surplus_goods_info`;
CREATE TABLE `surplus_goods_info`  (
  `id` int(11) NOT NULL,
  `goods_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名',
  `goods_info` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述信息',
  `status` int(11) NOT NULL COMMENT '是否卖出，0未卖出，1，卖出',
  `brand_id` int(11) NOT NULL COMMENT '所属品牌',
  `price` decimal(10, 0) NOT NULL COMMENT '价格',
  `account` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of surplus_goods_info
-- ----------------------------
INSERT INTO `surplus_goods_info` VALUES (1, 'P30 手机', '95新', 0, 1, 3000, 30);
INSERT INTO `surplus_goods_info` VALUES (2, '小米', '85新', 0, 2, 3000, 0);

SET FOREIGN_KEY_CHECKS = 1;




SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for surplus_brand
-- ----------------------------
DROP TABLE IF EXISTS `surplus_brand`;
CREATE TABLE `surplus_brand`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_cat_id` int(11) NOT NULL COMMENT '所属分类',
  `brand` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '品牌',
  `brand_info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '品牌相信信息',
  `create_time` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `update_timt` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `is_delete` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `surplus_tiem_id`(`item_cat_id`) USING BTREE,
  CONSTRAINT `surplus_tiem_id` FOREIGN KEY (`item_cat_id`) REFERENCES `surplus_item_cat` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of surplus_brand
-- ----------------------------
INSERT INTO `surplus_brand` VALUES (1, 1, 'huawei', '30', '2021-03-23 14:53:06', '2021-03-23 14:53:06', 0);
INSERT INTO `surplus_brand` VALUES (2, 1, '小米', '10', '2021-03-23 14:43:38', '2021-03-23 14:43:38', 0);

SET FOREIGN_KEY_CHECKS = 1;
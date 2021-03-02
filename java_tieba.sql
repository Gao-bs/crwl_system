/*
 Navicat Premium Data Transfer

 Source Server         : xf-nas
 Source Server Type    : MySQL
 Source Server Version : 50646
 Source Host           : xf-nas:3306
 Source Schema         : java_tieba

 Target Server Type    : MySQL
 Target Server Version : 50646
 File Encoding         : 65001

 Date: 22/04/2020 19:27:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_category
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `category_name` varchar(5000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类名',
  `category_url` varchar(5000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类url',
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_category
-- ----------------------------
INSERT INTO `t_category` VALUES ('1', '贴吧', 'http://tieba.baidu.com/f/search/res?isnew=1&kw=%C0%BC%D6%DD%BD%BB%CD%A8%B4%F3%D1%A7&qw=%C0%CF%CA%A6&rn=10&un=&only_thread=0&sm=1&sd=&ed=&pn=2', '2020-04-13 16:00:05');
INSERT INTO `t_category` VALUES ('7d418d4c-848b-11ea-a61c-0242ac110006', '贴吧', 'http://tieba.baidu.com/f/search/res?isnew=1&kw=%C0%BC%D6%DD%BD%BB%CD%A8%B4%F3%D1%A7&qw=%C0%CF%CA%A6&rn=10&un=&only_thread=0&sm=1&sd=&ed=&pn=2', '2020-04-22 11:24:32');

-- ----------------------------
-- Table structure for t_result
-- ----------------------------
DROP TABLE IF EXISTS `t_result`;
CREATE TABLE `t_result`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gjc` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关键词',
  `contents` blob NULL COMMENT '包含关键词的内容',
  `url` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '从哪里爬到的',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `user_name` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '(1微博 2贴吧 3qq空间)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_result
-- ----------------------------
INSERT INTO `t_result` VALUES ('1f185280-f4b4-49ae-b1f3-95175697dc85', '研究生', 0xE38090E59BBEE78987E38091E59B9EE5A48DEFBC9AE5BC80E4B8AAE8B4B420E8AEB2E8AEB2E68891E79A84E5A4A7E5ADA6E59B9BE5B9B4E38090E585B0E5B79EE4BAA4E9809AE5A4A7E5ADA6E590A7E380915FE799BEE5BAA6E8B4B4E590A7, 'https://tieba.baidu.com/p/6516740306?pid=131681052951&cid=0#131681052951', '2020-04-22 11:24:48', '回复:开个贴 讲讲我的大学四年', '阿斯舒服', '贴吧');
INSERT INTO `t_result` VALUES ('7b463778-d1f8-4b07-916a-9f79f1a72042', '研究生', NULL, 'https://tieba.baidu.com/p/6632686196?pid=131670006342&cid=0#131670006342', '2020-04-22 11:24:48', '交通学院的王花兰老师怎么样啊,有没有学长学姐介绍一下', '曾经的坏小孩qq', '贴吧');
INSERT INTO `t_result` VALUES ('c0c6026e-2f17-4ac3-abeb-5aa7ffb20614', '研究生', NULL, 'https://tieba.baidu.com/p/6634501137?pid=131689836288&cid=0#131689836288', '2020-04-22 11:24:48', '同学们有没有土木工程专业老师的联系方式啊 感谢', '嗨我啦', '贴吧');
INSERT INTO `t_result` VALUES ('cc828f56-4716-41ad-9aeb-ca1a55967d77', '研究生', NULL, 'https://tieba.baidu.com/p/6510381554?pid=131677997592&cid=0#131677997592', '2020-04-22 11:24:48', '回复:计算机导师信息', '心甘情愿t', '贴吧');
INSERT INTO `t_result` VALUES ('cfc3e309-b756-4061-a820-c64d3b6be1b5', '研究生', NULL, 'https://tieba.baidu.com/p/6634475579?pid=131689623018&cid=0#131689623018', '2020-04-22 11:24:48', '有没有土木工程专业老师的电话 急寻', '', '贴吧');
INSERT INTO `t_result` VALUES ('ed8fab3c-dd9c-4680-92c3-ed6088d760d2', '研究生', NULL, 'https://tieba.baidu.com/p/6634850017?pid=131693153809&cid=0#131693153809', '2020-04-22 11:24:48', '测绘学硕301 数一55 不够A区单科线 有测绘学院的同学吗', '淞野【So丶K】', '贴吧');
INSERT INTO `t_result` VALUES ('fd06de66-7852-4b61-af95-65ac685499a7', '研究生', NULL, 'https://tieba.baidu.com/p/6633788160?pid=131681340124&cid=0#131681340124', '2020-04-22 11:24:48', '【兰州全日制考研港】考研路上,你是否也在迷茫着寻找未来的方向', '全日制考研寄宿', '贴吧');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `user_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `user_password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `telephone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `idcard` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `position` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `depart` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表 ' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('03a54841-8251-11ea-badd-0242ac110009', NULL, '202cb962ac59075b964b07152d234b70', '2020-04-19 15:20:58', '12131232342', '160499844@qq.com', NULL, 'test3', '2', NULL, NULL, NULL, '1');
INSERT INTO `t_user` VALUES ('05875df9-74c1-11ea-9be9-201a069e9274', '1231', '21232f297a57a5a743894a0e4a801fc3', '2020-04-02 09:32:18', '13510561234', '2801563423@qq.com', '男', 'admin', '1', NULL, NULL, NULL, NULL);
INSERT INTO `t_user` VALUES ('0c7156e0-7579-11ea-883c-201a069e9274', 'w', '21232f297a57a5a743894a0e4a801fc3', '2020-04-13 06:36:39', '13510758123', '2801763423@qq.com', '男', 'www', '2', '123', '12312', '123', NULL);
INSERT INTO `t_user` VALUES ('5606d867-8214-11ea-badd-0242ac110009', '3', '202cb962ac59075b964b07152d234b70', '2020-04-22 11:24:16', '12131232342333', '160499844@qq.com', '男', 'test', '2', '3', '3', '3', '2');
INSERT INTO `t_user` VALUES ('699f4d69-848b-11ea-a61c-0242ac110006', NULL, '202cb962ac59075b964b07152d234b70', '2020-04-22 11:23:59', '12131232342', '160499844@qq.com', NULL, 'root', '2', NULL, NULL, NULL, '1');
INSERT INTO `t_user` VALUES ('84b14aae-8250-11ea-badd-0242ac110009', NULL, '202cb962ac59075b964b07152d234b70', '2020-04-19 15:17:25', '12131232342', '160499844@qq.com', NULL, 'test2', '2', NULL, NULL, NULL, '1');
INSERT INTO `t_user` VALUES ('9ef58be9-7d53-11ea-b4f4-bc5ff464274d', NULL, 'e10adc3949ba59abbe56e057f20f883e', '2020-04-13 06:54:29', '13510758123', '2801763423@qq.com', NULL, 'we', '2', NULL, NULL, NULL, '2');
INSERT INTO `t_user` VALUES ('a536d61b-7d6b-11ea-b4f4-bc5ff464274d', '12', 'e10adc3949ba59abbe56e057f20f883e', '2020-04-13 09:47:02', '13510758123', '2801763423@qq.com', '男', 'wes', '2', '12', '123', '123', '2');

SET FOREIGN_KEY_CHECKS = 1;

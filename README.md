# 博客的后端

### 技术

**包管理 : [Maven](https://mvnrepository.com/)**

**编译器 : [IDEA](https://www.jetbrains.com/) + [Navicat](http://www.navicat.com.cn/)**

**数据库 : [MySQL](https://www.mysql.com/)**

**技术栈 : [JAVA](https://www.oracle.com/java/) + [HuTool](https://www.hutool.cn/docs/#/) + [MyBatis](https://mybatis.org/mybatis-3/) + [MyBatisPlus](https://baomidou.com/) + [Sensitive-word-filter](https://github.com/hailin0/sensitive-word-filter) + [Swagger](https://swagger.io/) + [SpringBoot](https://spring.io/) + [druid](https://github.com/alibaba/druid/) + [fastjson](https://github.com/alibaba/fastjson/)**

### 项目地址

**[后端](https://github.com/xiaoxunyao/blog_backEnd_code)**

### SQL代码

```mysql
/*
 Navicat Premium Data Transfer

 Source Server         : HCY
 Source Server Type    : MySQL
 Source Server Version : 50515
 Source Host           : 47.104.249.85:3306
 Source Schema         : hcy_blog

 Target Server Type    : MySQL
 Target Server Version : 50515
 File Encoding         : 65001

 Date: 10/11/2020 21:06:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tbl_blog
-- ----------------------------
DROP TABLE IF EXISTS `tbl_blog`;
CREATE TABLE `tbl_blog`  (
  `blog_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '博客序号',
  `blog_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '博客标题',
  `blog_advertising` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '博客宣传图片的地址',
  `blog_content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '博客的内容',
  `blog_category` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '博客的种类',
  `blog_sign` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '博客的标记',
  `blog_describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '博客的描述',
  `blog_views` int(11) NULL DEFAULT NULL COMMENT '博客的浏览次数',
  `blog_appreciate` bit(1) NULL DEFAULT NULL COMMENT '博客的赞赏是否开启',
  `blog_copyright` bit(1) NULL DEFAULT NULL COMMENT '博客的版权是否开启',
  `blog_comment` bit(1) NULL DEFAULT NULL COMMENT '博客的评论是否开启',
  `blog_release` bit(1) NULL DEFAULT NULL COMMENT '博客是否发布',
  `blog_establish` timestamp NULL DEFAULT NULL COMMENT '博客的创建时间',
  `blog_modification` timestamp NULL DEFAULT NULL COMMENT '博客的修改时间',
  PRIMARY KEY (`blog_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_category
-- ----------------------------
DROP TABLE IF EXISTS `tbl_category`;
CREATE TABLE `tbl_category`  (
  `category_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '种类的序号',
  `category_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '种类的名称',
  `category_establish` timestamp NULL DEFAULT NULL COMMENT '种类的创建时间',
  `category_modification` timestamp NULL DEFAULT NULL COMMENT '种类的修改时间',
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_comment
-- ----------------------------
DROP TABLE IF EXISTS `tbl_comment`;
CREATE TABLE `tbl_comment`  (
  `comment_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评论序号',
  `comment_nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论昵称',
  `comment_mailbox` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论邮箱',
  `comment_content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '评论内容',
  `comment_establish` timestamp NULL DEFAULT NULL COMMENT '评论创建时间',
  `comment_blogid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论的博客序号',
  `comment_parent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论的父评论序号',
  `comment_admin` bit(1) NOT NULL COMMENT '是否是管理员评论',
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_link
-- ----------------------------
DROP TABLE IF EXISTS `tbl_link`;
CREATE TABLE `tbl_link`  (
  `link_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '友链的序号',
  `link_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '友链的网址',
  `link_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '友链的名称',
  `link_picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '友链的图片地址',
  `link_establish` timestamp NULL DEFAULT NULL COMMENT '友链的创建时间',
  `link_modification` timestamp NULL DEFAULT NULL COMMENT '友链的修改时间',
  PRIMARY KEY (`link_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_message
-- ----------------------------
DROP TABLE IF EXISTS `tbl_message`;
CREATE TABLE `tbl_message`  (
  `message_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '留言序号',
  `message_nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '留言昵称',
  `message_mailbox` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '留言邮箱',
  `message_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '留言内容',
  `message_establish` timestamp NULL DEFAULT NULL COMMENT '留言创建时间',
  `message_parent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父留言序号',
  `message_admin` bit(1) NOT NULL COMMENT '是否是管理员',
  PRIMARY KEY (`message_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_picture
-- ----------------------------
DROP TABLE IF EXISTS `tbl_picture`;
CREATE TABLE `tbl_picture`  (
  `picture_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '照片墙的序号',
  `picture_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片的名称',
  `picture_describe` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '图片的描述',
  `picture_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片的网络地址',
  `picture_site` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片的地址',
  `picture_establish` timestamp NULL DEFAULT NULL COMMENT '图片的创建时间',
  `picture_modification` timestamp NULL DEFAULT NULL COMMENT '图片的修改时间',
  PRIMARY KEY (`picture_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_sign
-- ----------------------------
DROP TABLE IF EXISTS `tbl_sign`;
CREATE TABLE `tbl_sign`  (
  `sign_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标记的序号',
  `sign_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标记的名称',
  `sign_creation` timestamp NULL DEFAULT NULL COMMENT '标记的创建时间',
  `sign_modification` timestamp NULL DEFAULT NULL COMMENT '标记的修改时间',
  PRIMARY KEY (`sign_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_user
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user`  (
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户序号',
  `user_nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `user_username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `user_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `user_mailbox` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户的邮箱',
  `user_portrait` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户的头像',
  `user_introduce` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '用户的介绍',
  `user_WeChat` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户微信二维码',
  `user_QQ` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户QQ二维码',
  `user_github` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户的GitHUB网址',
  `user_Alipay` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户支付宝二维码',
  `user_establish` timestamp NULL DEFAULT NULL COMMENT '用户的创建时间',
  `user_modification` timestamp NULL DEFAULT NULL COMMENT '用户的修改时间',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
```


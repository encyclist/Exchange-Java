/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50645
 Source Host           : 127.0.0.1:3306
 Source Schema         : exchange

 Target Server Type    : MySQL
 Target Server Version : 50645
 File Encoding         : 65001

 Date: 19/03/2020 14:38:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for exchange
-- ----------------------------
DROP TABLE IF EXISTS `exchange`;
CREATE TABLE `exchange`  (
  `currencyCode` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '货币代码',
  `exchange` decimal(11, 4) NULL DEFAULT 0.0000 COMMENT '汇率',
  `currencyName` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '货币名称',
  `country` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '国家',
  `updateTime` bigint(20) NULL DEFAULT 0 COMMENT '更新时间',
  PRIMARY KEY (`currencyCode`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of exchange
-- ----------------------------
INSERT INTO `exchange` VALUES ('AED', 3.6720, 'UAE Dirham', 'United Arab Emirates', 1584576000);
INSERT INTO `exchange` VALUES ('ARS', 63.1996, 'Argentine Peso', 'Argentina', 1584576000);
INSERT INTO `exchange` VALUES ('AUD', 1.6998, 'Australian Dollar', 'Australia', 1584576000);
INSERT INTO `exchange` VALUES ('BGN', 1.7854, 'Bulgarian Lev', 'Bulgaria', 1584576000);
INSERT INTO `exchange` VALUES ('BRL', 5.0908, 'Brazilian Real', 'Brazil', 1584576000);
INSERT INTO `exchange` VALUES ('BSD', 1.0000, 'Bahamian Dollar', 'Bahamas', 1584576000);
INSERT INTO `exchange` VALUES ('CAD', 1.4386, 'Canadian Dollar', 'Canada', 1584576000);
INSERT INTO `exchange` VALUES ('CHF', 0.9645, 'Swiss Franc', 'Switzerland', 1584576000);
INSERT INTO `exchange` VALUES ('CLP', 851.4218, 'Chilean Peso', 'Chile', 1584576000);
INSERT INTO `exchange` VALUES ('CNY', 7.0346, 'Chinese Renminbi', 'China', 1584576000);
INSERT INTO `exchange` VALUES ('COP', 4071.8572, 'Colombian Peso', 'Colombia', 1584576000);
INSERT INTO `exchange` VALUES ('CZK', 24.7765, 'Czech Koruna', 'Czech Republic', 1584576000);
INSERT INTO `exchange` VALUES ('DKK', 6.8192, 'Danish Krone', 'Denmark', 1584576000);
INSERT INTO `exchange` VALUES ('DOP', 53.4765, 'Dominican Peso', 'Dominican Republic', 1584576000);
INSERT INTO `exchange` VALUES ('EGP', 15.7504, 'Egyptian Pound', 'Egypt', 1584576000);
INSERT INTO `exchange` VALUES ('EUR', 0.9135, 'Euro', 'Euro', 1584576000);
INSERT INTO `exchange` VALUES ('FJD', 2.2836, 'Fiji Dollar', 'Fiji', 1584576000);
INSERT INTO `exchange` VALUES ('GBP', 0.8441, 'Pound Sterling', 'United Kingdom', 1584576000);
INSERT INTO `exchange` VALUES ('GTQ', 7.6436, 'Guatemalan Quetzal', 'Guatemala', 1584576000);
INSERT INTO `exchange` VALUES ('HKD', 7.7659, 'Hong Kong Dollar', 'Hong Kong', 1584576000);
INSERT INTO `exchange` VALUES ('HRK', 6.9317, 'Croatian Kuna', 'Croatia', 1584576000);
INSERT INTO `exchange` VALUES ('HUF', 319.5535, 'Hungarian Forint', 'Hungary', 1584576000);
INSERT INTO `exchange` VALUES ('IDR', 15148.9500, 'Indonesian Rupiah', 'Indonesia', 1584576000);
INSERT INTO `exchange` VALUES ('ILS', 3.7969, 'Israeli New Shekel', 'Israel', 1584576000);
INSERT INTO `exchange` VALUES ('INR', 74.2786, 'Indian Rupee', 'India', 1584576000);
INSERT INTO `exchange` VALUES ('ISK', 139.7073, 'Icelandic Krona', 'Iceland', 1584576000);
INSERT INTO `exchange` VALUES ('JPY', 107.7677, 'Japanese Yen', 'Japan', 1584576000);
INSERT INTO `exchange` VALUES ('KRW', 1256.4976, 'South Korean Won', 'South Korea', 1584576000);
INSERT INTO `exchange` VALUES ('KZT', 434.0558, 'Kazakhstani Tenge', 'Kazakhstan', 1584576000);
INSERT INTO `exchange` VALUES ('MXN', 23.7411, 'Mexican Peso', 'Mexico', 1584576000);
INSERT INTO `exchange` VALUES ('MYR', 4.3661, 'Malaysian Ringgit', 'Malaysia', 1584576000);
INSERT INTO `exchange` VALUES ('NOK', 10.8149, 'Norwegian Krone', 'Norway', 1584576000);
INSERT INTO `exchange` VALUES ('NZD', 1.7163, 'New Zealand Dollar', 'New Zealand', 1584576000);
INSERT INTO `exchange` VALUES ('PAB', 1.0000, 'Panamanian Balboa', 'Panama', 1584576000);
INSERT INTO `exchange` VALUES ('PEN', 3.5556, 'Peruvian Sol', 'Peru', 1584576000);
INSERT INTO `exchange` VALUES ('PHP', 51.6697, 'Philippine Peso', 'Philippines', 1584576000);
INSERT INTO `exchange` VALUES ('PKR', 158.3500, 'Pakistani Rupee', 'Pakistan', 1584576000);
INSERT INTO `exchange` VALUES ('PLN', 4.0968, 'Polish Zloty', 'Poland', 1584576000);
INSERT INTO `exchange` VALUES ('PYG', 6577.6150, 'Paraguayan Guarani', 'Paraguay', 1584576000);
INSERT INTO `exchange` VALUES ('RON', 4.4221, 'Romanian Leu', 'Romania', 1584576000);
INSERT INTO `exchange` VALUES ('RUB', 78.6848, 'Russian Ruble', 'Russia', 1584576000);
INSERT INTO `exchange` VALUES ('SAR', 3.7519, 'Saudi Riyal', 'Saudi Arabia', 1584576000);
INSERT INTO `exchange` VALUES ('SEK', 10.0811, 'Swedish Krona', 'Sweden', 1584576000);
INSERT INTO `exchange` VALUES ('SGD', 1.4389, 'Singapore Dollar', 'Singapore', 1584576000);
INSERT INTO `exchange` VALUES ('THB', 32.3740, 'Thai Baht', 'Thailand', 1584576000);
INSERT INTO `exchange` VALUES ('TRY', 6.4531, 'Turkish Lira', 'Turkey', 1584576000);
INSERT INTO `exchange` VALUES ('TWD', 30.2932, 'New Taiwan Dollar', 'Taiwan', 1584576000);
INSERT INTO `exchange` VALUES ('UAH', 27.0976, 'Ukrainian Hryvnia', 'Ukraine', 1584576000);
INSERT INTO `exchange` VALUES ('USD', 1.0000, 'United States Dollar', 'United States', 1584576000);
INSERT INTO `exchange` VALUES ('UYU', 44.9102, 'Uruguayan Peso', 'Uruguay', 1584576000);
INSERT INTO `exchange` VALUES ('ZAR', 16.9399, 'South African Rand', 'South Africa', 1584576000);

SET FOREIGN_KEY_CHECKS = 1;

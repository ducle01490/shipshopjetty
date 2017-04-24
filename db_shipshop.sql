-- MySQL dump 10.14  Distrib 5.5.44-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: shipshop
-- ------------------------------------------------------
-- Server version	5.5.44-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `shipOrder`
--

DROP TABLE IF EXISTS `shipOrder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shipOrder` (
  `orderId` int(11) NOT NULL AUTO_INCREMENT,
  `shopId` int(11) NOT NULL,
  `shopUserName` varchar(200) NOT NULL,
  `shopName` varchar(200) NOT NULL,
  `receiveAddress` varchar(1000) NOT NULL,
  `customerAddress` varchar(1000) NOT NULL,
  `customerName` varchar(200) NOT NULL,
  `customerPhone` varchar(20) NOT NULL,
  `deliveryType` int(11) NOT NULL,
  `deliveryPrice` bigint(20) NOT NULL,
  `productPrice` bigint(20) DEFAULT NULL,
  `noteTime` varchar(5000) DEFAULT NULL,
  `noteProduct` varchar(5000) DEFAULT NULL,
  `orderStatus` int(11) NOT NULL,
  `shipperId` int(11) DEFAULT NULL,
  `shipperUserName` varchar(200) DEFAULT NULL,
  `shipperName` varchar(200) DEFAULT NULL,
  `startTime` bigint(20) DEFAULT NULL,
  `finishTime` bigint(20) DEFAULT NULL,
  `statusShopConfirmed` int(11) DEFAULT NULL,
  `statusShipperConfirmed` int(11) DEFAULT NULL,
  PRIMARY KEY (`orderId`),
  KEY `shopId` (`shopId`),
  KEY `shipperId` (`shipperId`),
  KEY `shopUserName` (`shopUserName`),
  KEY `shipperUserName` (`shipperUserName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipOrder`
--

LOCK TABLES `shipOrder` WRITE;
/*!40000 ALTER TABLE `shipOrder` DISABLE KEYS */;
/*!40000 ALTER TABLE `shipOrder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipper`
--

DROP TABLE IF EXISTS `shipper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shipper` (
  `shipper_id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(200) NOT NULL,
  `password` varchar(60) NOT NULL,
  `phoneNumber` varchar(20) NOT NULL,
  `status` int(11) NOT NULL,
  `shipperName` varchar(200) NOT NULL,
  `motorNumber` varchar(20) NOT NULL,
  `birthday` varchar(60) NOT NULL,
  `address` varchar(1000) NOT NULL,
  `idNumber` varchar(20) NOT NULL,
  `previousLoginTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `previousLoginDeviceId` varchar(200) DEFAULT NULL,
  `previousLoginGPS` varchar(1000) DEFAULT NULL,
  `currentGPS` varchar(1000) DEFAULT NULL,
  `updateGPSTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`shipper_id`),
  KEY `userName` (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipper`
--

LOCK TABLES `shipper` WRITE;
/*!40000 ALTER TABLE `shipper` DISABLE KEYS */;
/*!40000 ALTER TABLE `shipper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop`
--

DROP TABLE IF EXISTS `shop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shop` (
  `shop_id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(200) NOT NULL,
  `password` varchar(60) NOT NULL,
  `phoneNumber` varchar(20) NOT NULL,
  `status` int(11) NOT NULL,
  `shopName` varchar(200) NOT NULL,
  `address` varchar(1000) NOT NULL,
  `bankInfo` varchar(5000) NOT NULL,
  `facebook` varchar(1000) DEFAULT NULL,
  `zalo` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`shop_id`),
  KEY `userName` (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop`
--

LOCK TABLES `shop` WRITE;
/*!40000 ALTER TABLE `shop` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-19 23:56:38

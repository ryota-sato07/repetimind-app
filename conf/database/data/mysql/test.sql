CREATE DATABASE `test` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE `test`;

DROP TABLE IF EXISTS `output`;

CREATE TABLE `output` (
  `id` BIGINT(64) unsigned NOT NULL AUTO_INCREMENT,
  `title` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

LOCK TABLES `output` WRITE;
INSERT INTO `output` VALUES (1, 'Scalaの学習', 'hogehogehogehoge');
INSERT INTO `output` VALUES (2, 'Angularについて', 'okokokokokokokokokokokokok');

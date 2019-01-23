DROP TABLE IF EXISTS `example`;
CREATE TABLE `example`
(
  `id`         INT AUTO_INCREMENT,
  `value`      VARCHAR(255),
  `created_at` DATETIME(6) NOT NULL,
  PRIMARY KEY (`id`)
);


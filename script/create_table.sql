CREATE DATABASE IF NOT EXISTS `spring`
  DEFAULT CHARSET utf8
  COLLATE utf8_general_ci;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `age` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `is_married` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `message` varchar(600) NOT NULL,
  `post_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP(),
  `latitude` double NOT NULL ,
  `longitude` double NOT NULL ,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

insert into post (message,latitude,longitude) values
("message1", 14.011, 15.002),
("message2", 14.011, 15.002),
("message3", 14.011, 15.002),
("message4", 14.011, 15.002)
;

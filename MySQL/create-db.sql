DROP TABLE IF EXISTS `connect4_player_info`;

CREATE TABLE `connect4_player_info` (
  `player_id` int(100) NOT NULL AUTO_INCREMENT,
  `moves` varchar(100) DEFAULT NULL,
  `row_values` varchar(100) DEFAULT NULL,
  `winner` varchar(100) DEFAULT NULL,
  `column1_total` int(100) DEFAULT 0,
  `column2_total` int(100) DEFAULT 0,
  `column3_total` int(100) DEFAULT 0,
  `column4_total` int(100) DEFAULT 0,
  `column5_total` int(100) DEFAULT 0,
  `column6_total` int(100) DEFAULT 0,
  PRIMARY KEY (`player_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
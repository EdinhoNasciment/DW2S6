CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone` int(9) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO user (id, name, email, phone) 
	values (1, 'Fernando Duarte', 'fernandoduarte@ifsp.edu.br', 987654321);
INSERT INTO user (id, name, email, phone) 
	values (2, 'Gislaine Rosales', 'gislainerosales@ifsp.edu.br', 123456789);
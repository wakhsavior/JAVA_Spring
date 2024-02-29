--INSERT IGNORE INTO `spring`.`user` (`id`, `username`, `password`, `algorithm`) VALUES ('1', 'john', '$2a$10$xn3LI/AjqicFYZFruSwve.681477XaVNaUQbr1gioaWPn4t1KsnmG', 'BCRYPT');
--
--INSERT IGNORE INTO `spring`.`authority` (`id`, `name`, `user`) VALUES ('1', 'READ', '1');
--INSERT IGNORE INTO `spring`.`authority` (`id`, `name`, `user`) VALUES ('2', 'WRITE', '1');
--
--INSERT IGNORE INTO `spring`.`product` (`id`, `name`, `price`, `currency`) VALUES ('1', 'Chocolate', '10', 'USD');

INSERT INTO users (id, username, password,algorithm) VALUES ('1', 'john', '$2a$10$xn3LI/AjqicFYZFruSwve.681477XaVNaUQbr1gioaWPn4t1KsnmG', 'BCRYPT');
INSERT INTO users (id, username, password,algorithm) VALUES ('2', 'denis', '$2a$12$GhtqKiF9Vpn19f7iNe9KFO64xqUpIb7CVnyEizaCFKonj2eAkzh0.', 'BCRYPT');
--
INSERT INTO authority (id, name, user) VALUES ('1', 'READ', '1');
INSERT INTO authority (id, name, user) VALUES ('2', 'READ', '2');
INSERT INTO authority (id, name, user) VALUES ('3', 'WRITE', '1');
INSERT INTO authority (id, name, user) VALUES ('4', 'WRITE', '2');
--
INSERT INTO product (id, name, price, currency) VALUES ('1', 'Chocolate', '10', 'USD');

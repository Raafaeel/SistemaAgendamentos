CREATE TABLE `Usuario` (
 `id` bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
 `nome` varchar(255) NOT NULL,
 `cidade` varchar(255) DEFAULT NULL,
 `telefone` varchar(255) DEFAULT NULL,
 `email`    varchar(255) DEFAULT NULL,
 `cpf`      varchar(255) DEFAULT NULL
);
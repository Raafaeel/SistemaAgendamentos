CREATE TABLE `Servicos` (
 `id` bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
 `data` datetime(6) NOT NULL,
 `agendamento_id` bigint NOT NULL,
 `usuario_id` bigint NOT NULL,
 FOREIGN KEY (`agendamento_id`) REFERENCES `Agendamento` (`id`),
 FOREIGN KEY (`usuario_id`) REFERENCES `Usuario` (`id`)
);
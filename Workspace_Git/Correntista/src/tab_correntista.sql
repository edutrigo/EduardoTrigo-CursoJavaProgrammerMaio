CREATE TABLE `curso_java`.`correntista` (
  `cpf` VARCHAR(11) NULL,
  `nome` VARCHAR(100) NULL,
  `cep` VARCHAR(9) NULL,
  `logradouro` VARCHAR(200) NULL,
  `localidade` VARCHAR(200) NULL,
  `uf` VARCHAR(2) NULL,
  `email` VARCHAR(100) NULL,
  `qtd_transacao` INT NULL,
  `val_anuidade` DECIMAL(10,2) NULL,	/* CALCULADO */
  `limite_credito` DECIMAL(10,2) NULL,	/*PREMIUM*/
  `limite_saque` DECIMAL(10,2) NULL,	/*BASICO*/
  `tipo_correntista` VARCHAR(1) NULL COMMENT 'B=BASICO; P=PREMIUM')
ENGINE = InnoDB;


insert into correntista (cpf, nome, cep, logradouro, localidade, uf, email, qtd_transacao, val_anuidade, limite_credito, limite_saque, tipo_correntista )
values ( cpf, nome, cep, logradouro, localidade, uf, email, qtd_transacao, val_anuidade, limite_credito, limite_saque, 'B' )

delete from correntista where cpf = cpf
and tipo_correntista = 'B'


update correntista
set nome = ?
   ,cep = ?
   ,logradouro = ?
   ,localidade = ?
   ,uf = ?
   ,email = ?
   ,qtd_transacao = ?
   ,val_anuidade = ?
   ,limite_credito = ?
   ,limite_saque = ?
where cpf = ?
and tipo_correntista = ?


select cpf, nome, cep, logradouro, localidade, uf, email, qtd_transacao, val_anuidade, limite_credito, limite_saque, tipo_correntista
from correntista
where tipo_correntista = 'B'
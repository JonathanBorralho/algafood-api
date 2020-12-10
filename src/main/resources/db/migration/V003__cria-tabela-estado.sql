CREATE TABLE estado (
	id BIGINT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(80) NOT NULL,
	PRIMARY KEY (id)
) ENGINE=INNODB DEFAULT CHARSET=UTF8MB4;

alter table cidade add column estado_id bigint not null;

alter table cidade add constraint fk_cidade_estado
foreign key (estado_id) references estado (id);

alter table cidade drop column nome_estado;

alter table cidade change nome_cidade nome varchar(80) not null;

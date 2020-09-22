create schema galeria;

use galeria;

create user 'user'@'localhost' identified by 'pass123';

grant select, insert, delete, update on galeria.* to user@'localhost';

create table usr_usuario (
  usr_id bigint unsigned not null auto_increment,
  usr_nome varchar(20) not null,
  usr_senha varchar(50) not null,
  primary key (usr_id),
  unique key uni_usuario_nome (usr_nome)
);

create table aut_autorizacao (
  aut_id bigint unsigned not null auto_increment,
  aut_nome varchar(20) not null,
  primary key (aut_id),
  unique key uni_aut_nome (aut_nome)
);

create table uau_usuario_autorizacao (
  usr_id bigint unsigned not null,
  aut_id bigint unsigned not null, 
  primary key (usr_id, aut_id),
  foreign key aut_usuario_fk (usr_id) references usr_usuario (usr_id) on delete restrict on update cascade,
  foreign key aut_autorizacao_fk (aut_id) references aut_autorizacao (aut_id) on delete restrict on update cascade
);

create table doe_doenca (
  doe_id bigint unsigned not null auto_increment,
  doe_nome varchar(20) not null,
  doe_descricao varchar(50) not null,
  primary key (doe_id),
  unique key uni_doenca_nome (doe_nome)
);

create table ima_imagem (
  ima_id bigint unsigned not null auto_increment,
  ima_nome varchar(20) not null,
  ima_endereco varchar(100) not null,
  primary key (ima_id),
  unique key uni_ima_nome (ima_nome)
);

create table dim_doenca_imagem (
  doe_id bigint unsigned not null,
  ima_id bigint unsigned not null, 
  primary key (doe_id, ima_id),
  foreign key ima_doenca_fk (doe_id) references doe_doenca (doe_id) on delete restrict on update cascade,
  foreign key ima_imagem_fk (ima_id) references ima_imagem (ima_id) on delete restrict on update cascade
);


INSERT INTO usr_usuario (usr_nome, usr_senha)
  VALUES ("victor", "senha123");

INSERT INTO aut_autorizacao (aut_nome)
  VALUES ("ROLE_ADMIN");

INSERT INTO uau_usuario_autorizacao ()
  VALUES (1, 1);

INSERT INTO doe_doenca (doe_nome, doe_descricao)
  VALUES ("covid19", "doenca respiratoria");

INSERT INTO ima_imagem (ima_nome, ima_endereco)
  VALUES ("covid19", "src/main/java/br/gov/sp/fatec/springbootapp/Imagem/covid19");

INSERT INTO dim_doenca_imagem ()
  VALUES (1, 1);

INSERT INTO doe_doenca (doe_nome, doe_descricao)
  VALUES ("teste", "teste");
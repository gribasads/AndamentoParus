select * from cliente;
insert into cliente values (12312456,'maria','maria@gmail.com');
update cliente set nome ='maria malia' where cpf =12312456;
delete from cliente where cpf =12312456;

select * from curso;
insert into curso values (2,'css',300,'/css');
update curso set nome =' CSS' where url='/css';
delete from curso where url ='/css';
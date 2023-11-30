#Practica restfull producto

create database productos;
use productos;

create table producto (
 id int auto_increment primary key,
 nombre varchar(90),
 descripcion varchar(300),
 precio int(7),
 cantidad int(7)
);
select *from producto;

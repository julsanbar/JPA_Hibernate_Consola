DROP DATABASE cine; 
create database cine; 
use cine; 


/*--Salas de cine del multicine de un centro comercial*/
create table SALAS(
	codsala int primary key,
	tipo_sonido	varchar(10), /*THX, Dolby ...*/
	numfilas		int, /*Número de filas*/
	numasiporfilas	int); /*Número de asientos por filas*/

/*--Películas proyectadas en el multicine*/
create table PELICULAS(
	codpelicula int primary key,
	titulo varchar(60) not null,
	fecha_prod		date,
	genero		varchar(25));

/*--Proyecciones o pases de las películas en las salas de cine*/
create table PASES(
	codpase	int primary key,
	codsala int not null,
	codpelicula int not null,
	fecha_pase	date not null, /*--Incluye el día y la hora del pase*/
	tipo_pase	varchar(15),/* --MATINAL, TARDE, GOLFA, PAREJAS, ESPECTADOR*/
	foreign key(codsala) references SALAS(codsala),
	foreign key(codpelicula) references PELICULAS(codpelicula)
);

/*--Entradas o tickets de los pases */
create table ENTRADAS(
	codentrada int primary key,	
	numfila int,
	numenfila int,
	codpase	int,
	vendido	char(1) check (vendido in ('S','N')),
	comprador varchar(60), /*--Nombre del comprador*/
	pvp	int,	/*--Precio de la entrada*/
	foreign key(codpase) references PASES(codpase));

INSERT INTO SALAS VALUES(1, 'IMAX', 5, 10);
INSERT INTO SALAS VALUES(2, 'THX', 6, 8);
INSERT INTO SALAS VALUES(3, 'DOLBY', 10, 9);
INSERT INTO SALAS VALUES(4, '4DX', 5, 10);
INSERT INTO SALAS VALUES(5, 'DOLBY', 7, 10);
INSERT INTO SALAS VALUES(6, 'IMAX', 7, 9);
INSERT INTO SALAS VALUES(7, 'DOLBY', 6, 10);
INSERT INTO SALAS VALUES(8, 'DOLBY', 6, 10);
INSERT INTO SALAS VALUES(9, 'DOLBY', 7, 10);
INSERT INTO SALAS VALUES(10, 'DOLBY', 5, 10);

INSERT INTO PELICULAS VALUES(1, 'ABYSS', '1991-12-4', 'C.FICCION');
INSERT INTO PELICULAS VALUES(2, 'E.T.', '2015-12-4', 'C.FICCION');
INSERT INTO PELICULAS VALUES(3, 'PLATOON', '2008-12-4', 'BELICO');
INSERT INTO PELICULAS VALUES(4, 'STARWAR', '2016-12-4', 'C.FICCION');
INSERT INTO PELICULAS VALUES(5, 'ENREDO', '2016-12-4', 'COMEDIA');
INSERT INTO PELICULAS VALUES(6, 'LA FORMA DEL AGUA', '2016-12-1', 'C.FICCION');
INSERT INTO PELICULAS VALUES(7, 'IT', '2017-12-3', 'TERROR');
INSERT INTO PELICULAS VALUES(8, 'LOS GUARDIANES DE LA GALAXIA2', '2017-11-5', 'COMEDIA');
INSERT INTO PELICULAS VALUES(9, 'COCO', '2017-10-4', 'COMEDIA');
INSERT INTO PELICULAS VALUES(10, 'LA LLAMADA', '2017-09-4', 'COMEDIA');
INSERT INTO PELICULAS VALUES(11, 'LA LIGA DE LA JUSTICIA', '2017-12-4', 'ACCION');
INSERT INTO PELICULAS VALUES(12, 'LIFE', '2016-12-4', 'TERROR');
INSERT INTO PELICULAS VALUES(13, 'DUNKERQUE', '2016-12-4', 'BELICO');

/**
create table PASES(
	codpase	int primary key,
	codsala int not null,
	codpelicula int not null,
	fecha_pase	date not null, /*--Incluye el día y la hora del pase
	tipo_pase	varchar(15),/* --MATINAL, TARDE, GOLFA, PAREJAS, ESPECTADOR
	foreign key(codsala) references SALAS(codsala),
	foreign key(codpelicula) references PELICULAS(codpelicula)
);**/
INSERT INTO PASES VALUES(1, 3, 3, '2016-12-4', 'MATINAL');
INSERT INTO PASES VALUES(2, 4, 2, '2016-12-4', 'TARDE');
INSERT INTO PASES VALUES(3, 5, 3, '2016-12-5', 'MATINAL');
INSERT INTO PASES VALUES(4, 3, 2, '2016-12-5', 'MATINAL');
INSERT INTO PASES VALUES(5, 2, 4, '2016-12-5', 'GOLFA');
INSERT INTO PASES VALUES(6, 3, 5, '2016-12-5', 'ESPECTADOR');
INSERT INTO PASES VALUES(7, 3, 4, '2016-12-5', 'ESPECTADOR');
INSERT INTO PASES VALUES(8, 4, 4, '2016-12-5', 'ESPECTADOR');
INSERT INTO PASES VALUES(9, 4, 4, '2017-12-5', 'ESPECTADOR');
INSERT INTO PASES VALUES(10, 5, 6, '2017-12-5', 'ESPECTADOR');
INSERT INTO PASES VALUES(11, 4, 8, '2017-12-5', 'MATINAL');
INSERT INTO PASES VALUES(12, 4, 9, '2017-12-5', 'MATINAL');
INSERT INTO PASES VALUES(13, 4, 4, '2017-12-5', 'ESPECTADOR');

/* create table ENTRADAS(
	codentrada int primary key,	
	numfila int,
	numenfila int,
	codpase	int,
	vendido	char(1) check (vendido in ('S','N')),
	comprador varchar(60), /*--Nombre del comprador
	pvp	int,	/*--Precio de la entrada
	foreign key(codpase) references PASES(codpase)); */

INSERT INTO ENTRADAS VALUES(1, 7, 3,1, 'S','José Luis P',5);
INSERT INTO ENTRADAS VALUES(2,  7, 4,1, 'S','José Luis P',5);
INSERT INTO ENTRADAS VALUES(3,  7, 5,1, 'S','José Luis P',5);
INSERT INTO ENTRADAS VALUES(4, 7, 6,1, 'S','José Luis P',5);
INSERT INTO ENTRADAS VALUES(5,  6, 5,1, 'S','Antonio L',5);
INSERT INTO ENTRADAS VALUES(6,  6, 6,1, 'S','Antonio L',5);
INSERT INTO ENTRADAS VALUES(7,  6, 7,1, 'S','Antonio L',5);
INSERT INTO ENTRADAS VALUES(8,  7, 4,2, 'S','Luisa P',5);
INSERT INTO ENTRADAS VALUES(9,  7, 5,3, 'S','José Luis P',5);
INSERT INTO ENTRADAS VALUES(10, 7, 6,1, 'S','Rogelio P',5);
INSERT INTO ENTRADAS VALUES(11, 7, 6,3, 'S','Rogelio P',5);



COMMIT;
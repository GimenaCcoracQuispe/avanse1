/* Eliminar la base de datos si esta creada */
IF EXISTS (SELECT name FROM sys.databases WHERE name = 'db_Puntos')
    DROP DATABASE db_Puntos;

/* Crear la base de datos db_Puntos */
CREATE DATABASE db_Puntos;

/*Poner en uso db_Puntos*/
USE db_Puntos;

-- Configuración de Idioma
-- Asegúrate de que "Español" sea un idioma válido para tu sistema, en muchos sistemas se usa "Spanish" o "Español" con "ñ".
-- Cambia "SET LANGUAGE Español" a algo como "SET LANGUAGE Spanish" si es necesario.
SET LANGUAGE Español;

--Configurar el formato de fecha
SET DATEFORMAT dmy;

/*Eliminar la tabla client si ya esta creada*/
DROP TABLE client;

/*Crear tabla client*/
CREATE TABLE client (
	id int IDENTITY (1,1) NOT NULL,
	name varchar (60) NOT NULL,
	last_names varchar (90) NOT NULL,
	type_document char (3) NOT NULL,
	number_document char (10) NOT NULL,
	cellphone char (9) NOT NULL,
	email varchar (90) NOT NULL,
	birthday date NOT NULL,
	status char (1) DEFAULT 'A' NOT NULL,

	CONSTRAINT client_pk PRIMARY KEY (id)
);

----RESTRICCIONES
/* Restricciones número de celular*/
--Alterar la tabla cliente
ALTER TABLE client 
---eliminar columna
	DROP COLUMN cellphone;
		ALTER TABLE client
		ADD cellphone CHAR(9) NOT NULL CONSTRAINT cellphone_client CHECK (cellphone LIKE 
		'[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]');

/*Restricción para permitir la inserción de correos válidos*/
ALTER TABLE client
--eliminar columna
DROP email;
	ALTER TABLE client
		ADD CONSTRAINT CHK_email CHECK (
		CHARINDEX('@', email) > 1
		AND (
        RIGHT(email, 4) = '.com' OR
        RIGHT(email, 3) = '.pe'
    )
);

ALTER TABLE client
ADD CONSTRAINT CHK_number_document CHECK (
    (type_document = 'DNI' AND dbo.IsNumericString(number_document) = 1 AND LEN(number_document) = 8) OR
    (type_document = 'CNE' AND dbo.IsNumericString(number_document) = 1 AND LEN(number_document) = 15)
);


-- Insertar clientes de ejemplo--
INSERT INTO client (name, last_names, type_document, number_document, cellphone, email, birthday)
VALUES ('Alice', 'Smith', 'DNI', '12345678', '987654321', 'alice.smith@example.com', '19900101');


INSERT INTO client (name, last_names, type_document, number_document, cellphone, email, birthday)
VALUES ('Charlie', 'Brown', 'DNI', '87654321', '987654321', 'charlie.brown@example.com', '19951230');

INSERT INTO client (name, last_names, type_document, number_document, cellphone, email, birthday)
VALUES ('David', 'Lee', 'DNI', '11223344', '987654321', 'david.lee@example.com', '19870520');


INSERT INTO client (name, last_names, type_document, number_document, cellphone, email, birthday)
VALUES ('Frank', 'White', 'DNI', '55443322', '987654321', 'frank.white@example.com', '19820910');


INSERT INTO client (name, last_names, type_document, number_document, cellphone, email, birthday)
VALUES ('Henry', 'Jones', 'DNI', '99887766', '987654321', 'henry.jones@example.com', '19830425');

INSERT INTO client (name, last_names, type_document, number_document, cellphone, email, birthday)
VALUES ('Isabel', 'Davis', 'DNI', '44556677', '987654321', 'isabel.davis@example.com', '19990214');

drop table seller;
CREATE TABLE seller
( 
	id               int IDENTITY ( 1,1 ) ,
	last_name         varchar(100)  NOT NULL ,
	name			 varchar(100)  NOT NULL ,
	address			 varchar(100)  NOT NULL ,
	email            varchar(100)  NOT NULL ,
	usuario          varchar(20)  NOT NULL ,
	password           varchar(100)  NOT NULL 
)
go

SET IDENTITY_INSERT seller ON;
GO

Insert Into seller(last_name, name, address, email, usuario, password) 
Values('Aguero Ramos','EMILIO','Lima','emilio@gmail.com','eaguero','cazador');
Insert Into seller(last_name, name, address, email, usuario, password)  
Values('Sanchez Romero','KATHIA','Miraflores','kathia@yahoo.es','ksanchez','suerte');
Insert Into seller(last_name, name, address, email, usuario, password) 
Values('Lung Wong','Felix','Los Olivos','gato@hotmail.com','flung','por100pre');
Insert Into seller(last_name, name, address, email, usuario, password)  
Values('Castillo Ramos','EDUARDO','Barrios altos','lalo@gmail.com','ecastillo','hastalavista');
Insert Into seller(last_name, name, address, email, usuario, password) 
Values('Milichin Flores','LAURA','Collique','laura@usil.pe','lmilicich','turuleka');
Insert Into seller(last_name, name, address, email, usuario, password)
Values('Delgado Barrera','KENNETH','La punta','pochita@gmail.com','kdelgado','noimporta');
Insert Into seller(last_name, name, address, email, usuario, password)  
Values('Garcia Solis','JOSE ELVIS','Barranco','pepe@gmail.com','jgarcia','noselodigas');

SET IDENTITY_INSERT seller OFF;
GO

select * from seller;




--Eliminar tabla historial si ya esta creada
DROP TABLE historial;

/*Crear tabla historial*/
CREATE TABLE historial (
    id int  NOT NULL,
    code varchar(15)  NULL,
    points decimal(8,2)  NOT NULL,
    state char(1)  NOT NULL,
    state_delivery char(1)  NULL,
    state_points char(1)  NOT NULL,
    client_code char(6)  NOT NULL,
    product_code char(6)  NOT NULL,
    CONSTRAINT historial_pk PRIMARY KEY  (id)
);

--Eliminar tabla historial si ya esta creada
DROP TABLE product;

/*Crear tabla product*/
CREATE TABLE product (
    code char(6)  NOT NULL,
    description varchar(90)  NOT NULL,
    stock int  NOT NULL,
    points decimal(8,2)  NOT NULL,
    name varchar(20)  NOT NULL,
    type varchar(3)  NOT NULL,
    brand varchar(30)  NOT NULL,
    state char(1)  NOT NULL,
    CONSTRAINT product_pk PRIMARY KEY  (code)
)
GO


/*Crear tabla producto_detail*/
CREATE TABLE product_detail (
    id int  NOT NULL,
    detail varchar(200)  NOT NULL,
    product_code char(6)  NOT NULL,
    CONSTRAINT product_detail_pk PRIMARY KEY  (id)
);

-- foreign keys
-- Reference: historial_client (table: historial)
ALTER TABLE historial ADD CONSTRAINT historial_client
    FOREIGN KEY (client_code)
    REFERENCES client (code);

-- Reference: historial_product (table: historial)
ALTER TABLE historial ADD CONSTRAINT historial_product
    FOREIGN KEY (product_code)
    REFERENCES product (code);

-- Reference: product_detail_product (table: product_detail)
ALTER TABLE product_detail ADD CONSTRAINT product_detail_product
    FOREIGN KEY (product_code)
    REFERENCES product (code);

-- End of file.
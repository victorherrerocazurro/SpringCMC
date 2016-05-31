CREATE SCHEMA PORTALPAREJAS;

CREATE TABLE PORTALPAREJAS.PERSONAS(
	IDPERSONA BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), 
	NOMBRE VARCHAR(25) NOT NULL,
	ALTURA DOUBLE NOT NULL,
	EDAD INT NOT NULL,
	GENERO CHAR NOT NULL,
	CONSTRAINT PERSONAS_PK
	PRIMARY KEY (IDPERSONA));

DROP TABLE PORTALPAREJAS.PERSONAS;
/*
Parte Roja
*/

--Creacion del esquema
DROP SCHEMA IF EXISTS public CASCADE;
CREATE SCHEMA public;

/*
Creacion de tablas
*/

--Con llaves foraneas

CREATE TABLE consultaNormal(
	idConsulta INT NOT NULL UNIQUE,
	idMascota INT NOT NULL UNIQUE,
	idRecibo INT NOT NULL UNIQUE,
	motivo VARCHAR(500) NOT NULL CHECK(motivo <> ''),
	fechaNuevaRevision DATE CHECK(fechaNuevaRevision > '2022-04-20'),
	estadoDeSalud VARCHAR(500) NOT NULL CHECK(estadoDeSalud <> ''),
	precio INT NOT NULL
);

CREATE TABLE consultaEmergencia(
	idConsulta INT NOT NULL UNIQUE,
	idMascota INT NOT NULL UNIQUE,
	idRecibo INT NOT NULL UNIQUE,
	procedimientoEmitido motivo VARCHAR(1000) NOT NULL CHECK(procedimientoEmitido <> ''),
	sintomas VARCHAR(500) NOT NULL CHECK(sintomas <> ''),
	codigoVerde BOOLEAN NOT NULL,
	codigoAmarillo BOOLEAN NOT NULL,
	codigoRojo BOOLEAN NOT NULL,
	precio INT NOT NULL
);

CREATE TABLE producto(
	idConsulta INT NOT NULL UNIQUE,
	idRecibo INT NOT NULL UNIQUE,
	nombre VARCHAR(100) NOT NULL CHECK(nombre <> ''),
	descripcion VARCHAR(500) NOT NULL CHECK(descripcion <> ''),
	cantidadDisponible INT NOT NULL,
	nombreDeLaImagen VARCHAR(100) NOT NULL CHECK(nombreDeLaImagen <> ''),
	fechaDeCaducidadComida DATE CHECK(fechaDeCaducidadComida > '2022-04-20'),
	fechaDeCaducidadMedicamento DATE CHECK(fechaDeCaducidadMedicamento > '2022-04-20'),
	precio INT NOT NULL,
	esJuguetes BOOLEAN NOT NULL,
	esMedicamentos BOOLEAN NOT NULL,
	esAccesorios BOOLEAN NOT NULL,
	esComida BOOLEAN NOT NULL
);

CREATE TABLE servicioEstetica(
	idConsulta INT NOT NULL UNIQUE,
	idMascota INT NOT NULL UNIQUE,
	idRecibo INT NOT NULL UNIQUE,
	precio INT NOT NULL
);

CREATE TABLE darConsultaNormal(
	curp CHAR(18) NOT NULL UNIQUE CHECK(CHAR_LENGTH(curp) = 18),
	idConsulta INT NOT NULL UNIQUE
);

/*
Integridad Referencial
*/

--Llaves foraneas

ALTER TABLE consultaNormal ADD CONSTRAINT consultaNormal_pkey PRIMARY KEY (idConsulta);
ALTER TABLE consultaNormal ADD CONSTRAINT consultaNormal_fkey1 FOREIGN KEY (idMascota)
REFERENCES mascota(idMascota);
ALTER TABLE consultaNormal ADD CONSTRAINT consultaNormal_fkey2 FOREIGN KEY (idRecibo)
REFERENCES recibo(idRecibo);

ALTER TABLE consultaEmergencia ADD CONSTRAINT consultaEmergencia_pkey PRIMARY KEY (idConsulta);
ALTER TABLE consultaEmergencia ADD CONSTRAINT consultaEmergencia_fkey1 FOREIGN KEY (idMascota)
REFERENCES mascota(idMascota);
ALTER TABLE consultaEmergencia ADD CONSTRAINT consultaEmergencia_fkey2 FOREIGN KEY (idRecibo)
REFERENCES recibo(idRecibo);

ALTER TABLE producto ADD CONSTRAINT producto_pkey PRIMARY KEY (idConsulta);
ALTER TABLE producto ADD CONSTRAINT producto_fkey FOREIGN KEY (idRecibo)
REFERENCES recibo(idRecibo);

ALTER TABLE servicioEstetica ADD CONSTRAINT servicioEstetica_pkey PRIMARY KEY (idConsulta);
ALTER TABLE servicioEstetica ADD CONSTRAINT servicioEstetica_fkey1 FOREIGN KEY (idMascota)
REFERENCES mascota(idMascota);
ALTER TABLE servicioEstetica ADD CONSTRAINT servicioEstetica_fkey2 FOREIGN KEY (idRecibo)
REFERENCES recibo(idRecibo);

ALTER TABLE darConsultaNormal ADD CONSTRAINT darConsultaNormal_fkey1 FOREIGN KEY (curp)
REFERENCES veterinarios(curp);
ALTER TABLE darConsultaNormal ADD CONSTRAINT darConsultaNormal_fkey2 FOREIGN KEY (idConsulta)
REFERENCES consultaNormal(idConsulta);

/*
Parte Amarilla
*/

CREATE TABLE supervisar(
	idEstetica INT NOT NULL UNIQUE,
	curp CHAR(18) NOT NULL UNIQUE CHECK(CHAR_LENGTH(curp) = 18),
	nombre VARCHAR(100) NOT NULL CHECK(nombre <> ''),
	estado VARCHAR(100) NOT NULL CHECK(estado <> ''),
	calle VARCHAR(100) NOT NULL CHECK(calle <> ''),
	numero INT NOT NULL,
	codigoPostal INT NOT NULL,
	telefono INT NOT NULL,
	horario TIME NOT NULL,
	apartado VARCHAR(100) NOT NULL CHECK(apartado <> ''),
	consultorios VARCHAR(100) NOT NULL CHECK(consultorios <> ''),
	nombreTrabajador VARCHAR(100) NOT NULL CHECK(nombreTrabajador <> ''),
	apellidoPaternoTrabajador VARCHAR(100) NOT NULL CHECK(apellidoPaternoTrabajador <> ''),
	apellidoMaternoTrabajador VARCHAR(100) NOT NULL CHECK(apellidoMaternoTrabajador <> ''),
	estadoTrabajador VARCHAR(100) NOT NULL CHECK(estadoTrabajador <> ''),
	calleTrabajador VARCHAR(100) NOT NULL CHECK(calleTrabajador <> ''),
	numeroTrabajador INT NOT NULL,
	codigoPostalTrabajador INT NOT NULL,
	salario INT NOT NULL,
	fechaDeNacimientoTrabajador DATE CHECK(fechaDeNacimientoTrabajador > '2000-10-01'),
	generoTrabajador VARCHAR(100) NOT NULL CHECK(generoTrabajador <> ''),
	rfcTrabajador VARCHAR(100) NOT NULL CHECK(rfcTrabajador <> ''),
	horaEntradaTrabajador TIME NOT NULL,
	horaSalidaTrabajador TIME NOT NULL
);

CREATE TABLE estetica(
	idEstetica INT NOT NULL UNIQUE,
	nombre VARCHAR(100) NOT NULL CHECK(nombre <> ''),
	telefono INT NOT NULL,
	horario TIME NOT NULL,
	apartado VARCHAR(100) NOT NULL CHECK(apartado <> ''),
	consultorios VARCHAR(100) NOT NULL CHECK(consultorios <> ''),
	estado VARCHAR(100) NOT NULL CHECK(estado <> ''),
	calle VARCHAR(100) NOT NULL CHECK(calle <> ''),
	numero INT NOT NULL,
	codigoPostal INT NOT NULL
);

CREATE TABLE mascota(
	idMascota INT NOT NULL UNIQUE,
	curp CHAR(18) NOT NULL UNIQUE CHECK(CHAR_LENGTH(curp) = 18),
	nombre VARCHAR(100) NOT NULL CHECK(nombre <> ''),
	especie VARCHAR(100) NOT NULL CHECK(especie <> ''),
	raza VARCHAR(100) NOT NULL CHECK(raza <> ''),
	nombreDelDueno VARCHAR(100) NOT NULL CHECK(nombreDelDueno <> ''),
	edad INT NOT NULL,
	peso INT NOT NULL
);

/*
Integridad Referencial Amarillo
*/
ALTER TABLE cuidar ADD CONSTRAINT cuidar_fkey1 FOREIGN KEY (idEstetica)
REFERENCES estetica(idEstetica);
ALTER TABLE cuidar ADD CONSTRAINT cuidar_fkey2 FOREIGN KEY (idMascota)
REFERENCES mascota(idMascota);

ALTER TABLE cortar ADD CONSTRAINT cortar_fkey1 FOREIGN KEY (idConsulta)
REFERENCES servicioEstetica(idConsulta);
ALTER TABLE cortar ADD CONSTRAINT cortar_fkey2 FOREIGN KEY (curp)
REFERENCES veterinarios(curp);

ALTER TABLE darConsultaEmergencia ADD CONSTRAINT darConsultaEmergencia_fkey1 FOREIGN KEY (curp)
REFERENCES veterinarios(curp);
ALTER TABLE darConsultaEmergencia ADD CONSTRAINT darConsultaEmergencia_fkey2 FOREIGN KEY (idConsulta)
REFERENCES consultaEmergencia(idConsulta);

ALTER TABLE estetica ADD CONSTRAINT estetica_pkey PRIMARY KEY (idEstetica);

ALTER TABLE supervisar ADD CONSTRAINT supervisar_fkey1 FOREIGN KEY (idEstetica)
REFERENCES estetica(idEstetica);
ALTER TABLE supervisar ADD CONSTRAINT supervisar_fkey2 FOREIGN KEY (curp)
REFERENCES supervisor(curp);

ALTER TABLE mascota ADD CONSTRAINT mascota_pkey PRIMARY KEY (idMascota);
ALTER TABLE mascota ADD CONSTRAINT mascota_fkey1 FOREIGN KEY (curp)
REFERENCES telefono(curp);
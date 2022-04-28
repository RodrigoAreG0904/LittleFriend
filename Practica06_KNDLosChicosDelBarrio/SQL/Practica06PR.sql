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
	procedimientoEmitido VARCHAR(1000) NOT NULL CHECK(procedimientoEmitido <> ''),
	motivo VARCHAR(1000) NOT NULL CHECK(procedimientoEmitido <> ''),
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
	salarioTrabajador INT NOT NULL,
	fechaDeNacimientoTrabajador DATE NOT NULL,
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

CREATE TABLE cuidar(
	idEstetica INT NOT NULL UNIQUE,
	idMascota INT NOT NULL UNIQUE
);

CREATE TABLE cortar(
	idConsulta INT NOT NULL UNIQUE,
	curp CHAR(18) NOT NULL UNIQUE CHECK(CHAR_LENGTH(curp) = 18)
);

CREATE TABLE darConsultaEmergencia(
	curp CHAR(18) NOT NULL UNIQUE CHECK(CHAR_LENGTH(curp) = 18),
	idConsulta INT NOT NULL UNIQUE
);

/*
Parte Verde
*/
CREATE TABLE estilistas(
	curp CHAR(18) NOT NULL UNIQUE CHECK(CHAR_LENGTH(curp) = 18),
	idEstetica INT NOT NULL UNIQUE,
	nombreTrabajador VARCHAR(100) NOT NULL CHECK(nombreTrabajador <> ''),
	apellidoPaternoTrabajador VARCHAR(100) NOT NULL CHECK(apellidoPaternoTrabajador <> ''),
	apellidoMaternoTrabajador VARCHAR(100) NOT NULL CHECK(apellidoMaternoTrabajador <> ''),
	estadoTrabajador VARCHAR(100) NOT NULL CHECK(estadoTrabajador <> ''),
	calleTrabajador VARCHAR(100) NOT NULL CHECK(calleTrabajador <> ''),
	numeroTrabajador INT NOT NULL,
	codigoPostalTrabajador INT NOT NULL,
	salarioTrabajador INT NOT NULL,
	fechaDeNacimientoTrabajador DATE CHECK(fechaDeNacimientoTrabajador > '2000-10-01'),
	generoTrabajador VARCHAR(100) NOT NULL CHECK(generoTrabajador <> ''),
	numeroDeCertificadoTrabajador INT NOT NULL
);

CREATE TABLE telefonoEstilistas(
	curp CHAR(18) NOT NULL CHECK(CHAR_LENGTH(curp)=18),
	telefonoEstilistas CHAR(10) CHECK (telefonoEstilistas SIMILAR TO '[0-9]*')
);

CREATE TABLE veterinarios(
	curp CHAR(18) NOT NULL UNIQUE CHECK(CHAR_LENGTH(curp) = 18),
	idEstetica INT NOT NULL UNIQUE,
	nombreTrabajador VARCHAR(100) NOT NULL CHECK(nombreTrabajador <> ''),
	apellidoPaternoTrabajador VARCHAR(100) NOT NULL CHECK(apellidoPaternoTrabajador <> ''),
	apellidoMaternoTrabajador VARCHAR(100) NOT NULL CHECK(apellidoMaternoTrabajador <> ''),
	estadoTrabajador VARCHAR(100) NOT NULL CHECK(estadoTrabajador <> ''),
	calleTrabajador VARCHAR(100) NOT NULL CHECK(calleTrabajador <> ''),
	numeroTrabajador INT NOT NULL,
	codigoPostalTrabajador INT NOT NULL,
	salarioTrabajador INT NOT NULL,
	fechaDeNacimientoTrabajador DATE CHECK(fechaDeNacimientoTrabajador > '2000-10-01'),
	generoTrabajador VARCHAR(100) NOT NULL CHECK(generoTrabajador <> ''),
	rfcTrabajador VARCHAR(100) NOT NULL CHECK(rfcTrabajador <> ''),
	numeroDePacientesActivosTrabajador INT NOT NULL, 
	horaEntradaTrabajador TIME NOT NULL,
	horaSalidaTrabajador TIME NOT NULL
);

CREATE TABLE telefonoVeterinarios(
	curp CHAR(18) NOT NULL CHECK(CHAR_LENGTH(curp)=18),
	telefonoVeterinarios CHAR(10) CHECK (telefonoVeterinarios SIMILAR TO '[0-9]*')
);

CREATE TABLE supervisor(
	curp CHAR(18) NOT NULL UNIQUE CHECK(CHAR_LENGTH(curp) = 18),
	idEstetica INT NOT NULL UNIQUE,
	nombreTrabajador VARCHAR(100) NOT NULL CHECK(nombreTrabajador <> ''),
	apellidoPaternoTrabajador VARCHAR(100) NOT NULL CHECK(apellidoPaternoTrabajador <> ''),
	apellidoMaternoTrabajador VARCHAR(100) NOT NULL CHECK(apellidoMaternoTrabajador <> ''),
	estadoTrabajador VARCHAR(100) NOT NULL CHECK(estadoTrabajador <> ''),
	calleTrabajador VARCHAR(100) NOT NULL CHECK(calleTrabajador <> ''),
	numeroTrabajador INT NOT NULL,
	codigoPostalTrabajador INT NOT NULL,
	salarioTrabajador INT NOT NULL,
	fechaDeNacimientoTrabajador DATE CHECK(fechaDeNacimientoTrabajador > '2000-10-01'),
	generoTrabajador VARCHAR(100) NOT NULL CHECK(generoTrabajador <> ''),
	rfcTrabajador VARCHAR(100) NOT NULL CHECK(rfcTrabajador <> ''),
	horaEntradaTrabajador TIME NOT NULL,
	horaSalidaTrabajador TIME NOT NULL
);

CREATE TABLE telefonoSupervisor(
	curp CHAR(18) NOT NULL CHECK(CHAR_LENGTH(curp)=18),
	telefonoSupervisor CHAR(10) CHECK (telefonoSupervisor SIMILAR TO '[0-9]*')
);

/*
Parte Azul
*/

CREATE TABLE telefonoDuenio(
	curp CHAR(18) NOT NULL CHECK(CHAR_LENGTH(curp)=18),
	telefonoDuenio CHAR(10) CHECK (telefonoSupervisor SIMILAR TO '[0-9]*')
);

CREATE TABLE felicitar(
	curp CHAR(18) NOT NULL UNIQUE CHECK(CHAR_LENGTH(curp) = 18),
	idEstetica INT NOT NULL UNIQUE
);

CREATE TABLE duenio(
	curp CHAR(18) NOT NULL UNIQUE CHECK(CHAR_LENGTH(curp) = 18),
	idEstetica INT NOT NULL UNIQUE,
	nombreDuenio VARCHAR(100) NOT NULL CHECK(nombreDuenio <> ''),
	apellidoPaternoDuenio VARCHAR(100) NOT NULL CHECK(apellidoPaternoDuenio <> ''),
	apellidoMaternoDuenio VARCHAR(100) NOT NULL CHECK(apellidoMaternoDuenio <> ''),
	correoDuenio VARCHAR(20) NOT NULL CHECK(correoDuenio <>''),
	estadoDuenio VARCHAR(100) NOT NULL CHECK(estadoDuenio <> ''),
	calleDuenio VARCHAR(100) NOT NULL CHECK(calleDuenio <> ''),
	numeroDuenio INT NOT NULL,
	codigoPostalDuenio INT NOT NULL
);

CREATE TABLE tarjeta(
	numeroTarjeta INT NOT NULL UNIQUE,
	curp CHAR(18) NOT NULL UNIQUE CHECK(CHAR_LENGTH(curp) = 18),
	nombrePropietario VARCHAR(100) NOT NULL CHECK(nombrePropietario <> ''),
	vencimiento DATE NOT NULL CHECK(CURRENT_DATE <= vencimiento)
);

CREATE TABLE efectvo(
	numeroDeSerie INT NOT NULL UNIQUE,
	curp CHAR(18) NOT NULL UNIQUE CHECK(CHAR_LENGTH(curp) = 18)
);

/*
Integridad Referencial Roja
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
Integridad Referencial Amarillo
*/
ALTER TABLE cuidar ADD CONSTRAINT cuidar_fkey1 FOREIGN KEY (idEstetica)
REFERENCES estetica(idEstetica);
ALTER TABLE cuidar ADD CONSTRAINT cuidar_fkey2 FOREIGN KEY (idMascota)
REFERENCES mascota(idMascota);

ALTER TABLE cortar ADD CONSTRAINT cortar_fkey1 FOREIGN KEY (idConsulta)
REFERENCES servicioEstetica(idConsulta);
ALTER TABLE cortar ADD CONSTRAINT cortar_fkey2 FOREIGN KEY (curp)
REFERENCES estilistas(curp);

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
REFERENCES duenio(curp);

/*
Integridad Referencial Verde
*/

ALTER TABLE estilistas ADD CONSTRAINT estilistas_pkey PRIMARY KEY (curp);
ALTER TABLE estilistas ADD CONSTRAINT estilistas_fkey FOREIGN KEY (idEstetica)
REFERENCES estetica(idEstetica);

ALTER TABLE veterinarios ADD CONSTRAINT veterinarios_pkey PRIMARY KEY (curp);
ALTER TABLE veterinarios ADD CONSTRAINT veterinarios_fkey FOREIGN KEY (idEstetica)
REFERENCES estetica(idEstetica);

ALTER TABLE supervisor ADD CONSTRAINT supervisor_pkey PRIMARY KEY (curp);
ALTER TABLE supervisor ADD CONSTRAINT supervisor_fkey FOREIGN KEY (idEstetica)
REFERENCES estetica(idEstetica);

ALTER TABLE telefonoEstilistas ADD CONSTRAINT telefonoEstilistas_pkey PRIMARY KEY (curp,telefonoEstilistas);
ALTER TABLE telefonoEstilistas ADD CONSTRAINT telefonoEstilistas_fkey FOREIGN KEY (curp)
REFERENCES estilistas (curp);

ALTER TABLE telefonoVeterinarios ADD CONSTRAINT telefonoVeterinarios_pkey PRIMARY KEY (curp,telefonoVeterinarios);
ALTER TABLE telefonoVeterinarios ADD CONSTRAINT telefonoVeterinarios_fkey FOREIGN KEY (curp)
REFERENCES veterinarios (curp);

ALTER TABLE telefonoSupervisor ADD CONSTRAINT telefonoSupervisor_pkey PRIMARY KEY (curp,telefonoSupervisor);
ALTER TABLE telefonoSupervisor ADD CONSTRAINT telefonoSupervisor_fkey FOREIGN KEY (curp)
REFERENCES supervisor (curp);

/*
Integridad Referencial Azul
*/

ALTER TABLE telefonoDuenio ADD CONSTRAINT telefonoDuenio_pkey PRIMARY KEY (curp,telefonoDuenio);

ALTER TABLE felicitar ADD CONSTRAINT felicitar_fkey FOREIGN KEY (curp)
REFERENCES duenio (curp);
ALTER TABLE felicitar ADD CONSTRAINT felicitar_fkey FOREIGN KEY (idEstetica)
REFERENCES estetica(idEstetica);

ALTER TABLE duenio ADD CONSTRAINT duenio_pkey PRIMARY KEY (curp,duenio);
ALTER TABLE duenio ADD CONSTRAINT duenio_fkey FOREIGN KEY (idEstetica)
REFERENCES estetica(idEstetica);

ALTER TABLE tarjeta ADD CONSTRAINT tarjeta_pkey PRIMARY KEY (numeroTarjeta,tarjeta);
ALTER TABLE tarjeta ADD CONSTRAINT tarjeta_fkey FOREIGN KEY (curp)
REFERENCES duenio(curp);

ALTER TABLE efectivo ADD CONSTRAINT efectivo_pkey PRIMARY KEY (numeroDeSerie,efectivo);
ALTER TABLE efectivo ADD CONSTRAINT efectivo_fkey FOREIGN KEY (curp)
REFERENCES duenio(curp);
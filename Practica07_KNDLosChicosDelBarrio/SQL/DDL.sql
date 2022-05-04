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
	idMascota INT NOT NULL,
	idRecibo INT NOT NULL,
	motivo VARCHAR(500) NOT NULL CHECK(motivo <> ''),
	fechaNuevaRevision DATE CHECK(fechaNuevaRevision > '2022-04-20'),
	estadoDeSalud VARCHAR(500) NOT NULL CHECK(estadoDeSalud <> ''),
	precio INT NOT NULL
);

COMMENT ON TABLE consultaNormal IS 'Tabla que contiene la informacion de las consultas normales';
COMMENT ON COLUMN consultaNormal.idConsulta IS 'El id de la consulta';
COMMENT ON COLUMN consultaNormal.idMascota IS 'El id de la mascota';
COMMENT ON COLUMN consultaNormal.idRecibo IS 'El id del recibo';
COMMENT ON COLUMN consultaNormal.motivo IS 'El motivo por el cual la mascota tiene la consulta';
COMMENT ON COLUMN consultaNormal.fechaNuevaRevision IS 'La fecha nueva de su revision';
COMMENT ON COLUMN consultaNormal.estadoDeSalud IS 'El estado de salud de la mascota';
COMMENT ON COLUMN consultaNormal.precio IS 'El precio de la consulta';

CREATE TABLE consultaEmergencia(
	idConsulta INT NOT NULL UNIQUE,
	idMascota INT NOT NULL,
	idRecibo INT NOT NULL,
	procedimientoEmitido TEXT NOT NULL CHECK(procedimientoEmitido <> ''),
	sintomas VARCHAR(500) NOT NULL CHECK(sintomas <> ''),
	codigoVerde BOOLEAN NOT NULL,
	codigoAmarillo BOOLEAN NOT NULL,
	codigoRojo BOOLEAN NOT NULL,
	precio INT NOT NULL
);

COMMENT ON TABLE consultaEmergencia IS 'Tabla que contiene la informacion de las consultas de emergencia';
COMMENT ON COLUMN consultaEmergencia.idConsulta IS 'El id de la consulta';
COMMENT ON COLUMN consultaEmergencia.idMascota IS 'El id de la mascota';
COMMENT ON COLUMN consultaEmergencia.idRecibo IS 'El id del recibo';
COMMENT ON COLUMN consultaEmergencia.procedimientoEmitido IS 'Es el procedimiento emitido a la mascota';
COMMENT ON COLUMN consultaEmergencia.sintomas IS 'Los sintomas que presenta la mascota';
COMMENT ON COLUMN consultaEmergencia.codigoVerde IS 'La consulta es un codigo verde';
COMMENT ON COLUMN consultaEmergencia.codigoAmarillo IS 'La consulta es un codigo amarillo';
COMMENT ON COLUMN consultaEmergencia.codigoRojo IS 'La consulta es un codigo rojo';
COMMENT ON COLUMN consultaEmergencia.precio IS 'El precio de la consulta';

CREATE TABLE producto(
	idProducto INT NOT NULL UNIQUE,
	idRecibo INT NOT NULL,
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

COMMENT ON TABLE producto IS 'Tabla que contiene la informacion de los productos';
COMMENT ON COLUMN producto.idProducto IS 'El id del producto';
COMMENT ON COLUMN producto.idRecibo IS 'El id del recibo';
COMMENT ON COLUMN producto.nombre IS 'El nombre del producto';
COMMENT ON COLUMN producto.descripcion IS 'La descripcion del producto';
COMMENT ON COLUMN producto.cantidadDisponible IS 'Cantidad disponible del producto';
COMMENT ON COLUMN producto.nombreDeLaImagen IS 'Nombre de la imagen del producto';
COMMENT ON COLUMN producto.fechaDeCaducidadComida IS 'La fecha de caducidad de la comida';
COMMENT ON COLUMN producto.fechaDeCaducidadMedicamento IS 'La fecha de caducidad del medicamento';
COMMENT ON COLUMN producto.precio IS 'El precio del producto';
COMMENT ON COLUMN producto.esJuguetes IS 'El producto es un juguete';
COMMENT ON COLUMN producto.esMedicamentos IS 'El producto es un medicamento';
COMMENT ON COLUMN producto.esAccesorios IS 'El producto es un accesorio';
COMMENT ON COLUMN producto.esComida IS 'El producto es comida';


CREATE TABLE servicioEstetica(
	idConsulta INT NOT NULL UNIQUE,
	idMascota INT NOT NULL,
	idRecibo INT NOT NULL,
	precio INT NOT NULL
);

COMMENT ON TABLE servicioEstetica IS 'Tabla que contiene la informacion del servicio de la estetica';
COMMENT ON COLUMN servicioEstetica.idConsulta IS 'El id de la consulta';
COMMENT ON COLUMN servicioEstetica.idMascota IS 'El id de la mascota';
COMMENT ON COLUMN servicioEstetica.idRecibo IS 'El id del recibo';
COMMENT ON COLUMN servicioEstetica.precio IS 'El precio del servicio de la estetica';

CREATE TABLE darConsultaNormal(
	curp CHAR(18) NOT NULL CHECK(CHAR_LENGTH(curp) = 18),
	idConsulta INT NOT NULL
);

COMMENT ON TABLE darConsultaNormal IS 'Tabla que contiene la informacion de la relacion dar consulta normal';
COMMENT ON COLUMN darConsultaNormal.idConsulta IS 'El id de la consulta';
COMMENT ON COLUMN darConsultaNormal.curp IS 'El curp del duenio';

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
	nombreDelDuenio VARCHAR(100) NOT NULL CHECK(nombreDelDuenio <> ''),
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
	telefonoDuenio CHAR(10) CHECK (telefonoDuenio SIMILAR TO '[0-9]*')
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

CREATE TABLE efectivo(
	numeroDeSerie INT NOT NULL UNIQUE,
	curp CHAR(18) NOT NULL UNIQUE CHECK(CHAR_LENGTH(curp) = 18)
);

CREATE TABLE recibo(
	idRecibo INT NOT NULL UNIQUE,
	curp CHAR(18) NOT NULL UNIQUE CHECK(CHAR_LENGTH(curp) = 18),
	nombreDuenio VARCHAR(100) NOT NULL CHECK(nombreDuenio <> ''),
	nombreTrabajador VARCHAR(100) NOT NULL CHECK(nombreDuenio <> ''),
	nombreMascota VARCHAR(100) NOT NULL CHECK(nombreDuenio <> '')
);

/*
Integridad Referencial Roja
*/

--Llaves foraneas

ALTER TABLE consultaNormal ADD CONSTRAINT consultaNormal_pkey PRIMARY KEY (idConsulta);
COMMENT ON CONSTRAINT consultaNormal_pkey ON consultaNormal IS 'La llave primaria de la tabla consultaNormal';
ALTER TABLE consultaNormal ADD CONSTRAINT consultaNormal_fkey1 FOREIGN KEY (idMascota)
REFERENCES mascota(idMascota)/*ON UPDATE  ON DELETE*/;
COMMENT ON CONSTRAINT consultaNormal_fkey1 ON consultaNormal IS 'La llave foranea de la tabla consultaNormal que referencia a mascota';
ALTER TABLE consultaNormal ADD CONSTRAINT consultaNormal_fkey2 FOREIGN KEY (idRecibo)
REFERENCES recibo(idRecibo)/*ON UPDATE  ON DELETE*/;
COMMENT ON CONSTRAINT consultaNormal_fkey2 ON consultaNormal IS 'La llave foranea de la tabla consultaNormal que referencia a recibo';

ALTER TABLE consultaEmergencia ADD CONSTRAINT consultaEmergencia_pkey PRIMARY KEY (idConsulta);
COMMENT ON CONSTRAINT consultaEmergencia_pkey ON consultaEmergencia IS 'La llave primaria de la tabla consultaEmergencia';
ALTER TABLE consultaEmergencia ADD CONSTRAINT consultaEmergencia_fkey1 FOREIGN KEY (idMascota)
REFERENCES mascota(idMascota)/*ON UPDATE  ON DELETE*/;
COMMENT ON CONSTRAINT consultaEmergencia_fkey1 ON consultaEmergencia IS 'La llave foranea de la tabla consultaEmergencia que referencia a mascota';
ALTER TABLE consultaEmergencia ADD CONSTRAINT consultaEmergencia_fkey2 FOREIGN KEY (idRecibo)
REFERENCES recibo(idRecibo)/*ON UPDATE  ON DELETE*/;
COMMENT ON CONSTRAINT consultaEmergencia_fkey2 ON consultaEmergencia IS 'La llave foranea de la tabla consultaEmergencia que referencia a recibo';

ALTER TABLE producto ADD CONSTRAINT producto_pkey PRIMARY KEY (idProducto);
COMMENT ON CONSTRAINT producto_pkey ON producto IS 'La llave primaria de la tabla producto';
ALTER TABLE producto ADD CONSTRAINT producto_fkey FOREIGN KEY (idRecibo)
REFERENCES recibo(idRecibo)/*ON UPDATE  ON DELETE*/;
COMMENT ON CONSTRAINT producto_fkey ON producto IS 'La llave foranea de la tabla producto que referencia a recibo';

ALTER TABLE servicioEstetica ADD CONSTRAINT servicioEstetica_pkey PRIMARY KEY (idConsulta);
COMMENT ON CONSTRAINT servicioEstetica_pkey ON servicioEstetica IS 'La llave primaria de la tabla servicioEstetica';
ALTER TABLE servicioEstetica ADD CONSTRAINT servicioEstetica_fkey1 FOREIGN KEY (idMascota)
REFERENCES mascota(idMascota)/*ON UPDATE  ON DELETE*/;
COMMENT ON CONSTRAINT servicioEstetica_fkey1 ON servicioEstetica IS 'La llave foranea de la tabla servicioEstetica que referencia a mascota';
ALTER TABLE servicioEstetica ADD CONSTRAINT servicioEstetica_fkey2 FOREIGN KEY (idRecibo)
REFERENCES recibo(idRecibo)/*ON UPDATE  ON DELETE*/;
COMMENT ON CONSTRAINT servicioEstetica_fkey2 ON servicioEstetica IS 'La llave foranea de la tabla servicioEstetica que referencia a recibo';

ALTER TABLE darConsultaNormal ADD CONSTRAINT darConsultaNormal_fkey1 FOREIGN KEY (curp)
REFERENCES veterinarios(curp)/*ON UPDATE  ON DELETE*/;
COMMENT ON CONSTRAINT darConsultaNormal_fkey1 ON darConsultaNormal IS 'La llave foranea de la tabla darConsultaNormal que referencia a veterinarios';
ALTER TABLE darConsultaNormal ADD CONSTRAINT darConsultaNormal_fkey2 FOREIGN KEY (idConsulta)
REFERENCES consultaNormal(idConsulta)/*ON UPDATE  ON DELETE*/;
COMMENT ON CONSTRAINT darConsultaNormal_fkey2 ON darConsultaNormal IS 'La llave foranea de la tabla darConsultaNormal que referencia a consultaNormal';

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

ALTER TABLE felicitar ADD CONSTRAINT felicitar_fkey1 FOREIGN KEY (curp)
REFERENCES duenio (curp);
ALTER TABLE felicitar ADD CONSTRAINT felicitar_fkey2 FOREIGN KEY (idEstetica)
REFERENCES estetica(idEstetica);

ALTER TABLE duenio ADD CONSTRAINT duenio_pkey PRIMARY KEY (curp);
ALTER TABLE duenio ADD CONSTRAINT duenio_fkey FOREIGN KEY (idEstetica)
REFERENCES estetica(idEstetica);

ALTER TABLE tarjeta ADD CONSTRAINT tarjeta_pkey PRIMARY KEY (numeroTarjeta);
ALTER TABLE tarjeta ADD CONSTRAINT tarjeta_fkey FOREIGN KEY (curp)
REFERENCES duenio(curp);

ALTER TABLE efectivo ADD CONSTRAINT efectivo_pkey PRIMARY KEY (numeroDeSerie);
ALTER TABLE efectivo ADD CONSTRAINT efectivo_fkey FOREIGN KEY (curp)
REFERENCES duenio(curp);

ALTER TABLE recibo ADD CONSTRAINT recibo_pkey PRIMARY KEY (idRecibo);
ALTER TABLE recibo ADD CONSTRAINT recibo_fkey FOREIGN KEY (curp)
REFERENCES duenio(curp);

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
	idConsulta INT NOT NULL,
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
COMMENT ON COLUMN producto.idConsulta IS 'El id de la consulta';
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
	curp CHAR(18) NOT NULL CHECK(CHAR_LENGTH(curp) = 18),
	nombre VARCHAR(100) NOT NULL CHECK(nombre <> ''),
	estado VARCHAR(100) NOT NULL CHECK(estado <> ''),
	calle VARCHAR(100) NOT NULL CHECK(calle <> ''),
	numero INT NOT NULL,
	codigoPostal INT NOT NULL,
	telefono CHAR(10) NOT NULL CHECK (telefono SIMILAR TO '[0-9]*'),
	horario TIME NOT NULL,
	apartado VARCHAR(100) NOT NULL CHECK(apartado <> ''),
	consultorios INT NOT NULL,
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

COMMENT ON TABLE supervisar IS 'Tabla que contiene la informacion de la relacion supervisar';
COMMENT ON COLUMN supervisar.idEstetica IS 'El id de la estetica asociada';
COMMENT ON COLUMN supervisar.curp IS 'El curp del supervisor asociado';
COMMENT ON COLUMN supervisar.nombre IS 'El nombre de la estetica asociada';
COMMENT ON COLUMN supervisar.estado IS 'El estado donde se encuentra la estetica asociada';
COMMENT ON COLUMN supervisar.calle IS 'La calle donde se encuentra la estetica asociada';
COMMENT ON COLUMN supervisar.numero IS 'El numero de la estetica asociada';
COMMENT ON COLUMN supervisar.codigoPostal IS 'El codigo postal de la estetica asociada';
COMMENT ON COLUMN supervisar.telefono IS 'El telefono de la estetica asociada';
COMMENT ON COLUMN supervisar.horario IS 'El horario de la estetica asociada';
COMMENT ON COLUMN supervisar.apartado IS 'El apartado de la estetica asociada';
COMMENT ON COLUMN supervisar.consultorios IS 'Los consultorios de la estetica asociada';
COMMENT ON COLUMN supervisar.nombreTrabajador IS 'El nombre del supervisor asociado';
COMMENT ON COLUMN supervisar.apellidoPaternoTrabajador IS 'El apellido paterno del supervisor asociado';
COMMENT ON COLUMN supervisar.apellidoMaternoTrabajador IS 'El apellido materno del supervisor asociado';
COMMENT ON COLUMN supervisar.estadoTrabajador IS 'El estado donde se encuentra el supervisor asociado';
COMMENT ON COLUMN supervisar.calleTrabajador IS 'La calle donde se encuentra el supervisor asociado';
COMMENT ON COLUMN supervisar.numeroTrabajador IS 'El numero donde se encuentra el supervisor asociado';
COMMENT ON COLUMN supervisar.codigoPostalTrabajador IS 'El codigo postal donde se encuentra el supervisor asociado';
COMMENT ON COLUMN supervisar.salarioTrabajador IS 'El salario del supervisor asociado';
COMMENT ON COLUMN supervisar.fechaDeNacimientoTrabajador IS 'La fecha de naciemiento del supervisor asociado';
COMMENT ON COLUMN supervisar.generoTrabajador IS 'El genero del supervisor asociado';
COMMENT ON COLUMN supervisar.rfcTrabajador IS 'El RFC del supervisor asociado';
COMMENT ON COLUMN supervisar.horaEntradaTrabajador IS 'La hora de entrada del supervisor asociado';
COMMENT ON COLUMN supervisar.horaSalidaTrabajador IS 'La hora de salida del supervisor asociado';

CREATE TABLE estetica(
	idEstetica INT NOT NULL UNIQUE,
	nombre VARCHAR(100) NOT NULL CHECK(nombre <> ''),
	telefono CHAR(10) NOT NULL CHECK (telefono SIMILAR TO '[0-9]*'),
	horario TIME NOT NULL,
	apartado VARCHAR(100) NOT NULL CHECK(apartado <> ''),
	consultorios VARCHAR(100) NOT NULL CHECK(consultorios <> ''),
	estado VARCHAR(100) NOT NULL CHECK(estado <> ''),
	calle VARCHAR(100) NOT NULL CHECK(calle <> ''),
	numero INT NOT NULL,
	codigoPostal INT NOT NULL
);

COMMENT ON TABLE estetica IS 'Tabla que contiene la informacion de la estetica';
COMMENT ON COLUMN estetica.idEstetica IS 'El id de la estetica';
COMMENT ON COLUMN estetica.nombre IS 'El nombre de la estetica';
COMMENT ON COLUMN estetica.telefono IS 'El telefono de la estetica';
COMMENT ON COLUMN estetica.horario IS 'El horario de la estetica';
COMMENT ON COLUMN estetica.apartado IS 'El apartado de la estetica';
COMMENT ON COLUMN estetica.consultorios IS 'Los consultorios de la estetica';
COMMENT ON COLUMN estetica.estado IS 'El estado donde se encuentra la estetica';
COMMENT ON COLUMN estetica.calle IS 'La calle donde se encuentra la estetica';
COMMENT ON COLUMN estetica.numero IS 'El numero de la estetica';
COMMENT ON COLUMN estetica.codigoPostal IS 'El codigo postal de la estetica';

CREATE TABLE mascota(
	idMascota INT NOT NULL UNIQUE,
	curp CHAR(18) NOT NULL CHECK(CHAR_LENGTH(curp) = 18),
	nombre VARCHAR(100) NOT NULL CHECK(nombre <> ''),
	especie VARCHAR(100) NOT NULL CHECK(especie <> ''),
	raza VARCHAR(100) NOT NULL CHECK(raza <> ''),
	nombreDelDuenio VARCHAR(100) NOT NULL CHECK(nombreDelDuenio <> ''),
	edad INT NOT NULL,
	peso INT NOT NULL
);

COMMENT ON TABLE mascota IS 'Tabla que contiene la informacion de la mascota';
COMMENT ON COLUMN mascota.idMascota IS 'El id de la mascota';
COMMENT ON COLUMN mascota.curp IS 'El id curp del duenio de la mascota';
COMMENT ON COLUMN mascota.nombre IS 'El nombre de la mascota';
COMMENT ON COLUMN mascota.especie IS 'La especie de la mascota';
COMMENT ON COLUMN mascota.raza IS 'La raza de la mascota';
COMMENT ON COLUMN mascota.nombreDelDuenio IS 'El nombre del duenio de la mascota';
COMMENT ON COLUMN mascota.edad IS 'La edad de la mascota';
COMMENT ON COLUMN mascota.peso IS 'El peso de la mascota';

CREATE TABLE cuidar(
	idEstetica INT NOT NULL,
	idMascota INT NOT NULL
);

COMMENT ON TABLE cuidar IS 'Tabla que contiene la relacion cuidar';
COMMENT ON COLUMN cuidar.idEstetica IS 'El id de la estetica asociada';
COMMENT ON COLUMN cuidar.idMascota IS 'El id de la mascota asociada';

CREATE TABLE cortar(
	idConsulta INT NOT NULL,
	curp CHAR(18) NOT NULL CHECK(CHAR_LENGTH(curp) = 18)
);

COMMENT ON TABLE cortar IS 'Tabla que contiene la relacion cortar';
COMMENT ON COLUMN cortar.idConsulta IS 'El id de la consulta asociada';
COMMENT ON COLUMN cortar.curp IS 'El estilista asociado';

CREATE TABLE darConsultaEmergencia(
	curp CHAR(18) NOT NULL CHECK(CHAR_LENGTH(curp) = 18),
	idConsulta INT NOT NULL
);

COMMENT ON TABLE darConsultaEmergencia IS 'Tabla que contiene la relacion dar consulta emergencia';
COMMENT ON COLUMN darConsultaEmergencia.curp IS 'El CURP del veterinario asociado';
COMMENT ON COLUMN darConsultaEmergencia.idConsulta IS 'El id de la consulta emergencia asociado';

/*
Parte Verde
*/
CREATE TABLE estilistas(
	curp CHAR(18) NOT NULL UNIQUE CHECK(CHAR_LENGTH(curp) = 18),
	idEstetica INT NOT NULL,
	nombreTrabajador VARCHAR(100) NOT NULL CHECK(nombreTrabajador <> ''),
	apellidoPaternoTrabajador VARCHAR(100) NOT NULL CHECK(apellidoPaternoTrabajador <> ''),
	apellidoMaternoTrabajador VARCHAR(100) NOT NULL CHECK(apellidoMaternoTrabajador <> ''),
	estadoTrabajador VARCHAR(100) NOT NULL CHECK(estadoTrabajador <> ''),
	calleTrabajador VARCHAR(100) NOT NULL CHECK(calleTrabajador <> ''),
	numeroTrabajador INT NOT NULL,
	codigoPostalTrabajador INT NOT NULL,
	salarioTrabajador MONEY NOT NULL,
	fechaDeNacimientoTrabajador DATE CHECK(fechaDeNacimientoTrabajador > '2000-10-01'),
	generoTrabajador VARCHAR(100) NOT NULL CHECK(generoTrabajador <> ''),
	numeroDeCertificadoTrabajador INT NOT NULL
);

COMMENT ON TABLE estilistas IS 'Tabla que contiene la informacion de los estilistas';
COMMENT ON COLUMN estilistas.curp IS 'El curp del estilista';
COMMENT ON COLUMN estilistas.idEstetica IS 'El id de la estetica';
COMMENT ON COLUMN estilistas.nombreTrabajador IS 'El nombre del estilista';
COMMENT ON COLUMN estilistas.apellidoPaternoTrabajador IS 'El apellido paterno del estilista';
COMMENT ON COLUMN estilistas.apellidoMaternoTrabajador IS 'El apellido materno del estilista';
COMMENT ON COLUMN estilistas.estadoTrabajador IS 'El estado donde vive el estilista';
COMMENT ON COLUMN estilistas.calleTrabajador IS 'La calle donde vive el estilista';
COMMENT ON COLUMN estilistas.numeroTrabajador IS 'El numero de la calle donde vive el estilista';
COMMENT ON COLUMN estilistas.codigoPostalTrabajador IS 'El codigo postal de donde vive el estilista';
COMMENT ON COLUMN estilistas.salarioTrabajador IS 'El salario del estilista';
COMMENT ON COLUMN estilistas.fechaDeNacimientoTrabajador IS 'La fecha de nacimiento del estilista';
COMMENT ON COLUMN estilistas.generoTrabajador IS 'El genero del estilista';
COMMENT ON COLUMN estilistas.numeroDeCertificadoTrabajador IS 'El numero de certificado del estilista';

CREATE TABLE telefonoEstilistas(
	curp CHAR(18) NOT NULL UNIQUE CHECK(CHAR_LENGTH(curp)=18),
	telefonoEstilistas CHAR(10) UNIQUE CHECK (telefonoEstilistas SIMILAR TO '[0-9]*')
);

COMMENT ON TABLE telefonoEstilistas IS 'Tabla que contiene la informacion de los telefonos de estilistas';
COMMENT ON COLUMN telefonoEstilistas.curp IS 'El curp del estilista';
COMMENT ON COLUMN telefonoEstilistas.telefonoEstilistas IS 'El telefono del estilista';

CREATE TABLE veterinarios(
	curp CHAR(18) NOT NULL UNIQUE CHECK(CHAR_LENGTH(curp) = 18),
	idEstetica INT NOT NULL,
	nombreTrabajador VARCHAR(100) NOT NULL CHECK(nombreTrabajador <> ''),
	apellidoPaternoTrabajador VARCHAR(100) NOT NULL CHECK(apellidoPaternoTrabajador <> ''),
	apellidoMaternoTrabajador VARCHAR(100) NOT NULL CHECK(apellidoMaternoTrabajador <> ''),
	estadoTrabajador VARCHAR(100) NOT NULL CHECK(estadoTrabajador <> ''),
	calleTrabajador VARCHAR(100) NOT NULL CHECK(calleTrabajador <> ''),
	numeroTrabajador INT NOT NULL,
	codigoPostalTrabajador INT NOT NULL,
	salarioTrabajador MONEY NOT NULL,
	fechaDeNacimientoTrabajador DATE CHECK(fechaDeNacimientoTrabajador > '2000-10-01'),
	generoTrabajador VARCHAR(100) NOT NULL CHECK(generoTrabajador <> ''),
	rfcTrabajador VARCHAR(100) NOT NULL CHECK(rfcTrabajador <> ''),
	numeroDePacientesActivosTrabajador INT NOT NULL, 
	horaEntradaTrabajador TIME NOT NULL,
	horaSalidaTrabajador TIME NOT NULL
);

COMMENT ON TABLE veterinarios IS 'Tabla que contiene la informacion de los veterinarios';
COMMENT ON COLUMN veterinarios.curp IS 'El curp del veterinario';
COMMENT ON COLUMN veterinarios.idEstetica IS 'El id de la estetica';
COMMENT ON COLUMN veterinarios.nombreTrabajador IS 'El nombre del veterinario';
COMMENT ON COLUMN veterinarios.apellidoPaternoTrabajador IS 'El apellido paterno del veterinario';
COMMENT ON COLUMN veterinarios.apellidoMaternoTrabajador IS 'El apellido materno del veterinario';
COMMENT ON COLUMN veterinarios.estadoTrabajador IS 'El estado donde vive el veterinario';
COMMENT ON COLUMN veterinarios.calleTrabajador IS 'La calle donde vive el veterinario';
COMMENT ON COLUMN veterinarios.numeroTrabajador IS 'El numero de la calle donde vive el veterinario';
COMMENT ON COLUMN veterinarios.codigoPostalTrabajador IS 'El codigo postal de donde vive el veterinario';
COMMENT ON COLUMN veterinarios.salarioTrabajador IS 'El salario del veterinario';
COMMENT ON COLUMN veterinarios.fechaDeNacimientoTrabajador IS 'La fecha de nacimiento del veterinario';
COMMENT ON COLUMN veterinarios.generoTrabajador IS 'El genero del veterinario';
COMMENT ON COLUMN veterinarios.rfcTrabajador IS 'El rfc del veterinario';
COMMENT ON COLUMN veterinarios.numeroDePacientesActivosTrabajador IS 'El numero de pacientes activos del veterinario';
COMMENT ON COLUMN veterinarios.horaEntradaTrabajador IS 'La hora de entrada del veterinario';
COMMENT ON COLUMN veterinarios.horaSalidaTrabajador IS 'La hora de salida del veterinario';

CREATE TABLE telefonoVeterinarios(
	curp CHAR(18) NOT NULL UNIQUE CHECK(CHAR_LENGTH(curp)=18),
	telefonoVeterinarios CHAR(10) UNIQUE CHECK (telefonoVeterinarios SIMILAR TO '[0-9]*')
);

COMMENT ON TABLE telefonoVeterinarios IS 'Tabla que contiene la informacion de los telefonos de veterinarios';
COMMENT ON COLUMN telefonoVeterinarios.curp IS 'El curp del veterinario';
COMMENT ON COLUMN telefonoVeterinarios.telefonoVeterinarios IS 'El telefono del veterinario';

CREATE TABLE supervisor(
	curp CHAR(18) NOT NULL UNIQUE CHECK(CHAR_LENGTH(curp) = 18),
	idEstetica INT NOT NULL,
	nombreTrabajador VARCHAR(100) NOT NULL CHECK(nombreTrabajador <> ''),
	apellidoPaternoTrabajador VARCHAR(100) NOT NULL CHECK(apellidoPaternoTrabajador <> ''),
	apellidoMaternoTrabajador VARCHAR(100) NOT NULL CHECK(apellidoMaternoTrabajador <> ''),
	estadoTrabajador VARCHAR(100) NOT NULL CHECK(estadoTrabajador <> ''),
	calleTrabajador VARCHAR(100) NOT NULL CHECK(calleTrabajador <> ''),
	numeroTrabajador INT NOT NULL,
	codigoPostalTrabajador INT NOT NULL,
	salarioTrabajador MONEY NOT NULL,
	fechaDeNacimientoTrabajador DATE CHECK(fechaDeNacimientoTrabajador > '2000-10-01'),
	generoTrabajador VARCHAR(100) NOT NULL CHECK(generoTrabajador <> ''),
	rfcTrabajador VARCHAR(100) NOT NULL CHECK(rfcTrabajador <> ''),
	horaEntradaTrabajador TIME NOT NULL,
	horaSalidaTrabajador TIME NOT NULL
);

COMMENT ON TABLE supervisor IS 'Tabla que contiene la informacion del supervisor';
COMMENT ON COLUMN supervisor.curp IS 'El curp del supervisor';
COMMENT ON COLUMN supervisor.idEstetica IS 'El id de la estetica';
COMMENT ON COLUMN supervisor.nombreTrabajador IS 'El nombre del supervisor';
COMMENT ON COLUMN supervisor.apellidoPaternoTrabajador IS 'El apellido paterno del supervisor';
COMMENT ON COLUMN supervisor.apellidoMaternoTrabajador IS 'El apellido materno del supervisor';
COMMENT ON COLUMN supervisor.estadoTrabajador IS 'El estado donde vive el supervisor';
COMMENT ON COLUMN supervisor.calleTrabajador IS 'La calle donde vive el supervisor';
COMMENT ON COLUMN supervisor.numeroTrabajador IS 'El numero de la calle donde vive el supervisor';
COMMENT ON COLUMN supervisor.codigoPostalTrabajador IS 'El codigo postal de donde vive el supervisor';
COMMENT ON COLUMN supervisor.salarioTrabajador IS 'El salario del supervisor';
COMMENT ON COLUMN supervisor.fechaDeNacimientoTrabajador IS 'La fecha de nacimiento del supervisor';
COMMENT ON COLUMN supervisor.generoTrabajador IS 'El genero del supervisor';
COMMENT ON COLUMN supervisor.rfcTrabajador IS 'El rfc del supervisor';
COMMENT ON COLUMN supervisor.horaEntradaTrabajador IS 'La hora de entrada del supervisor';
COMMENT ON COLUMN supervisor.horaSalidaTrabajador IS 'La hora de salida del supervisor';

CREATE TABLE telefonoSupervisor(
	curp CHAR(18) NOT NULL UNIQUE CHECK(CHAR_LENGTH(curp)=18),
	telefonoSupervisor CHAR(10) UNIQUE CHECK (telefonoSupervisor SIMILAR TO '[0-9]*')
);

COMMENT ON TABLE telefonoSupervisor IS 'Tabla que contiene la informacion del telefono del supervisor';
COMMENT ON COLUMN telefonoSupervisor.curp IS 'El curp del supervisor';
COMMENT ON COLUMN telefonoSupervisor.telefonoSupervisor IS 'El telefono del supervisor';

/*
Parte Azul
*/

CREATE TABLE telefonoDuenio(
	curp CHAR(18) NOT NULL UNIQUE CHECK(CHAR_LENGTH(curp)=18),
	telefonoDuenio CHAR(10) UNIQUE CHECK (telefonoDuenio SIMILAR TO '[0-9]*')
);

COMMENT ON TABLE telefonoDuenio IS 'Tabla que contiene la informacion del telefono del duenio';
COMMENT ON COLUMN telefonoDuenio.curp IS 'El curp del duenio asociado';
COMMENT ON COLUMN telefonoDuenio.telefonoDuenio IS 'El numero de telefono a 10 digitos';


CREATE TABLE felicitar(
	curp CHAR(18) NOT NULL CHECK(CHAR_LENGTH(curp) = 18),
	idEstetica INT NOT NULL
);

COMMENT ON TABLE felicitar IS 'Tabla que contiene la informacion sobre la relacion felicitar';
COMMENT ON COLUMN felicitar.curp IS 'El curp del duenio asociado';
COMMENT ON COLUMN felicitar.idEstetica IS 'El id de la estetica asociada';

CREATE TABLE duenio(
	curp CHAR(18) NOT NULL UNIQUE CHECK(CHAR_LENGTH(curp) = 18),
	idEstetica INT NOT NULL,
	nombreDuenio VARCHAR(100) NOT NULL CHECK(nombreDuenio <> ''),
	apellidoPaternoDuenio VARCHAR(100) NOT NULL CHECK(apellidoPaternoDuenio <> ''),
	apellidoMaternoDuenio VARCHAR(100) NOT NULL CHECK(apellidoMaternoDuenio <> ''),
	correoDuenio VARCHAR(20) NOT NULL CHECK(correoDuenio <>''),
	estadoDuenio VARCHAR(100) NOT NULL CHECK(estadoDuenio <> ''),
	calleDuenio VARCHAR(100) NOT NULL CHECK(calleDuenio <> ''),
	numeroDuenio INT NOT NULL,
	codigoPostalDuenio INT NOT NULL
);

COMMENT ON TABLE duenio IS 'Tabla que contiene la informacion del duenio';
COMMENT ON COLUMN duenio.curp IS 'El curp (id) del duenio';
COMMENT ON COLUMN duenio.idEstetica IS 'El id de la estetica asociada';
COMMENT ON COLUMN duenio.nombreDuenio IS 'El nombre personal';
COMMENT ON COLUMN duenio.apellidoPaternoDuenio IS 'El apellido paterno del duenio';
COMMENT ON COLUMN duenio.apellidoMaternoDuenio IS 'El apellido materno del duenio';
COMMENT ON COLUMN duenio.correoDuenio IS 'El correo electronico del duenio';
COMMENT ON COLUMN duenio.estadoDuenio IS 'El estado donde reside';
COMMENT ON COLUMN duenio.calleDuenio IS 'La calle donde vive';
COMMENT ON COLUMN duenio.numeroDuenio IS 'El numero del duenio';
COMMENT ON COLUMN duenio.codigoPostalDuenio IS 'CP';



CREATE TABLE tarjeta(
	numeroTarjeta INT NOT NULL UNIQUE,
	curp CHAR(18) NOT NULL CHECK(CHAR_LENGTH(curp) = 18),
	nombrePropietario VARCHAR(100) NOT NULL CHECK(nombrePropietario <> ''),
	vencimiento DATE NOT NULL CHECK(CURRENT_DATE <= vencimiento)
);

COMMENT ON TABLE tarjeta IS 'Tabla que contiene la informacion de una tarjeta';
COMMENT ON COLUMN tarjeta.numeroTarjeta IS 'El id(numero de tajreta) del tajreta';
COMMENT ON COLUMN tarjeta.curp IS 'El curp del duenio asociado';
COMMENT ON COLUMN tarjeta.nombrePropietario IS 'El nombre del duenio asociado';
COMMENT ON COLUMN tarjeta.vencimiento IS 'El vencimiento de la tarjeta';

CREATE TABLE efectivo(
	numeroDeSerie INT NOT NULL UNIQUE,
	curp CHAR(18) NOT NULL CHECK(CHAR_LENGTH(curp) = 18)
);

COMMENT ON TABLE efectivo IS 'Tabla que contiene la informacion del efectivo';
COMMENT ON COLUMN efectivo.numeroDeSerie IS 'El id(numero de serie) del efectivo';
COMMENT ON COLUMN efectivo.curp IS 'El curp del duenio asociado';

CREATE TABLE recibo(
	idRecibo INT NOT NULL UNIQUE,
	curp CHAR(18) NOT NULL CHECK(CHAR_LENGTH(curp) = 18),
	nombreDuenio VARCHAR(100) NOT NULL CHECK(nombreDuenio <> ''),
	nombreTrabajador VARCHAR(100) NOT NULL CHECK(nombreDuenio <> ''),
	nombreMascota VARCHAR(100) NOT NULL CHECK(nombreDuenio <> '')
);

COMMENT ON TABLE recibo IS 'Tabla que contiene la informacion del recibo';
COMMENT ON COLUMN recibo.idRecibo IS 'El id del recibo';
COMMENT ON COLUMN recibo.curp IS 'El curp del duenio asociado';
COMMENT ON COLUMN recibo.nombreDuenio IS 'El nombre que aparece en el recibo';
COMMENT ON COLUMN recibo.nombreMascota IS 'El nombre de la mascota que aparece en el recibo';
COMMENT ON COLUMN recibo.nombreTrabajador IS 'El nombre del trabajador que aparece en el recibo';

/*
Integridad Referencial Roja
*/

--Llaves foraneas

ALTER TABLE consultaNormal ADD CONSTRAINT consultaNormal_pkey PRIMARY KEY (idConsulta);
COMMENT ON CONSTRAINT consultaNormal_pkey ON consultaNormal IS 'La llave primaria de la tabla consultaNormal';
ALTER TABLE consultaNormal ADD CONSTRAINT consultaNormal_fkey1 FOREIGN KEY (idMascota)
REFERENCES mascota(idMascota) ON UPDATE CASCADE ON DELETE CASCADE;
COMMENT ON CONSTRAINT consultaNormal_fkey1 ON consultaNormal IS 'La llave foranea de la tabla consultaNormal que referencia a mascota';
ALTER TABLE consultaNormal ADD CONSTRAINT consultaNormal_fkey2 FOREIGN KEY (idRecibo)
REFERENCES recibo(idRecibo) ON UPDATE CASCADE ON DELETE CASCADE;
COMMENT ON CONSTRAINT consultaNormal_fkey2 ON consultaNormal IS 'La llave foranea de la tabla consultaNormal que referencia a recibo';

ALTER TABLE consultaEmergencia ADD CONSTRAINT consultaEmergencia_pkey PRIMARY KEY (idConsulta);
COMMENT ON CONSTRAINT consultaEmergencia_pkey ON consultaEmergencia IS 'La llave primaria de la tabla consultaEmergencia';
ALTER TABLE consultaEmergencia ADD CONSTRAINT consultaEmergencia_fkey1 FOREIGN KEY (idMascota)
REFERENCES mascota(idMascota) ON UPDATE CASCADE ON DELETE CASCADE;
COMMENT ON CONSTRAINT consultaEmergencia_fkey1 ON consultaEmergencia IS 'La llave foranea de la tabla consultaEmergencia que referencia a mascota';
ALTER TABLE consultaEmergencia ADD CONSTRAINT consultaEmergencia_fkey2 FOREIGN KEY (idRecibo)
REFERENCES recibo(idRecibo) ON UPDATE CASCADE ON DELETE CASCADE;
COMMENT ON CONSTRAINT consultaEmergencia_fkey2 ON consultaEmergencia IS 'La llave foranea de la tabla consultaEmergencia que referencia a recibo';

ALTER TABLE producto ADD CONSTRAINT producto_pkey PRIMARY KEY (idProducto);
COMMENT ON CONSTRAINT producto_pkey ON producto IS 'La llave primaria de la tabla producto';
ALTER TABLE producto ADD CONSTRAINT producto_fkey1 FOREIGN KEY (idConsulta)
REFERENCES consultaNormal(idConsulta) ON UPDATE CASCADE ON DELETE CASCADE;
COMMENT ON CONSTRAINT producto_fkey1 ON producto IS 'La llave foranea de la tabla producto que referencia a consultaNormal';
ALTER TABLE producto ADD CONSTRAINT producto_fkey2 FOREIGN KEY (idRecibo)
REFERENCES recibo(idRecibo) ON UPDATE CASCADE ON DELETE CASCADE;
COMMENT ON CONSTRAINT producto_fkey2 ON producto IS 'La llave foranea de la tabla producto que referencia a recibo';

ALTER TABLE servicioEstetica ADD CONSTRAINT servicioEstetica_pkey PRIMARY KEY (idConsulta);
COMMENT ON CONSTRAINT servicioEstetica_pkey ON servicioEstetica IS 'La llave primaria de la tabla servicioEstetica';
ALTER TABLE servicioEstetica ADD CONSTRAINT servicioEstetica_fkey1 FOREIGN KEY (idMascota)
REFERENCES mascota(idMascota) ON UPDATE CASCADE ON DELETE CASCADE;
COMMENT ON CONSTRAINT servicioEstetica_fkey1 ON servicioEstetica IS 'La llave foranea de la tabla servicioEstetica que referencia a mascota';
ALTER TABLE servicioEstetica ADD CONSTRAINT servicioEstetica_fkey2 FOREIGN KEY (idRecibo)
REFERENCES recibo(idRecibo) ON UPDATE CASCADE ON DELETE CASCADE;
COMMENT ON CONSTRAINT servicioEstetica_fkey2 ON servicioEstetica IS 'La llave foranea de la tabla servicioEstetica que referencia a recibo';

ALTER TABLE darConsultaNormal ADD CONSTRAINT darConsultaNormal_fkey1 FOREIGN KEY (curp)
REFERENCES veterinarios(curp) ON UPDATE CASCADE ON DELETE CASCADE;
COMMENT ON CONSTRAINT darConsultaNormal_fkey1 ON darConsultaNormal IS 'La llave foranea de la tabla darConsultaNormal que referencia a veterinarios';
ALTER TABLE darConsultaNormal ADD CONSTRAINT darConsultaNormal_fkey2 FOREIGN KEY (idConsulta)
REFERENCES consultaNormal(idConsulta) ON UPDATE CASCADE ON DELETE CASCADE;
COMMENT ON CONSTRAINT darConsultaNormal_fkey2 ON darConsultaNormal IS 'La llave foranea de la tabla darConsultaNormal que referencia a consultaNormal';

/*
Integridad Referencial Amarillo
*/
ALTER TABLE cuidar ADD CONSTRAINT cuidar_fkey1 FOREIGN KEY (idEstetica)
REFERENCES estetica(idEstetica) ON UPDATE CASCADE ON DELETE CASCADE;
COMMENT ON CONSTRAINT cuidar_fkey1 ON cuidar IS 'La llave foranea de la tabla cuidar que referencia a estetica';
ALTER TABLE cuidar ADD CONSTRAINT cuidar_fkey2 FOREIGN KEY (idMascota)
REFERENCES mascota(idMascota) ON UPDATE CASCADE ON DELETE CASCADE;
COMMENT ON CONSTRAINT cuidar_fkey2 ON cuidar IS 'La llave foranea de la tabla cuidar que referencia a mascota';

ALTER TABLE cortar ADD CONSTRAINT cortar_fkey1 FOREIGN KEY (idConsulta)
REFERENCES servicioEstetica(idConsulta) ON UPDATE CASCADE ON DELETE CASCADE;
COMMENT ON CONSTRAINT cortar_fkey1 ON cortar IS 'La llave foranea de la tabla cortar que referencia a servicio estetica';
ALTER TABLE cortar ADD CONSTRAINT cortar_fkey2 FOREIGN KEY (curp)
REFERENCES estilistas(curp) ON UPDATE CASCADE ON DELETE CASCADE;
COMMENT ON CONSTRAINT cortar_fkey2 ON cortar IS 'La llave foranea de la tabla cortar que referencia a estilistas';

ALTER TABLE darConsultaEmergencia ADD CONSTRAINT darConsultaEmergencia_fkey1 FOREIGN KEY (curp)
REFERENCES veterinarios(curp) ON UPDATE CASCADE ON DELETE CASCADE;
COMMENT ON CONSTRAINT darConsultaEmergencia_fkey1 ON darConsultaEmergencia IS 'La llave foranea de la tabla darConsultaEmergencia que referencia a veterinarios';
ALTER TABLE darConsultaEmergencia ADD CONSTRAINT darConsultaEmergencia_fkey2 FOREIGN KEY (idConsulta)
REFERENCES consultaEmergencia(idConsulta) ON UPDATE CASCADE ON DELETE CASCADE;
COMMENT ON CONSTRAINT darConsultaEmergencia_fkey2 ON darConsultaEmergencia IS 'La llave foranea de la tabla darConsultaEmergencia que referencia a consultaEmergencia';

ALTER TABLE estetica ADD CONSTRAINT estetica_pkey PRIMARY KEY (idEstetica);
COMMENT ON CONSTRAINT estetica_pkey ON estetica IS 'La llave primaria de la tabla estetica';

ALTER TABLE supervisar ADD CONSTRAINT supervisar_fkey1 FOREIGN KEY (idEstetica)
REFERENCES estetica(idEstetica) ON UPDATE CASCADE ON DELETE CASCADE;
COMMENT ON CONSTRAINT supervisar_fkey1 ON supervisar IS 'La llave foranea de la tabla supervisar que referencia a estetica';
ALTER TABLE supervisar ADD CONSTRAINT supervisar_fkey2 FOREIGN KEY (curp)
REFERENCES supervisor(curp) ON UPDATE CASCADE ON DELETE CASCADE;
COMMENT ON CONSTRAINT supervisar_fkey2 ON supervisar IS 'La llave foranea de la tabla supervisar que referencia a supervisor';

ALTER TABLE mascota ADD CONSTRAINT mascota_pkey PRIMARY KEY (idMascota);
COMMENT ON CONSTRAINT mascota_pkey ON mascota IS 'La llave primaria de la tabla mascota';
ALTER TABLE mascota ADD CONSTRAINT mascota_fkey1 FOREIGN KEY (curp)
REFERENCES duenio(curp) ON UPDATE CASCADE ON DELETE CASCADE;
COMMENT ON CONSTRAINT mascota_fkey1 ON mascota IS 'La llave foranea de la tabla mascota que referencia a duenio';

/*
Integridad Referencial Verde
*/

ALTER TABLE estilistas ADD CONSTRAINT estilistas_pkey PRIMARY KEY (curp);
COMMENT ON CONSTRAINT estilistas_pkey ON estilistas IS 'La llave primaria de la tabla estilistas';
ALTER TABLE estilistas ADD CONSTRAINT estilistas_fkey FOREIGN KEY (idEstetica)
REFERENCES estetica(idEstetica) ON UPDATE CASCADE ON DELETE CASCADE;
COMMENT ON CONSTRAINT estilistas_fkey ON estilistas IS 'La llave foranea de la tabla estilistas que referencia a estetica';

ALTER TABLE veterinarios ADD CONSTRAINT veterinarios_pkey PRIMARY KEY (curp);
COMMENT ON CONSTRAINT veterinarios_pkey ON veterinarios IS 'La llave primaria de la tabla veterinarios';
ALTER TABLE veterinarios ADD CONSTRAINT veterinarios_fkey FOREIGN KEY (idEstetica)
REFERENCES estetica(idEstetica) ON UPDATE CASCADE ON DELETE CASCADE;
COMMENT ON CONSTRAINT veterinarios_fkey ON veterinarios IS 'La llave foranea de la tabla veterinarios que referencia a estetica';

ALTER TABLE supervisor ADD CONSTRAINT supervisor_pkey PRIMARY KEY (curp);
COMMENT ON CONSTRAINT supervisor_pkey ON supervisor IS 'La llave primaria de la tabla supervisor';
ALTER TABLE supervisor ADD CONSTRAINT supervisor_fkey FOREIGN KEY (idEstetica)
REFERENCES estetica(idEstetica) ON UPDATE CASCADE ON DELETE CASCADE;
COMMENT ON CONSTRAINT supervisor_fkey ON supervisor IS 'La llave foranea de la tabla supervisor que referencia a estetica';

ALTER TABLE telefonoEstilistas ADD CONSTRAINT telefonoEstilistas_pkey PRIMARY KEY (curp,telefonoEstilistas);
COMMENT ON CONSTRAINT telefonoEstilistas_pkey ON telefonoEstilistas IS 'La llave primaria de la tabla telefonoEstilistas';
ALTER TABLE telefonoEstilistas ADD CONSTRAINT telefonoEstilistas_fkey FOREIGN KEY (curp)
REFERENCES estilistas (curp) ON UPDATE CASCADE ON DELETE CASCADE;
COMMENT ON CONSTRAINT telefonoEstilistas_fkey ON telefonoEstilistas IS 'La llave foranea de la tabla telefonoEstilistas que referencia a estilistas';

ALTER TABLE telefonoVeterinarios ADD CONSTRAINT telefonoVeterinarios_pkey PRIMARY KEY (curp,telefonoVeterinarios);
COMMENT ON CONSTRAINT telefonoVeterinarios_pkey ON telefonoVeterinarios IS 'La llave primaria de la tabla telefonoVeterinarios';
ALTER TABLE telefonoVeterinarios ADD CONSTRAINT telefonoVeterinarios_fkey FOREIGN KEY (curp)
REFERENCES veterinarios (curp) ON UPDATE CASCADE ON DELETE CASCADE;
COMMENT ON CONSTRAINT telefonoVeterinarios_fkey ON telefonoVeterinarios IS 'La llave foranea de la tabla telefonoVeterinarios que referencia a veterinarios';

ALTER TABLE telefonoSupervisor ADD CONSTRAINT telefonoSupervisor_pkey PRIMARY KEY (curp,telefonoSupervisor);
COMMENT ON CONSTRAINT telefonoSupervisor_pkey ON telefonoSupervisor IS 'La llave primaria de la tabla telefonoSupervisor';
ALTER TABLE telefonoSupervisor ADD CONSTRAINT telefonoSupervisor_fkey FOREIGN KEY (curp)
REFERENCES supervisor (curp) ON UPDATE CASCADE ON DELETE CASCADE;
COMMENT ON CONSTRAINT telefonoSupervisor_fkey ON telefonoSupervisor IS 'La llave foranea de la tabla telefonoSupervisor que referencia a supervisor';

/*
Integridad Referencial Azul
*/

ALTER TABLE telefonoDuenio ADD CONSTRAINT telefonoDuenio_pkey PRIMARY KEY (curp,telefonoDuenio);
COMMENT ON CONSTRAINT telefonoDuenio_pkey ON telefonoDuenio IS 'La llave primaria de la tabla telefonoDuenio';
ALTER TABLE telefonoDuenio ADD CONSTRAINT telefonoDuenio_fkey FOREIGN KEY (curp)
REFERENCES duenio (curp) ON UPDATE CASCADE ON DELETE CASCADE;
COMMENT ON CONSTRAINT telefonoDuenio_fkey ON telefonoDuenio IS 'La llave foranea de la tabla telefonoDuenio que referencia a duenio';


ALTER TABLE felicitar ADD CONSTRAINT felicitar_fkey1 FOREIGN KEY (curp)
REFERENCES duenio (curp) ON UPDATE CASCADE ON DELETE CASCADE;
COMMENT ON CONSTRAINT felicitar_fkey1 ON felicitar IS 'La llave foranea de la tabla felicitar que referencia a duenio';
ALTER TABLE felicitar ADD CONSTRAINT felicitar_fkey2 FOREIGN KEY (idEstetica)
REFERENCES estetica(idEstetica) ON UPDATE CASCADE ON DELETE CASCADE;
COMMENT ON CONSTRAINT felicitar_fkey2 ON felicitar IS 'La llave foranea de la tabla felicitar que referencia a estetica';

ALTER TABLE duenio ADD CONSTRAINT duenio_pkey PRIMARY KEY (curp);
COMMENT ON CONSTRAINT duenio_pkey ON duenio IS 'La llave primaria de la tabla duenio';
ALTER TABLE duenio ADD CONSTRAINT duenio_fkey FOREIGN KEY (idEstetica)
REFERENCES estetica(idEstetica) ON UPDATE CASCADE ON DELETE CASCADE;
COMMENT ON CONSTRAINT duenio_fkey ON duenio IS 'La llave foranea de la tabla duenio que referencia a estetica';

ALTER TABLE tarjeta ADD CONSTRAINT tarjeta_pkey PRIMARY KEY (numeroTarjeta);
COMMENT ON CONSTRAINT tarjeta_pkey ON tarjeta IS 'La llave primaria de la tabla tarjeta';
ALTER TABLE tarjeta ADD CONSTRAINT tarjeta_fkey FOREIGN KEY (curp)
REFERENCES duenio(curp) ON UPDATE CASCADE ON DELETE CASCADE;
COMMENT ON CONSTRAINT tarjeta_fkey ON tarjeta IS 'La llave foranea de la tabla tarjeta que referencia a duenio';

ALTER TABLE efectivo ADD CONSTRAINT efectivo_pkey PRIMARY KEY (numeroDeSerie);
COMMENT ON CONSTRAINT efectivo_pkey ON efectivo IS 'La llave primaria de la tabla efectivo';
ALTER TABLE efectivo ADD CONSTRAINT efectivo_fkey FOREIGN KEY (curp)
REFERENCES duenio(curp) ON UPDATE CASCADE ON DELETE CASCADE;
COMMENT ON CONSTRAINT efectivo_fkey ON efectivo IS 'La llave foranea de la tabla efectivo que referencia a duenio';

ALTER TABLE recibo ADD CONSTRAINT recibo_pkey PRIMARY KEY (idRecibo);
COMMENT ON CONSTRAINT recibo_pkey ON recibo IS 'La llave primaria de la tabla recibo';
ALTER TABLE recibo ADD CONSTRAINT recibo_fkey FOREIGN KEY (curp)
REFERENCES duenio(curp) ON UPDATE CASCADE ON DELETE CASCADE;
COMMENT ON CONSTRAINT recibo_fkey ON recibo IS 'La llave foranea de la recibo efectivo que referencia a duenio';

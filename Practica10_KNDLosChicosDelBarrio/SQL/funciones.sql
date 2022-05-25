-- FUNCION EDAD
CREATE OR REPLACE FUNCTION edad(cu varchar) 
	RETURNS int
	AS $$
	DECLARE 
		anio int;
		curpV varchar;
	BEGIN
		SELECT curp INTO curpV FROM duenio WHERE curp = cu;	
		 anio := CAST(SUBSTRING(curpV FROM 5 FOR 2) AS INTEGER);
		 -- Si alguien es mayor de 100 anios entonces nacio en los 2000's
		 IF anio < 22 THEN
			anio := anio+2000;
		 ELSE
			anio := anio+1900;
		 END IF;
		 RETURN date_part('year', now())-anio;
	END;
$$
LANGUAGE plpgsql;

-- FUNCION ESTETICA
CREATE OR REPLACE FUNCTION ganancias(int) 
	RETURNS int
	AS $$
	DECLARE
	 	ide int;
		rec record;
		resultado int;
	BEGIN
		ide := $1;
		SELECT SUM(producto.precio) AS totalP, SUM(consultaEmergencia.precio) AS totalC, 
			   SUM(consultaNormal.precio) AS totalN, SUM(servicioEstetica.precio) AS totalS
		INTO rec FROM duenio 
			INNER JOIN recibo ON duenio.curp = recibo.curp
			INNER JOIN producto ON recibo.idRecibo = producto.idRecibo
			INNER JOIN consultaEmergencia ON recibo.idRecibo = consultaEmergencia.idRecibo
			INNER JOIN consultaNormal ON recibo.idRecibo = consultaNormal.idRecibo
			INNER JOIN servicioEstetica ON recibo.idRecibo = servicioEstetica.idRecibo
			WHERE duenio.idEstetica = ide;
		resultado := rec.totalP+rec.totalC+rec.totalN+rec.totalS;
		RETURN resultado;
	END;
$$
LANGUAGE plpgsql;
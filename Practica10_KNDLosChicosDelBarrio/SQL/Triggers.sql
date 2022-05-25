-- TRIGER INVERTIR APELLIDOS
CREATE OR REPLACE FUNCTION invierte() RETURNS TRIGGER
	AS $$ 
	DECLARE
   		temporal varchar := NEW.apellidoPaternoTrabajador;  -- variable temporal para no perder el valor
	BEGIN
		NEW.apellidoPaternoTrabajador := NEW.apellidoMaternoTrabajador;
		NEW.apellidoMaternoTrabajador := temporal;
		RETURN NEW;
	END;
$$
LANGUAGE plpgsql;

CREATE OR REPLACE TRIGGER trigger_supervisor
	BEFORE INSERT
	ON supervisor
	FOR EACH ROW
	EXECUTE PROCEDURE invierte();




-- TRIGGER MASCOTA
CREATE OR REPLACE FUNCTION evita_mascota() RETURNS TRIGGER
	AS $$
	BEGIN
		-- OLD es mascota viejita
		-- NEW es mascota actualizada
		-- NEW := OLD;
		RAISE EXCEPTION 'No puedes borrar ni modificar la tabla mascota';
		RETURN NEW;
	END;
$$
LANGUAGE plpgsql;

CREATE OR REPLACE TRIGGER trigger_mascota
	BEFORE UPDATE OR DELETE
	ON mascota
	FOR EACH ROW
	EXECUTE PROCEDURE evita_mascota();
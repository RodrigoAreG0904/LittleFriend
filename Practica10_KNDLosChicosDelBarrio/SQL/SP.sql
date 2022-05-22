CREATE OR REPLACE PROCEDURE creaVeterinario(cu IN char, idE IN int, nT IN varchar, apT IN varchar, amT IN varchar, eT IN varchar, cT IN varchar,
								 numT IN int , cpT IN int, sT IN int, fnT IN date, gT IN varchar, nDaT IN int, rfc IN varchar, heT IN time, hsT IN time)
  AS $$
      BEGIN
	  	INSERT INTO veterinarios(curp,idEstetica,nombreTrabajador,apellidoPaternoTrabajador,apellidoMaternoTrabajador, 
								 estadoTrabajador,calleTrabajador,numeroTrabajador,codigoPostalTrabajador,salarioTrabajador,fechaDeNacimientoTrabajador,generoTrabajador,numeroDePacientesActivosTrabajador,rfcTrabajador,horaEntradaTrabajador,horaSalidaTrabajador) 
		VALUES (cu,idE,nT,apT,amT,eT,cT,numT,cpT,sT,fnT,gT,nDaT,rfc,heT,hsT);
	  END;
  $$
  LANGUAGE 'plpgsql';
  
CREATE OR REPLACE PROCEDURE eliminaVeterinario(cu IN char)
  AS $$
      BEGIN
	  	DELETE FROM veterinarios WHERE curp = cu;
	  END;
  $$
  LANGUAGE 'plpgsql';
  


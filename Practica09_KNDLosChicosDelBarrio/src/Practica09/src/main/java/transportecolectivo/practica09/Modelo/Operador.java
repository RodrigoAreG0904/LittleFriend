package transportecolectivo.practica09.Modelo;

/**
 * Clase que modela a un Operador
 * 
 * @author Santiago Arroyo Lozano
 * @author Rodrigo Arevalo Gaytan
 * @author Julio Cesar Torres Escobedo
 * @author Diana Berenice Hernandez Alonso
 * @version 16-MAYO-2022
 */
public class Operador {
    private String curp;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private int horario;
    private String ciudad;
    private String calle;
    private int cp;

    /**
     * Constructor por parametros que crea un operador
     * 
     * @param curp            -- El CURP del operador
     * @param nombre          -- El nombre del operador
     * @param apellidoPaterno -- El apellido Paterno del operador
     * @param apellidoMaterno -- El apellido Materno del operador
     * @param horario         -- El horario de trabajo del operador
     * @param ciudad          -- La ciudad donde vive el operador
     * @param calle           -- La calle donde vive el operador
     * @param cp              -- El codigo postal donde vive el operador
     */
    public Operador(String curp, String nombre, String apellidoPaterno, String apellidoMaterno, int horario,
            String ciudad, String calle, int cp) {
        this.curp = curp;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.horario = horario;
        this.ciudad = ciudad;
        this.calle = calle;
        this.cp = cp;
    }

    /**
     * Metodo getCurp que obtiene el curp
     * 
     * @return -- String el curp del operador
     */
    public String getCurp() {
        return curp;
    }

    /**
     * Metodo set que define un nuevo curp del operador
     * 
     * @param curp -- El nuevo CURP
     */
    public void setCurp(String curp) {
        this.curp = curp;
    }

    /**
     * Metodo get Nombre que obtiene el nombre de un operador
     * 
     * @return String -- el nombre del operador
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo set que define un nuevo nombre al operador
     * 
     * @param nombre -- El nuevo nombre del operador
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo get que obtiene el apellido paterno del operador
     * 
     * @return String -- el apellido paterno del operador
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Metedo set que define un nuevo apellido paterno al operador
     * 
     * @param apellidoPaterno -- El nuevo apellido paterno del operador
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Metodo get que obtiene el apellido materno del operador
     * 
     * @return String -- el apellido materno del operador
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Metodo set que define un nuevo apellido materno del operador
     * 
     * @param apellidoMaterno -- el nuevo apellido materno
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Metodo get que obtiene el horario de trabajo del operador
     * 
     * @return int -- El horario del trabajador
     */
    public int getHorario() {
        return horario;
    }

    /**
     * Metodo setHorario que define el nuevo horario de trabajo
     * 
     * @param horario -- el nuevo horario de trabajo
     */
    public void setHorario(int horario) {
        this.horario = horario;
    }

    /**
     * Metodo get que obtiene la ciudad del operador
     * 
     * @return String -- la ciudad donde vive el operador
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Metodo set que define una nueva ciudad al operador
     * 
     * @param ciudad -- la nueva ciudad del operador
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Metodo get que obtiene la calle del operador
     * 
     * @return String -- la calle del operador
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Metodo set que define la nueva calle del operador
     * 
     * @param calle -- la nueva calle donde vive el operador
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Metodo get que obtiene el codigo postal del operador
     * 
     * @return int -- el codigo postal del operador
     */
    public int getCp() {
        return cp;
    }

    /**
     * Metodo set que define el nuevo cp del operador
     * 
     * @param cp -- el nuevo codigo postal del operador
     */
    public void setCp(int cp) {
        this.cp = cp;
    }

    /**
     * Metodo toString que imprime un operador
     * 
     * @return String -- lo que define a un operador
     */
    @Override
    public String toString() {
        return "Operador{" + "curp=" + curp + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno
                + ", apellidoMaterno=" + apellidoMaterno + ", horario=" + horario + ", ciudad=" + ciudad + ", calle="
                + calle + ", cp=" + cp + '}';
    }

}

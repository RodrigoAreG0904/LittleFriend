
package practica09.Modelo;

/**
 * Clase que modela a un usuario
 * 
 * @author Santiago Arroyo Lozano
 * @author Rodrigo Arevalo Gaytan
 * @author Julio Cesar Torres Escobedo
 * @author Diana Berenice Hernandez Alonso
 * @version 16-MAYO-2022
 */
public class Usuario {
    private String curp;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nombreUsuario;
    private String contrasenia;
    private String correo;

    /**
     * Constructor por parametros que crea a un usuario
     * 
     * @param curp            -- el curp del usuario
     * @param nombre          -- el nombre del usuario
     * @param apellidoPaterno -- el apellidoPaterno del usuario
     * @param apellidoMaterno -- el apellidoMaterno del usuario
     * @param nombreUsuario   -- el nombreUsuario del usuario
     * @param contrasenia     -- la contrasenia del usuario
     * @param correo          -- el correo del usuario
     */
    public Usuario(String curp, String nombre, String apellidoPaterno, String apellidoMaterno, String nombreUsuario,
            String contrasenia, String correo) {
        this.curp = curp;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.correo = correo;
    }

    /**
     * Metodo get que obtiene el curp del usuario
     * 
     * @return String -- el curp del usuario
     */
    public String getCurp() {
        return curp;
    }

    /**
     * Metodo set que define un nuevo curp del usuario
     * 
     * @param curp -- el nuevo curp del usuario
     */
    public void setCurp(String curp) {
        this.curp = curp;
    }

    /**
     * Metodo get que obtiene el nombre del usuario
     * 
     * @return String -- el nombre del usuario
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo set que define el nuevo nombre del usuario
     * 
     * @param nombre -- el nuevo nombre del ususario
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo get que obtiene el apellido paterno del usuario
     * 
     * @return String -- el apellido paterno del usuario
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Metodo set que define un nuevo apellido paterno al usuario
     * 
     * @param apellidoPaterno -- el nuevo apellido paterno del usuario
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Metodo get que obtiene el apellido materno del usuario
     * 
     * @return String -- el apellido materno del usuario
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Metodo set que define un nuevo apellido materno al usuario
     * 
     * @param apellidoMaterno -- el nuevo apellido materno del usuario
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Metodo get que obtiene el nombre de usuario del usuario
     * 
     * @return String -- el nombre de usuario del usuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * Metodo set que define un nuevo nombre de usuario al usuario
     * 
     * @param nombreUsuario -- el nuevo nombre de usuario
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * Metodo get que obtiene la contrasenia del usuario
     * 
     * @return String -- la contrasenia del usuario
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Metodo set que define una nueva contrasenia del usuario
     * 
     * @param contrasenia -- La nueva contrasenia
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * Metodo get que obtiene el correo del usuario
     * 
     * @return String -- el correo del usuario
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Metodo set que define un nuevo correo de usuario
     * 
     * @param correo -- el nuevo correo
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Metodo toString que imprime a un usuario
     * 
     * @return String -- la representacion de un usuario
     */
    @Override
    public String toString() {
        return "Usuario{" + "curp=" + curp + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno
                + ", apellidoMaterno=" + apellidoMaterno + ", nombreUsuario=" + nombreUsuario + ", contrasenia="
                + contrasenia + ", correo=" + correo + '}';
    }

}

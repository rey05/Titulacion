package angel.reynaldo.titulacion;

/**
 * Created by Angel on 18/05/2015.
 */
public class modelo {
    private String nocontrol;
    private String nombre;
    private String apellidos;
    private String email;
    private String carrera;
    private String egreso;
    private String ot;
    private String fechat;
    private String observaciones;


    public modelo(String nocontrol, String nombre, String apellidos, String email, String carrera, String egreso, String ot, String fechat, String observaciones) {
        this.nocontrol = nocontrol;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.carrera = carrera;
        this.egreso = egreso;
        this.ot = ot;
        this.fechat = fechat;
        this.observaciones = observaciones;

    }

    public String getNocontrol() {
        return nocontrol;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }

    public String getCarrera() {
        return carrera;
    }

    public String getEgreso() {
        return egreso;
    }

    public String getOt() {
        return ot;
    }

    public String getFechat() {
        return fechat;
    }

    public String getObservaciones() {
        return observaciones;
    }
}

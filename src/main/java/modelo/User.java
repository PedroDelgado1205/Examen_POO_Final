package modelo;

public class User{

    private String nombre;
    private String clave;

    public User(String _nombre, String _clave){
        this.nombre = _nombre;
        this.clave = _clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}

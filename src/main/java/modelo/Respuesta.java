package modelo;

public class Respuesta {
    private int id;
    private int idPregunta;
    private String texto;

    public Respuesta(int id, int idPregunta, String texto) {
        this.id = id;
        this.idPregunta = idPregunta;
        this.texto = texto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
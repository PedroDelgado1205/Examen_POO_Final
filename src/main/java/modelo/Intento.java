package modelo;

public class Intento {
    private int id;
    private int idUsuario;
    private int idPregunta;
    private int respuestaElegidaId;

    public Intento(int id, int idUsuario, int idPregunta, int respuestaElegidaId) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idPregunta = idPregunta;
        this.respuestaElegidaId = respuestaElegidaId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public int getRespuestaElegidaId() {
        return respuestaElegidaId;
    }

    public void setRespuestaElegidaId(int respuestaElegidaId) {
        this.respuestaElegidaId = respuestaElegidaId;
    }
}
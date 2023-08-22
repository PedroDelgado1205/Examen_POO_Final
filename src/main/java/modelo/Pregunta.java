package modelo;

import java.util.List;

public class Pregunta {
    private int id;
    private String texto;
    private int respuestaCorrectaId;
    private List<String> opciones;
    private int respuestaCorrecta;

    public Pregunta(int id, String texto, int respuestaCorrectaId) {
        this.id = id;
        this.texto = texto;
        this.respuestaCorrectaId = respuestaCorrectaId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getRespuestaCorrectaId() {
        return respuestaCorrectaId;
    }

    public void setRespuestaCorrectaId(int respuestaCorrectaId) {
        this.respuestaCorrectaId = respuestaCorrectaId;
    }

    public Pregunta(String texto, List<String> opciones, int respuestaCorrecta) {
        this.texto = texto;
        this.opciones = opciones;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public String getTexto() {
        return texto;
    }

    public List<String> getOpciones() {
        return opciones;
    }

    public int getRespuestaCorrecta() {
        return respuestaCorrecta;
    }
}
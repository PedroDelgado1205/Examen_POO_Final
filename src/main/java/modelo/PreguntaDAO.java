package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PreguntaDAO {
    private Connection conexion;

    public PreguntaDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public List<Pregunta> obtenerPreguntas() throws SQLException {
        List<Pregunta> preguntas = new ArrayList<>();

        String query = "SELECT id_pregunta, pregunta_texto, respuesta_correcta_id FROM preguntas";
        try (PreparedStatement statement = conexion.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id_pregunta");
                String texto = resultSet.getString("pregunta_texto");
                int respuestaCorrectaId = resultSet.getInt("respuesta_correcta_id");
                Pregunta pregunta = new Pregunta(id, texto, respuestaCorrectaId);
                preguntas.add(pregunta);
            }
        }

        return preguntas;
    }
}
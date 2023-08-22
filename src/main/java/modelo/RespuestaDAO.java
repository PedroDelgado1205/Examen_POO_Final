package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RespuestaDAO {
    private Connection conexion;

    public RespuestaDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public List<Respuesta> obtenerRespuestasPorPregunta(int idPregunta) throws SQLException {
        List<Respuesta> respuestas = new ArrayList<>();

        String query = "SELECT id_respuesta, respuesta_texto FROM respuestas WHERE id_pregunta = ?";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, idPregunta);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id_respuesta");
                    String texto = resultSet.getString("respuesta_texto");
                    Respuesta respuesta = new Respuesta(id, idPregunta, texto);
                    respuestas.add(respuesta);
                }
            }
        }

        return respuestas;
    }
}
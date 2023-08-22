package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IntentoDAO {
    private Connection conexion;

    public IntentoDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public void registrarIntento(Intento intento) throws SQLException {
        String query = "INSERT INTO respuestas_usuario (id_usuario, id_pregunta, respuesta_elegida_id) VALUES (?, ?, ?)";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setInt(1, intento.getIdUsuario());
            statement.setInt(2, intento.getIdPregunta());
            statement.setInt(3, intento.getRespuestaElegidaId());
            statement.executeUpdate();
        }
    }
}

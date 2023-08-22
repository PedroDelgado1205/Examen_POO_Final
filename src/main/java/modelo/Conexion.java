package modelo;

import java.sql.*;

public class Conexion {
    private String usuario;
    private String contrasena;
    private String ruta;
    private Connection con;
    private Statement st;

    public Conexion() {
        this.usuario = "root";
        this.contrasena = "pemildebra";
        this.ruta ="jdbc:mysql://localhost:3306/examen_poo";
    }

    private void abrirConexion() throws SQLException {
        con = DriverManager.getConnection(ruta, usuario, contrasena);
        st = con.createStatement();
    }

    public String ejecutar(String sql) {
        try {
            abrirConexion();
            st.executeUpdate(sql);
            return "OK";
        } catch (SQLException e) {
            return "Error al ejecutar la consulta: " + e.getMessage();
        } finally {
            cerrarConexion();
        }
    }

    public ResultSet consultar(String sql) {
        ResultSet rs = null;
        try {
            abrirConexion();
            rs = st.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    private void cerrarConexion() {
        try {
            if (st != null) {
                st.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

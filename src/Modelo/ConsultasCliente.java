package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author GUSTAVO
 */
public class ConsultasCliente extends Conexion {

    public boolean registrar(Cliente pro) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO cliente (documento, apellidos, nombres, telefono, correo) VALUES(?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getDocumento());
            ps.setString(2, pro.getApellidos());
            ps.setString(3, pro.getNombres());
            ps.setInt(4, pro.getTelefono());
            ps.setString(5, pro.getCorreo());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean modificar(Cliente pro) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE cliente SET documento=?, apellidos=?, nombres=?, telefono=?, correo=? WHERE id=? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getDocumento());
            ps.setString(2, pro.getApellidos());
            ps.setString(3, pro.getNombres());
            ps.setInt(4, pro.getTelefono());
            ps.setString(5, pro.getCorreo());
            ps.setInt(6, pro.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean eliminar(Cliente pro) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM cliente WHERE id=? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, pro.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean buscar(Cliente pro) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM cliente WHERE documento=? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getDocumento());
            rs = ps.executeQuery();
  
            if (rs.next()) {
                pro.setId(Integer.parseInt(rs.getString("id")));
                pro.setDocumento(rs.getString("documento"));
                pro.setNombres(rs.getString("nombres"));
                pro.setApellidos(rs.getString("apellidos"));
                pro.setTelefono(Integer.parseInt(rs.getString("telefono")));
                pro.setCorreo(rs.getString("correo"));
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}

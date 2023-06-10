package Daos;

import Beans.JugadorBean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JugadorDao extends BaseDao{

    public ArrayList<JugadorBean> listarJugadores() {
        ArrayList<JugadorBean> listaJugadores = new ArrayList<>();

        String sql = "SELECT j.idJugador,\n" +
                "       j.nombre,\n" +
                "       j.edad,\n" +
                "       j.posicion,\n" +
                "       j.club,\n" +
                "       s.nombre\n" +
                "FROM jugador j, seleccion s\n" +
                "where j.sn_idSeleccion = s.idSeleccion";

        try (Connection connection = this.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {

            while (resultSet.next()) {
                JugadorBean jugador = new JugadorBean();
                jugador.setIdJugador(resultSet.getInt(1));
                jugador.setNombre(resultSet.getString(2));
                jugador.setEdad(resultSet.getInt(3));
                jugador.setPosicion(resultSet.getString(4));
                jugador.setClub(resultSet.getString(5));
                jugador.setSeleccion(resultSet.getString(6));

                listaJugadores.add(jugador);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaJugadores;
    }
}

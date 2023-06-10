package Daos;

import Beans.JugadorBean;
import Beans.SeleccionBean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SeleccionDao extends BaseDao{
    public ArrayList<SeleccionBean> listarSelecciones() {
        ArrayList<SeleccionBean> listaSelecciones = new ArrayList<>();

        String sql = "select s.idSeleccion,\n" +
                "       s.nombre,\n" +
                "       s.tecnico,\n" +
                "       e.nombre,\n" +
                "       p.seleccionLocal,\n" +
                "       p.seleccionVisitante,\n" +
                "       p.fecha\n" +
                "from seleccion s, partido p, estadio e\n" +
                "where s.estadio_idEstadio = e.idEstadio\n" +
                "      and (s.idSeleccion = p.seleccionLocal or s.idSeleccion = p.seleccionVisitante)\n" +
                "order by s.idSeleccion ";

        try (Connection connection = this.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {

            while (resultSet.next()) {
                SeleccionBean seleccion = new SeleccionBean();
                seleccion.setIdSeleccion(resultSet.getInt(1));
                seleccion.setNombre(resultSet.getString(2));
                seleccion.setTecnico(resultSet.getString(3));
                seleccion.setNombreEstadio(resultSet.getString(4));
                seleccion.setIdSeleccionLocal(resultSet.getInt(5));
                seleccion.setIdSeleccionVisitante(resultSet.getInt(6));
                seleccion.setFecha(resultSet.getDate(7));

                listaSelecciones.add(seleccion);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaSelecciones;
    }
}

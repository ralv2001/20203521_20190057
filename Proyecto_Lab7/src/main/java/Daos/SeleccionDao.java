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

        String sql = "select s.idSeleccion, \n" +
                "\t   s.nombre, \n" +
                "       s.tecnico, \n" +
                "       e.idEstadio, \n" +
                "       e.nombre,\n" +
                "\t   concat(slocal.nombre,\" vs \", svisitante.nombre) as \"Primer Partido\", \n" +
                "       p.seleccionLocal, \n" +
                "       p.seleccionVisitante,\n" +
                "       p.fecha\n" +
                "\t   from seleccion s\n" +
                "\t   inner join estadio e on s.estadio_idEstadio = e.idEstadio\n" +
                "\t   left join partido p on p.seleccionLocal = s.idSeleccion or p.seleccionVisitante = s.idSeleccion\n" +
                "\t   left join seleccion slocal on slocal.idSeleccion = p.seleccionLocal\n" +
                "\t   left join seleccion svisitante on svisitante.idSeleccion = p.seleccionVisitante\n" +
                "\t   where p.fecha = (select MIN(fecha) from partido \n" +
                "                        where seleccionLocal = s.idSeleccion or seleccionVisitante = s.idSeleccion)\n" +
                "\t\t\t or not exists (select 1 from partido p2 \n" +
                "                            where p2.seleccionLocal = s.idSeleccion or p2.seleccionVisitante = s.idSeleccion)";

        try (Connection connection = this.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {

            while (resultSet.next()) {
                SeleccionBean seleccion = new SeleccionBean();
                seleccion.setIdSeleccion(resultSet.getInt(1));
                seleccion.setNombre(resultSet.getString(2));
                seleccion.setTecnico(resultSet.getString(3));
                seleccion.setIdEstadio(resultSet.getInt(4));
                seleccion.setNombreEstadio(resultSet.getString(5));
                seleccion.setPrimerPartido(resultSet.getString(6));
                seleccion.setIdSeleccionLocal(resultSet.getInt(7));
                seleccion.setIdSeleccionVisitante(resultSet.getInt(8));
                seleccion.setFecha(resultSet.getDate(9));

                listaSelecciones.add(seleccion);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaSelecciones;
    }
}

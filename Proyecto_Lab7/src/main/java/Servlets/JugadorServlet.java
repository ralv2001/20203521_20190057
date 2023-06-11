package Servlets;

import Beans.JugadorBean;
import Beans.SeleccionBean;
import Daos.JugadorDao;

import Daos.SeleccionDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "JugadorServlet", urlPatterns = {"/JugadorServlet"})
public class JugadorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "lj" : request.getParameter("action");
        RequestDispatcher view;

        switch (action) {
            case "lj":
                JugadorDao jugadores = new JugadorDao();
                ArrayList<JugadorBean> listaJugadores = jugadores.listarJugadores();
                request.setAttribute("listaJugadores", listaJugadores);

                view = request.getRequestDispatcher("listaJugadores.jsp");
                view.forward(request, response);
                break;
            case "aj":
                SeleccionDao selecciones = new SeleccionDao();
                ArrayList<SeleccionBean> listaSelecciones= selecciones.listarSelecciones();
                request.setAttribute("listaSelecciones", listaSelecciones);

                view = request.getRequestDispatcher("formularioNuevoJugador.jsp");
                view.forward(request, response);
                break;

        }

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        JugadorBean posibleJugador = new JugadorBean();
        SeleccionBean seleccion=new SeleccionBean();

        String nombre=request.getParameter("nombre");
        String edad=request.getParameter("edad");
        String posicion=request.getParameter("posicion");
        String club=request.getParameter("club");
        String idSeleccion=request.getParameter("seleccion");

        int idSeleccionEntero=Integer.parseInt(idSeleccion);

        seleccion.setIdSeleccion(idSeleccionEntero);

        try{
            int edadEntera=Integer.parseInt(edad);
            posibleJugador.setNombre(nombre);
            posibleJugador.setEdad(edadEntera);
            posibleJugador.setPosicion(posicion);
            posibleJugador.setClub(club);
            posibleJugador.setIdSeleccion(idSeleccionEntero);

            boolean mismoNombreSeleccion = false;
            JugadorDao listajugadores = new JugadorDao();
            for(JugadorBean jugador1:listajugadores.listarJugadores()){
                if((posibleJugador.getNombre().equals(jugador1.getNombre())) && (posibleJugador.getIdSeleccion()== jugador1.getIdSeleccion())){
                    mismoNombreSeleccion=true;
                    break;
                }
            }

            boolean validarDatosLlenos = posibleJugador.getNombre().isEmpty() || posibleJugador.getEdad()<=18 || posibleJugador.getPosicion().isEmpty() || posibleJugador.getClub().isEmpty()|| posibleJugador.getIdSeleccion()==0;

            if( mismoNombreSeleccion==false && validarDatosLlenos==false){
                JugadorDao jugador = new JugadorDao();
                jugador.agregarJugador(posibleJugador);
                response.sendRedirect(request.getContextPath() + "/JugadorServlet?action=lj");
            }else{
                response.sendRedirect(request.getContextPath() + "/JugadorServlet?action=aj");
            }

        }catch (NumberFormatException e){
            response.sendRedirect(request.getContextPath() + "/JugadorServlet?action=aj");
        }
    }

}

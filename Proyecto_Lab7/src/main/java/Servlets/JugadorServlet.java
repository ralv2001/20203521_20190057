package Servlets;

import Beans.JugadorBean;
import Daos.JugadorDao;

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

        }

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

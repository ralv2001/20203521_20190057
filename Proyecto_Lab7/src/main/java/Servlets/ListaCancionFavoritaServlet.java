package Servlets;

import Beans.Cancion;
import Daos.ListaCancionDao;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ListaCancionFavoritaServlet", value = "/listaCancioneFavoritas")
public class ListaCancionFavoritaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "listar" : request.getParameter("action");
        RequestDispatcher view;

        switch (action) {
            case "listar":
                ListaCancionDao listaCancionFavoritaDao = new ListaCancionDao();
                ArrayList<Cancion> listaCancionesFavoritas = listaCancionFavoritaDao.obtenerListaCancionesFavoritas();
                request.setAttribute("listaCancionesFavoritas", listaCancionesFavoritas);

                view = request.getRequestDispatcher("listaCancionesFavoritas.jsp");
                view.forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

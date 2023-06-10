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

@WebServlet(name = "SeleccionServlet", value = "/SeleccionServlet")
public class SeleccionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "ls" : request.getParameter("action");
        RequestDispatcher view;

        switch (action) {
            case "ls":
                SeleccionDao selecciones = new SeleccionDao();
                ArrayList<SeleccionBean> listaSelecciones = selecciones.listarSelecciones();
                request.setAttribute("listaSelecciones", listaSelecciones);

                view = request.getRequestDispatcher("listaSelecciones.jsp");
                view.forward(request, response);
                break;

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

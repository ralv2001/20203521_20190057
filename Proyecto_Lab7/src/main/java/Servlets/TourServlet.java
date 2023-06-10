package Servlets;

import Beans.Tour;
import Daos.TourDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "TourServlet",urlPatterns = {"/listaTours"})
public class TourServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TourDao tourDao = new TourDao();
        ArrayList<Tour> listaTours = tourDao.obtenerListaTours();

        request.setAttribute("listaTours",listaTours);

        RequestDispatcher view =request.getRequestDispatcher("listaTours.jsp");
        view.forward(request,response);
    }
}

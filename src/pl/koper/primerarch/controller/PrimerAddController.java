package pl.koper.primerarch.controller;

import pl.koper.primerarch.model.User;
import pl.koper.primerarch.service.PrimerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class PrimerAddController extends HttpServlet {
    private static final Long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String sequence = request.getParameter("inputName");
        String description = request.getParameter("inputDescription");
        User authenticatedUser = (User) request.getSession().getAttribute("user");
        if(request.getUserPrincipal() != null) {
            PrimerService primerService = new PrimerService();
            primerService.addPrimer(sequence, description, authenticatedUser);
            response.sendRedirect(request.getContextPath() + "/");
        } else {
            response.sendError(403);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getUserPrincipal() != null) {
            request.getRequestDispatcher("new.jsp").forward(request, response);
        } else {
            response.sendError(403);
        }
    }
}

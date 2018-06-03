package pl.koper.primerarch.controller;

import pl.koper.primerarch.model.Primer;
import pl.koper.primerarch.service.PrimerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

@WebServlet("")
public class HomeController extends HttpServlet {
    private static final Long serialVerionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        savePrimersInRequest(request);
        request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
    }
    private void savePrimersInRequest(HttpServletRequest request) {
        PrimerService primerService = new PrimerService();
        List<Primer> allPrimers = primerService.getAllPrimers(new Comparator<Primer>() {
            // the more usages one primer has the higher it is positioned
            @Override
            public int compare(Primer primer1, Primer primer2) {

                int p1Vote = primer1.getUpVote()-primer1.getDownVote();
                int p2Vote = primer2.getUpVote()-primer2.getDownVote();
                if(p1Vote<p2Vote) {
                    return 1;
                } else if (p1Vote>p2Vote) {
                    return -1;
                }
                return 0;
            }
        });
        request.setAttribute("primers", allPrimers);
    }
}

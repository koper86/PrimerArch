package pl.koper.primerarch.controller;

import pl.koper.primerarch.model.Primer;
import pl.koper.primerarch.model.User;
import pl.koper.primerarch.model.Vote;
import pl.koper.primerarch.model.VoteType;
import pl.koper.primerarch.service.PrimerService;
import pl.koper.primerarch.service.VoteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/vote")
public class VoteController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User loggedUser = (User) request.getSession().getAttribute("user");
        if (loggedUser != null) {
            VoteType voteType = VoteType.valueOf(request.getParameter("vote"));
            long userId = loggedUser.getId();
            long primerId = Long.parseLong(request.getParameter("primer_id"));
            updateVote(userId, primerId, voteType);

        }
        response.sendRedirect(request.getContextPath()+"/");
    }
    private void updateVote(long userId, long primerId, VoteType voteType) {
        VoteService voteService = new VoteService();
        Vote existingVote = voteService.getVoteByPrimerUserId(primerId, userId);
        Vote updatedVote = voteService.addOrUpdateVote(userId, primerId, voteType);
        if (existingVote != updatedVote || !updatedVote.equals(existingVote)) {
            updatePrimer(primerId, existingVote, updatedVote);
        }
    }
    private void updatePrimer(long primerId, Vote oldVote, Vote newVote) {
        PrimerService primerService = new PrimerService();
        Primer primerById = primerService.getPrimerById(primerId);
        Primer updatedPrimer = null;
        if(oldVote == null && newVote != null) {
            updatedPrimer = addPrimerVote(primerById, newVote.getVoteType());
        } else if(oldVote != null && newVote != null) {
            updatedPrimer = removeDiscoveryVote(primerById, oldVote.getVoteType());
            updatedPrimer = addPrimerVote(updatedPrimer, newVote.getVoteType());
        }
        primerService.updatePrimer(updatedPrimer);
    }
    private Primer addPrimerVote(Primer primer, VoteType voteType) {
        Primer primerCopy = new Primer(primer);
        if(voteType == VoteType.VOTE_UP) {
            primerCopy.setUpVote(primerCopy.getUpVote() + 1);
        } else if(voteType == VoteType.VOTE_DOWN) {
            primerCopy.setDownVote(primerCopy.getDownVote() + 1);
        }
        return primerCopy;
    }

    private Primer removeDiscoveryVote(Primer primer, VoteType voteType) {
        Primer primerCopy = new Primer(primer);
        if(voteType == VoteType.VOTE_UP) {
            primerCopy.setUpVote(primerCopy.getUpVote() - 1);
        } else if(voteType == VoteType.VOTE_DOWN) {
            primerCopy.setDownVote(primerCopy.getDownVote() - 1);
        }
        return primerCopy;
    }
}

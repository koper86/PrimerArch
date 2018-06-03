package pl.koper.primerarch.service;

import pl.koper.primerarch.dao.DAOFactory;
import pl.koper.primerarch.dao.VoteDAO;
import pl.koper.primerarch.model.Vote;
import pl.koper.primerarch.model.VoteType;

import java.sql.Timestamp;
import java.util.Date;

public class VoteService {
    public Vote addVote(long primerId, long userId, VoteType voteType) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        VoteDAO voteDAO = factory.getVoteDAO();
        Vote vote = new Vote();
        vote.setPrimerid(primerId);
        vote.setUserid(userId);
        vote.setDate(new Timestamp(new Date().getTime()));
        vote.setVoteType(voteType);
        vote = voteDAO.create(vote);
        return  vote;
    }
    public Vote updateVote(long primerId, long userId, VoteType voteType) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        VoteDAO voteDAO = factory.getVoteDAO();
        Vote voteToUpdate = voteDAO.getVoteByUserIdPrimerId(userId, primerId);
        if (voteToUpdate != null) {
            voteToUpdate.setVoteType(voteType);
            voteDAO.update(voteToUpdate);
        }
        return voteToUpdate;

    }
    public Vote addOrUpdateVote(long primerId, long userId, VoteType voteType) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        VoteDAO voteDAO = factory.getVoteDAO();
        Vote vote = voteDAO.getVoteByUserIdPrimerId(userId, primerId);
        Vote resultVote = null;
        if(vote == null) {
            resultVote = addVote(primerId, userId, voteType);
        } else {
            resultVote = updateVote(primerId, userId, voteType);
        }
        return resultVote;
    }
    public Vote getVoteByPrimerUserId(long primerId, long userId) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        VoteDAO voteDAO = factory.getVoteDAO();
        Vote vote = voteDAO.getVoteByUserIdPrimerId(userId, primerId);
        return vote;
    }
}

package pl.koper.primerarch.dao;

import pl.koper.primerarch.model.Vote;

public interface VoteDAO extends GenericDAO<Vote, Long>{

    Vote getVoteByUserIdPrimerId(long userId, long primerId);
}

package pl.koper.primerarch.dao;

public abstract class DAOFactory {
    public abstract PrimerDAO getPrimerDAO();

    public abstract UserDAO getUserDAO();

    public abstract VoteDAO getVoteDAO();


}

package pl.koper.primerarch.dao;

public class MySQLDAOFactory extends DAOFactory{
    @Override
    public PrimerDAO getPrimerDAO() {
        return new PrimerDAOImpl();
    }

    @Override
    public UserDAO getUserDAO() {
        return new UserDAOImpl();
    }

    @Override
    public VoteDAO getVoteDAO() {
        return new VoteDAOImpl();
    }
}

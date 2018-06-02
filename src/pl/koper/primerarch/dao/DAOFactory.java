package pl.koper.primerarch.dao;

import pl.koper.primerarch.exception.NoSuchDbTypeException;

public abstract class DAOFactory {

    public static final int MYSQL_DAO_DACTORY = 1;

    public abstract PrimerDAO getPrimerDAO();

    public abstract UserDAO getUserDAO();

    public abstract VoteDAO getVoteDAO();

    public static DAOFactory getDAOFactory() {
        DAOFactory factory = null;
        try {
            factory = getDAOFactory(MYSQL_DAO_DACTORY);
        } catch (NoSuchDbTypeException e) {
            e.printStackTrace();
        }
        return factory;
    }
    private static DAOFactory getDAOFactory(int type) throws NoSuchDbTypeException {
        switch (type) {
            case MYSQL_DAO_DACTORY:
                return new MySQLDAOFactory();
            default:
                throw new NoSuchDbTypeException();
        }
    }

}

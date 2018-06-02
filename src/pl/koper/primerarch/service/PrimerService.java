package pl.koper.primerarch.service;

import pl.koper.primerarch.dao.DAOFactory;
import pl.koper.primerarch.dao.PrimerDAO;
import pl.koper.primerarch.model.Primer;
import pl.koper.primerarch.model.User;

import java.sql.Timestamp;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class PrimerService {
    public void addPrimer(String sequence, String desc, User user) {
        Primer primer = createPrimerObject(sequence, desc, user);
        DAOFactory factory = DAOFactory.getDAOFactory();
        PrimerDAO primerDAO = factory.getPrimerDAO();
        primerDAO.create(primer);
    }

    private Primer createPrimerObject(String sequence, String desc, User user) {
        Primer primer = new Primer();
        primer.setSequence(sequence);
        primer.setDescription(desc);
        User userCopy = new User(user);
        primer.setUser(userCopy);
        primer.setTimestamp(new Timestamp(new Date().getTime()));
        return primer;

    }
    public List<Primer> getAllPrimers() {
        return getAllPrimers(null);
    }
    public List<Primer> getAllPrimers(Comparator<Primer> comparator) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        PrimerDAO primerDAO = factory.getPrimerDAO();
        List<Primer> primers = primerDAO.getAll();
        if(comparator != null && primers != null) {
            primers.sort(comparator);
        }
        return primers;
    }
}

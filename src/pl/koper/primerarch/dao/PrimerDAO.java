package pl.koper.primerarch.dao;

import pl.koper.primerarch.model.Primer;

import java.util.List;

public interface PrimerDAO extends GenericDAO <Primer, Long>{

    List<Primer> getAll();
}
